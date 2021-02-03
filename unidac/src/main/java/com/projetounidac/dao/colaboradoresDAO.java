package com.projetounidac.dao;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.projetounidac.entidade.colaboradores;

import util.JpaUtil;

public class colaboradoresDAO {

	public int validaUnicidadeCafe(colaboradores colaboradores) {
		Query persistableQuery = entityManager.createNativeQuery("SELECT COUNT (CAFEMANHA) FROM TBCOLABORADORES WHERE CAFEMANHA=" colaboradores.getCafeManha();
		persistableQuery.executeUpdate();
	}
	
	public int validaUnicidadeCPF(colaboradores colaboradores) {
		Query persistableQuery = entityManager.createNativeQuery("SELECT COUNT (CPF) FROM TBCOLABORADORES WHERE CPF=" colaboradores.getCpf();
		persistableQuery.executeUpdate();
	}
	
	
	public boolean insert(colaboradores colaboradores) {
		Date saveDate = new Date();
		java.sql.Timestamp timeStampDate = new Timestamp(saveDate.getTime());
		Query persistableQuery = entityManager.createNativeQuery("INSERT INTO TBCOLABORADORES (ID, CPF, NOME, CAFEMANHA) VALUES "(colaboradores.getId() "," colaboradores.getCpf() "," colaboradores.getNome() "," colaboradores.getCafeManha()")";
		persistableQuery.executeUpdate();
	}
	
	public boolean delete(colaboradores colaboradores) {
		Query persistableQuery = entityManager.createNativeQuery("DELETE FROM TBCOLABORADORES WHERE"(colaboradores.getCpf()"= CPF"")";
		persistableQuery.executeUpdate();
	}
	
	public boolean search(colaboradores colaboradores) {
		Query persistableQuery = entityManager.createNativeQuery("SELECT * FROM TBCOLABORADORES WHERE"(colaboradores.getCpf()"= CPF"")";
		persistableQuery.executeUpdate();
	}
	
	public boolean listagem(colaboradores colaboradores) {
		Query persistableQuery = entityManager.createNativeQuery("SELECT * FROM TBCOLABORADORES";
		persistableQuery.executeUpdate();
	}
}
