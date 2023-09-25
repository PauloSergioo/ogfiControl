package com.ogficontrol.demo.resources;

import java.net.URI;

import com.ogficontrol.demo.dto.UserDTO;
import com.ogficontrol.demo.dto.UserInsertDTO;
import com.ogficontrol.demo.dto.UserUpdateDTO;
import com.ogficontrol.demo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "Users", description = "Controller for Users")
public class UserResource {

	@Autowired
	private UserService service;

	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(produces = "application/json")
	public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
		Page<UserDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}

	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		UserDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@GetMapping(value = "/me", produces = "application/json")
	public ResponseEntity<UserDTO> findMe() {
		UserDTO dto = service.findMe();
		return ResponseEntity.ok().body(dto);
	}

	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@PostMapping(produces = "application/json")
	public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserInsertDTO dto) {
		UserDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@PutMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto) {
		UserDTO newDto = service.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}

	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
} 
