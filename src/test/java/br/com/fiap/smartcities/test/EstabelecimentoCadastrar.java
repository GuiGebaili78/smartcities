package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Estabelecimento;
import br.com.fiap.smartcities.domain.EstabelecimentoTipo;

public class EstabelecimentoCadastrar {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();

			Estabelecimento estab = new Estabelecimento();
			EstabelecimentoTipo nometipo = em.find(EstabelecimentoTipo.class, 1);

			estab.setNome("Bar do Jucelino");
			estab.setEndereco("Av. Paulista, 500");
			estab.setTipo(nometipo);

			em.merge(estab);
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
