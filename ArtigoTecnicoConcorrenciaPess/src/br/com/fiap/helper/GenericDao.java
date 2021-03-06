package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

public class GenericDao<T> implements Dao<T> {
	private final Class<T> classe; protected EntityManager em;
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	@Override
	public void adicionar(T entidade, LockModeType lock) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.lock(entidade, lock);
		em.close();
	}
	@SuppressWarnings("unchecked") @Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " +
				classe.getSimpleName()).getResultList();
	}
	@Override
	public void atualizar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}
	@Override
	public void remover(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
	}
	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe,id);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}
	@Override
	public String toString()
	{
		return "GenericDao [classe=" + classe + ", em=" + em + "]";
	}
}