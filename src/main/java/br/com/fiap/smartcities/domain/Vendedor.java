package br.com.fiap.smartcities.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_vendedor")
public class Vendedor {

	@Id
	@SequenceGenerator(name = "vendedor", sequenceName = "sq_tbl_vendedor", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendedor")
	@Column(name = "id_vendedor")
	private Integer id;

	@Column(name = "nome_vendedor", length = 50)
	private String nome;

	@Column(name = "nome_equipe", length = 50)
	private String equipe;

	@Column(name = "vlr_vendas", precision = 10, scale = 2)
	private double vlr_vendas;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	public Vendedor() {
		super();
	}

	public Vendedor(Integer id, String nome, String equipe, double vlr_vendas, Calendar dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.equipe = equipe;
		this.vlr_vendas = vlr_vendas;
		this.dataCriacao = dataCriacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}

	public double getVlr_vendas() {
		return vlr_vendas;
	}

	public void setVlr_vendas(double vlr_vendas) {
		this.vlr_vendas = vlr_vendas;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}