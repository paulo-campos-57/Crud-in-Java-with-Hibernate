package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Model.Conta;
import Model.utill.JPAutill;
import dao.ContaDAO;

public class ContaDAOImpl implements ContaDAO {

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void salvar(Conta conta) {
		try {
			this.em = JPAutill.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(conta);
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
	public void alterar(Conta conta) {
		try {
			this.em = JPAutill.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(conta);
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
			em.remove(em.find(Conta.class, numero));
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
	public Conta pesquisar(Integer numero) {
		Conta conta = new Conta();
		try {
			this.em = JPAutill.getEntityManager();
			conta = em.find(Conta.class, numero);
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
		return conta;
	}

	@Override
	public List<Conta> listarTodos() {
		this.em = JPAutill.getEntityManager();
		Query query = em.createQuery("from Conta e");
		List<Conta> listaConta = query.getResultList();
		em.close();
		return listaConta;
	}

}
