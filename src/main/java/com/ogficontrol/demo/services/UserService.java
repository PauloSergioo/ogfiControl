package com.ogficontrol.demo.services;

import com.ogficontrol.demo.dto.RoleDTO;
import com.ogficontrol.demo.dto.UserDTO;
import com.ogficontrol.demo.dto.UserInsertDTO;
import com.ogficontrol.demo.dto.UserUpdateDTO;
import com.ogficontrol.demo.entities.Role;
import com.ogficontrol.demo.entities.User;
import com.ogficontrol.demo.projection.UserDetailsProjection;
import com.ogficontrol.demo.repositories.RoleRepository;
import com.ogficontrol.demo.repositories.UserRepository;
import com.ogficontrol.demo.services.exceptions.DatabaseException;
import com.ogficontrol.demo.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AuthService authService;

	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> list = repository.findAll(pageable);
		return list.map(UserDTO::new);
	}

	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}

	public UserDTO findMe() {
		User entity = authService.authenticated();
		return new UserDTO(entity);
	}

	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);

		entity.getRoles().clear();
		Role role = roleRepository.findByAuthority("ROLE_USER");
		entity.getRoles().add(role);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			Optional<User>  optionalEntity = repository.findById(id);
			if (optionalEntity.isEmpty()) {
				throw new ResourceNotFoundException("Id not found " + id);
			}
			User entity = optionalEntity.get();
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

    public void delete(Long id) {
    	if (!repository.existsById(id)) {
    		throw new ResourceNotFoundException("Recurso não encontrado");
    	}
    	try {
            repository.deleteById(id);    		
    	}
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
	
	private void copyDtoToEntity(UserDTO dto, User entity) {

		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		
		entity.getRoles().clear();

		for (RoleDTO roleDto : dto.getRoles()) {
			Optional<Role> optionalRole = roleRepository.findById(roleDto.getId());

			if (optionalRole.isPresent()) {
				Role role = optionalRole.get();
				entity.getRoles().add(role);
			} else {
				throw new ResourceNotFoundException("Role with ID " + roleDto.getId() + " not found.");
			}
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
		if (result.isEmpty()) {
			throw new UsernameNotFoundException("Email not found");
		}
		
		User user = new User();
		user.setEmail(result.get(0).getUsername());
		user.setPassword(result.get(0).getPassword());
		for (UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}
		
		return (UserDetails) user;
	}
}
