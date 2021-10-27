package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Endereco;
import Model.utill.JPAutill;
import dao.EnderecoDAO;

public class EnderecoDAOImpl implements EnderecoDAO {

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void salvar(Endereco endereco) {
		try {
			this.em = JPAutill.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(endereco);
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
	public void alterar(Endereco endereco) {
		try {
			this.em = JPAutill.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(endereco);
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
	public void remover(Integer id) {
		try {
			this.em = JPAutill.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Endereco.class, id));
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
	public Endereco pesquisar(Integer id) {
		Endereco endereco = new Endereco();
		try {
			this.em = JPAutill.getEntityManager();
			endereco = em.find(Endereco.class, id);
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
		return endereco;
	}

	@Override
	public List<Endereco> listarTodos() {
		this.em = JPAutill.getEntityManager();
		Query query = em.createQuery("from Endereco e");
		List<Endereco> listaEndereco = query.getResultList();
		em.close();
		return listaEndereco;
	}

}
