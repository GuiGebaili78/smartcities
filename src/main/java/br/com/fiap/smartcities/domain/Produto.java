package br.com.fiap.smartcities.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

	@Column(name = "nom_produto", length = 50)
	private String nome;

	@Column(name = "dsc_categoria", length = 50)
	private String categoria;

	@Column(name = "vlr_unit", precision = 10, scale = 2)
	private double valor;

	@Column(name = "dta_validade")
	private Calendar validade;

	@OneToOne(mappedBy = "produto")
	private Operacao operacao;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, String categoria, double valor, Calendar validade, Calendar dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.validade = validade;
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

	public Calendar getValidade() {
		return validade;
	}

	public void setValidade(Calendar validade) {
		this.validade = validade;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
