package com.exsoloscript.uhcutils.exception;

public class PlayerOfflineException extends RuntimeException {

	private static final long serialVersionUID = -4323556532139663814L;

	public PlayerOfflineException() {
		super();
	}

	public PlayerOfflineException(String s) {
		super(s);
	}

	public PlayerOfflineException(Throwable t) {
		super(t);
	}

}
