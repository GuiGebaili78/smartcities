package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.EstabelecimentoTipo;

public class EstabelecimentoTipoCadastrar {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
			EstabelecimentoTipo tipoestab = new EstabelecimentoTipo();
			//tipoestab.setTipo("Atacado");
			tipoestab.setTipo("Varejo");
			//tipoestab.setTipo("Distribuidor");
			em.merge(tipoestab);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

}
