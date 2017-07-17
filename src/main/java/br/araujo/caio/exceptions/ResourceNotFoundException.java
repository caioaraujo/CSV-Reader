package br.araujo.caio.exceptions;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -6442814193386256673L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
