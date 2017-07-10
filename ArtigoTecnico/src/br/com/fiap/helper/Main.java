package br.com.fiap.helper;

import java.util.Date;

import br.com.fiap.entity.Departamento;
import br.com.fiap.entity.Usuario;

public class Main
{

	public static void main(String[] args)
	{
		/*Adiciona Departamento*/
		Departamento c = new Departamento();
		c.setNomeDepartamento("TI");
		GenericDao<Departamento> daoDepartamento = new GenericDao<>(Departamento.class);
		daoDepartamento.adicionar(c);
		
		/*Adiciona Usuario*/
		Usuario d = new Usuario();
		d.setNomeUsuario("Jhonatan");
		d.setSenha("123456789");
		d.setDataCriacao(new Date());
		d.setDepartamento(c);
		GenericDao<Usuario> daoUsuario = new GenericDao<>(Usuario.class);
		daoUsuario.adicionar(d);

	}

}
