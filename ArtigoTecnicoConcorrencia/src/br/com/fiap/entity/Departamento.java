package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departamento",schema="banco")
public class Departamento implements Serializable
{
	private static final long serialVersionUID = -7108449766845399344L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CODDEPARTAMENTO")
	private int codDepartamento;
	@Column(name = "NOMEDEPARTAMENTO", length = 45)
	private String nomeDepartamento;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<Usuario> usuario = new ArrayList<>();
	
	public List<Usuario> getUsuario()
	{
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario)
	{
		this.usuario = usuario;
	}
	
	public int getCodDepartamento()
	{
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento)
	{
		this.codDepartamento = codDepartamento;
	}

	public String getNomeDepartamento()
	{
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento)
	{
		this.nomeDepartamento = nomeDepartamento;
	}	
	
	@Override
	public String toString()
	{
		return "codDepartamento= "+codDepartamento+", nomeDepartamento= "+nomeDepartamento+", usuario= " + usuario+"\n";
	}
	
	
}
