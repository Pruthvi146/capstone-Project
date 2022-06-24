package com.info.exception;

public class ProductsNotFoundException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductsNotFoundException(String message) {
		super(message);
	}
}
