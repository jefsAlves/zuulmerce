package com.alvesjefs.zuulmerce.services.exceptions;

import java.io.Serializable;

public class NameNotFoundException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public NameNotFoundException() {
	}

	public NameNotFoundException(String msg) {
		super(msg);
	}

}
