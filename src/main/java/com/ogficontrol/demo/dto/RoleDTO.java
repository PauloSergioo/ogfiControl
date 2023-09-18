package com.ogficontrol.demo.dto;

import com.ogficontrol.demo.entities.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {

	private Long id;
	private String authority;
	
	public RoleDTO() {
	}

	public RoleDTO(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public RoleDTO(Role role) {
		super();
		id = role.getId();
		authority = role.getAuthority();
	}
}
