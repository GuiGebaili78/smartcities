package br.com.fiap.smartcities.domain;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_operacao")
public class Operacao {

	@Id
	@SequenceGenerator(name = "operacao", sequenceName = "sq_tbl_operacao", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operacao")
	@Column(name = "id_operacao")
	private Integer id;

	@Column(name = "vlr_venda", precision = 10, scale = 2)
	private double vlr_vendas;

	@Column(name = "qtd_produto")
	private int quantidade;

	@Column(name = "dta_pedido")
	private Calendar pedido;

	@Column(name = "dta_entrega")
	private Calendar entrega;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_loja", referencedColumnName = "id")
	private Loja loja;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_distribuidor", referencedColumnName = "id")
	private Loja distribuidor;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	public Operacao() {
		super();
	}

	public Operacao(Integer id, double vlr_vendas, int quantidade, Calendar pedido, Calendar entrega, Loja loja,
			Produto produto, Loja distribuidor, Calendar dataCriacao) {
		super();
		this.id = id;
		this.vlr_vendas = vlr_vendas;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.entrega = entrega;
		this.loja = loja;
		this.produto = produto;
		this.distribuidor = distribuidor;
		this.dataCriacao = dataCriacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getVlr_vendas() {
		return vlr_vendas;
	}

	public void setVlr_vendas(double vlr_vendas) {
		this.vlr_vendas = vlr_vendas;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getPedido() {
		return pedido;
	}

	public void setPedido(Calendar pedido) {
		this.pedido = pedido;
	}

	public Calendar getEntrega() {
		return entrega;
	}

	public void setEntrega(Calendar entrega) {
		this.entrega = entrega;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Loja getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Loja distribuidor) {
		this.distribuidor = distribuidor;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
