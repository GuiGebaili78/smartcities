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
@Table(name = "tbl_tipo_estabelecimento")
public class EstabelecimentoTipo {

	@Id
	@SequenceGenerator(name = "tipo_estabelecimento", sequenceName = "sq_tbl_tipo_estabelecimento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_estabelecimento")
	@Column(name = "id_tipo_estabelecimento")
	private Integer id;

	@Column(name = "tipo_estabelecimento", length = 50)
	private String tipo;

	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;


	public EstabelecimentoTipo(Integer id, String tipo, Calendar dataCriacao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.dataCriacao = dataCriacao;
	}


	public EstabelecimentoTipo() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Calendar getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}

