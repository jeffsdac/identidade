package br.com.fiap.identedade.models;

public record Token(
	    String token,
	    String type,
	    String prefix
	) {}