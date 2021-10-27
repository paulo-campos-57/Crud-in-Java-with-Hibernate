package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Pessoa;
import Model.utill.JPAutill;
import dao.PessoaDAO;

public class PessoaDAOImpl implements PessoaDAO {

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void salvar(Pessoa pessoa) {
		try {
			this.em = JPAutill.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(pessoa);
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void alterar(Pessoa pessoa) {
		try {
			this.em = JPAutill.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(pessoa);
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void remover(Integer numero) {
		try {
			this.em = JPAutill.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Pessoa.class, numero));
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Pessoa pesquisar(Integer numero) {
		Pessoa pessoa = new Pessoa();
		try {
			this.em = JPAutill.getEntityManager();
			pessoa = em.find(Pessoa.class, numero);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return pessoa;
	}

	@Override
	public List<Pessoa> listarTodos() {
		this.em = JPAutill.getEntityManager();
		Query query = em.createQuery("from Pessoa e");
		List<Pessoa> listaPessoa = query.getResultList();
		em.close();
		return listaPessoa;
	}

}
