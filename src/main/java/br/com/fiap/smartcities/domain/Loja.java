package br.com.fiap.smartcities.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_loja")
public class Loja {

	@Id
	@SequenceGenerator(name = "loja", sequenceName = "sq_tbl_loja", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loja")
	@Column(name = "id_loja")
	private Integer id;

	@Column(name = "nom_loja", length = 50)
	private String nome;

	@Column(name = "end_loja", length = 255)
	private String endereco;
	
	@OneToOne(mappedBy = "loja")
	private Operacao operacao;

	@ManyToOne
	@JoinColumn(name = "id_tipo_loja")
	private TipoLoja tipo;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	public Loja() {
		super();
	}

	public Loja(Integer id, String nome, String endereco, TipoLoja tipo, Calendar dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
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

	public TipoLoja getTipo() {
		return tipo;
	}

	public void setTipo(TipoLoja tipo) {
		this.tipo = tipo;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
