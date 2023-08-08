package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.com.fiap.smartcities.domain.Estabelecimento;

public class EstabelecimentoCadastrar {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
			Estabelecimento estab = new Estabelecimento();
			estab.setNome("Bar do Alemão");
			estab.setEndereco("Av. Consolação, 1000");
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
