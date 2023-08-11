package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.TipoLoja;

public class TipoLojaAlterar {

	public static void main(String[] args) {
		EntityManager em = null;
		try {

			int idProcurado = 2;

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			TipoLoja tip = em.find(TipoLoja.class, idProcurado);

			em.getTransaction().begin();
			tip.setTipo("Atacado");
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