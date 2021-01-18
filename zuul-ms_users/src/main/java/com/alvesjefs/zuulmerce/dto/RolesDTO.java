package com.alvesjefs.zuulmerce.dto;

import java.io.Serializable;

import com.alvesjefs.zuulmerce.domain.Roles;

public class RolesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String rolesName;

	public RolesDTO() {
	}

	public RolesDTO(Long id, String rolesName) {
		this.id = id;
		this.rolesName = rolesName;
	}

	public RolesDTO(Roles roles) {
		id = roles.getId();
		rolesName = roles.getRoleName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

}
