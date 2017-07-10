package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Usuario;

public class Helper {
	private EntityManager em;

	public Helper(EntityManager em){
		this.em = em;
	}

	public void salvar(Usuario user) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(user); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//JPQL: Usando Query
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuario(){
		Query query = em.createQuery("select u from Usuario u"); 
		return query.getResultList();
		
		//Alternativa
		//TypedQuery<Funcionario> tQuery = em.createQuery("select f from Funcionario f", Funcionario.class); 
		//return tQuery.getResultList();
	}

	
	public Usuario buscarUsuario(int id){
		Usuario user = this.em.find(Usuario.class, id);
		return user;
	}
	

	
	//JPQL: usando NamedQuery
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(){
		Query query = em.createNamedQuery("Usuario.findAll");
		return query.getResultList();
		
		//Alternativa
		//TypedQuery<Funcionario> tQuery = em.createNamedQuery("Funcionario.findAll", Funcionario.class); 
		//return tQuery.getResultList();
		
	} 
}