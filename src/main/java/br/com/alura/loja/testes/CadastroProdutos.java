package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroProdutos {

	public static void main(String[] args) {

		Categoria celulares = new Categoria("CELULAR");
		Produto celular = new Produto();
		celular.setNome("xiaomi");
		celular.setDescricao("celular de última geração");
		celular.setPreco(new BigDecimal("8000"));
		celular.setCategoria(celulares);
		
		Categoria eletronicos = new Categoria("ELETRONICO");
		Produto calculadora = new Produto();
		calculadora.setNome("calculadora legal");
		calculadora.setDescricao("a melhor calc");
		calculadora.setPreco(new BigDecimal("3000"));
		calculadora.setCategoria(eletronicos);
				
		EntityManager em= JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtosDao = new ProdutoDao(em);
	
		categoriaDao.cadastrar(celulares);
		produtosDao.cadastrar(celular);
		
		categoriaDao.cadastrar(eletronicos);
		produtosDao.cadastrar(calculadora);
		em.getTransaction().commit();
		em.close();
	}
}
