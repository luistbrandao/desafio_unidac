package com.projetounidac.manager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.projetounidac.auxiliar.Mensagem;
import com.projetounidac.dao.colaboradoresDAO;
import com.projetounidac.entidade.colaboradores;

public class colaboradoresManager {
	
	colaboradoresDAO dao;

	public void validarInformacoes(colaboradores col) throws Exception {
		validarCamposObrigatorios(col);
		validaCPF(col);
		validaUnicidadeCafe(col);
		validaUnicidadeCPF(col);
		
	}
	
	public void salvar(colaboradores colaboradores) {
		dao.insert(colaboradores);
	}
	
	public void deletar(colaboradores colaboradores) {
		dao.delete(colaboradores);
	}
	
	public void procurar(colaboradores colaboradores) {
		dao.search(colaboradores);
	}
	
	private void validaUnicidadeCafe(colaboradores colaboradores) {
		if(dao.validaUnicidadeCafe(colaboradores) > 1) {
			final List<Mensagem> erro = new ArrayList<Mensagem>();
			erro.add(new Mensagem("Café da manhã já escolhido!"));
		}
	}
	
	private void validaUnicidadeCPF(colaboradores colaboradores) {
		if(dao.validaUnicidadeCPF(colaboradores) > 1) {
			final List<Mensagem> erro = new ArrayList<Mensagem>();
			erro.add(new Mensagem("CPF já cadastrado!"));
		}
	}
	
	private void validarCamposObrigatorios(colaboradores colaboradores) throws Exception {
		final List<Mensagem> erros = new ArrayList<Mensagem>();
		
		if(colaboradores.getNome().isEmpty()) {
			erros.add(new Mensagem("Campo nome é de preenchimento obrigatório"));
		}
		
		if(colaboradores.getCafeManha().isEmpty()) {
			erros.add(new Mensagem("Campo Café da Manhã é de preenchimento obrigatório"));
		}
		
		if(colaboradores.getCpf().isEmpty()) {
			erros.add(new Mensagem("Campo CPF é de preenchimento obrigatório"));
		}
		
		if (!erros.isEmpty()) {
			throw new Exception();
		}
	}
	
	private void validaCPF(colaboradores colaboradores) {
		if(!isCPF(colaboradores.getCpf())) {
			final List<Mensagem> mensagens = new ArrayList<Mensagem>();
			mensagens.add(new Mensagem("CPF inválido"));
		}
	}
	
	public static boolean isCPF(String CPF) {
		
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
            	num = (int)(CPF.charAt(i) - 48);
            	sm = sm + (num * peso);
            	peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 
            
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }

        public static String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }
}
