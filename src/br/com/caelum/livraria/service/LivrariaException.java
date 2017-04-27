package br.com.caelum.livraria.service;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivrariaException extends RuntimeException {
	
	
}
