package com.projetounidac.auxiliar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mensagem {

	private String chave;
	private List<String> parametros = new ArrayList<String>();

	public Mensagem() {
		// Construtor padr�o
	}

	public Mensagem(String chave, List<String> parametros) {
		if (chave == null) {
			throw new IllegalArgumentException("A chave n�o pode ser nula!");
		}
		this.chave = chave;
		this.parametros.addAll(parametros);
	}

	public Mensagem(String chave, String... parametros) {
		this(chave, Arrays.asList(parametros));
	}

	/**
	 * Recupera a chave da mensagem.
	 * 
	 * @return chave da mensagem.
	 */
	
	public String getChave() {
		return chave;
	}

	/**
	 * Configura a chave da mensagem.
	 * 
	 * @param chave
	 *            chave da mensagem.
	 */
	public void setChave(String chave) {
		this.chave = chave;
	}

	/**
	 * Recupera os par�metros da mensagem.
	 * 
	 * @return par�metros da mensagem.
	 */
	public List<String> getParametros() {
		return parametros;
	}

	/**
	 * Configura os par�metros da mensagem.
	 * 
	 * @param parametros
	 *            par�metros da mensagem.
	 */
	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}

	
}
