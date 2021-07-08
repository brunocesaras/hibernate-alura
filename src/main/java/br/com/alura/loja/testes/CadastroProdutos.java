package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroProdutos {

	public static void main(String[] args) {

		Produto celular = new Produto();
		celular.setNome("xiaomi");
		celular.setDescricao("celular de última geração");
		celular.setPreco(new BigDecimal("8000"));
		
		Produto calculadora = new Produto();
		celular.setNome("calculadora legal");
		celular.setDescricao("a melhor calc");
		celular.setPreco(new BigDecimal("3000"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(celular);
		em.persist(calculadora);
		em.getTransaction().commit();
		em.close();
	}
}
