package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Estabelecimento;

public class EstabelecimentoRemover {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
	int idProcurado = 2;
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			Estabelecimento estab = em.find(Estabelecimento.class, idProcurado);
			
			
			em.getTransaction().begin();
			em.remove(estab);
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
