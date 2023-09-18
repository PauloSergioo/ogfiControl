package com.ogficontrol.demo.config.customgrant;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class CustomUserAuthorities {

	private String username;
	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserAuthorities(String username, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.authorities = authorities;
	}

}
