package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.TipoLoja;

public class TipoLojaRemover {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
	int idProcurado = 2;
			
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			TipoLoja estab = em.find(TipoLoja.class, idProcurado);
			
			
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
