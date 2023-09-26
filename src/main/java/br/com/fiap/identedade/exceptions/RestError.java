package br.com.fiap.identedade.exceptions;

public record RestError (
	    int cod,
	    String message
	) {}
