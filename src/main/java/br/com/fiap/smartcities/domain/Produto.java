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
@Table(name = "tbl_produto")
public class Produto {

	@Id
	@SequenceGenerator(name = "produto", sequenceName = "sq_tbl_produto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	@Column(name = "id_produto")
	private Integer id;

	@Column(name = "nome_produto", length = 50)
	private String nome;

	@Column(name = "ds_categoria", length = 50)
	private String categoria;

	@Column(name = "valor", precision = 10, scale = 2)
	private double valor;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, String categoria, double valor, Calendar dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}