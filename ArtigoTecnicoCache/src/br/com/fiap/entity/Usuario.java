package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "usuario", catalog = "banco", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CODUSUARIO") })
@NamedQuery(name = "Usuario.findAll", query = "select u from Usuario u", hints = {
		@QueryHint(name = "org.hibernate.cacheable", value = "true") })
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="user")

public class Usuario implements Serializable {
	private static final long serialVersionUID = -7108449766845399345L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CODUSUARIO")
	private int codUsuario;
	@Column(name = "NOMEUSUARIO", length = 45)
	private String nomeUsuario;
	@Column(name = "SENHA", length = 45)
	private String senha;
	@Column(name = "DATACRIACAO")
	private Date dataCriacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODDEPARTAMENTO")
	private Departamento departamento;
	

	public Departamento getDepartamento()
	{
		return departamento;
	}

	public void setDepartamento(Departamento departamento)
	{
		this.departamento = departamento;
	}
	
	public int getCodUsuario()
	{
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario)
	{
		this.codUsuario = codUsuario;
	}

	public String getNomeUsuario()
	{
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario)
	{
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	public Date getDataCriacao()
	{
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao)
	{
		this.dataCriacao = dataCriacao;
	}
	
	@Override
	public String toString()
	{
		return "codUsuario= "+codUsuario+", nomeUsuario= "+nomeUsuario+", senha= "+senha+", dataCriacao= "+dataCriacao+", departamento= "+departamento.toString()+"\n";
	}
}