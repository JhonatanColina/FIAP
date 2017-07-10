package br.com.fiap.programa;

import java.util.Date;


import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Departamento;
import br.com.fiap.entity.Usuario;
import br.com.fiap.helper.Helper;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("scj");
		EntityManager em = emf.createEntityManager();
		Cache cache = emf.getCache();
		
		
		Departamento c = new Departamento();
		c.setNomeDepartamento("Comunicacao");
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		Usuario d = new Usuario();
		d.setNomeUsuario("Usuario");
		d.setSenha("123456789");
		d.setDataCriacao(new Date());
		d.setDepartamento(c);
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		
		em.close();
		System.out.println("Usuario "+d.getNomeUsuario()+ " está em Cache? " + cache.contains(Usuario.class, d.getCodUsuario()));
		 em = emf.createEntityManager();
		 buscarUsuario(em, d);
		System.out.println("Usuario "+d.getNomeUsuario()+ " está em Cache? " + cache.contains(Usuario.class, d.getCodUsuario()));
		em.close();
	}

	private static void buscarUsuario(EntityManager em, Usuario user) {
		Helper dao = new Helper(em);
		user = dao.buscarUsuario(user.getCodUsuario());
		System.out.println(user.getCodUsuario() + ": " + user.getNomeUsuario());
	}
	
}



