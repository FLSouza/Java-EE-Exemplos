package br.com.livraria.dao;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivrariaException extends Exception {

}
