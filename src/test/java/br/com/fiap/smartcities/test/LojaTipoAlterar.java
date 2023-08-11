package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Loja;

public class LojaTipoAlterar {

	public static void main(String[] args) {
		EntityManager em = null;
		try {

			int idProcurado = 1;

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			Loja est = em.find(Loja.class, idProcurado);

			em.getTransaction().begin();
			est.setNome("Atacado");
			em.getTransaction().commit();

		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			
		}
	}
}