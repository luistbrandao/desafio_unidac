package com.projetounidac.managebean;

import com.projetounidac.entidade.colaboradores;
import com.projetounidac.manager.colaboradoresManager;

public class colaboradoresMB {
	
	private colaboradoresManager colaboradoresManager;
	private colaboradores col;

	public void salvar() throws Exception {
		colaboradoresManager.validarInformacoes(col);
		colaboradoresManager.salvar(col);
	}
	
	public void deletar() {
		colaboradoresManager.deletar(col);
	}
	
	public void procurar() {
		colaboradoresManager.procurar(col);
	}
}
