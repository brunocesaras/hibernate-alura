package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

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
		
		JPAUtil jpa = new JPAUtil();
		
		EntityManager em= JPAUtil.getEntityManager();
		
		em.getTransaction().begin();		
		ProdutoDao dao = new ProdutoDao(em);
		dao.cadastrar(celular);
		dao.cadastrar(calculadora);
		em.getTransaction().commit();
		em.close();
	}
}
