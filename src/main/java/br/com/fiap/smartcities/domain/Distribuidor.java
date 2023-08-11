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
@Table(name = "tbl_distribuidor")
public class Distribuidor {

	@Id
	@SequenceGenerator(name = "distribuidor", sequenceName = "sq_tbl_distribuidor", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distribuidor")
	@Column(name = "id_distribuidor")
	private Integer id;

	@Column(name = "nom_distribuidor", length = 100)
	private String nome;

	@Column(name = "end_distribuidor", length = 255)
	private String endereco;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	public Distribuidor() {
		super();
	}

	public Distribuidor(Integer id, String nome, String endereco, Calendar dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}