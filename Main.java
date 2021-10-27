package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Model.Conta;
import Model.Endereco;
import Model.Pessoa;
import Model.utill.JPAutill;
import dao.impl.PessoaDAOImpl;

public class Main {

	public static void main(String args[]) {

		EntityManager em = JPAutill.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.close();

		
		 Conta conta = new Conta(); 
		 conta.setNumero(9934);
		 conta.setSaldo(25000d); 
		 conta.setLimite(5200d);
		 //ContaDAOImpl contaDao = new ContaDAOImpl();
		 
		 //contaDao.salvar(conta); // insere a conta no banco
		 //contaDao.pesquisar(9934); // pesquisa a conta no banco
		 
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Piedade");
		endereco.setNumero(64);
		endereco.setComplement("Casa");

		//EnderecoDAOImpl enderecoDAO = new EnderecoDAOImpl();

		//enderecoDAO.salvar(endereco); // insere o endereço no banco
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("25490345780");
		pessoa.setNome("Marcela Lima");
		pessoa.setIdade(27);
		pessoa.setSexo("F");
		pessoa.setConta(conta);
		pessoa.setEndreco(endereco);
		
		PessoaDAOImpl pessoaDAO = new PessoaDAOImpl(); 
		
		//pessoaDAO.salvar(pessoa); // insere a pessoa no banco
		pessoaDAO.listarTodos(); // lista todos os itens da classe pessoa
	}
}
