package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.Estabelecimento;

public class EstabelecimentoAlterar {

	public static void main(String[] args) {
		EntityManager em = null;
		try {

			int idProcurado = 2;

			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			Estabelecimento est = em.find(Estabelecimento.class, idProcurado);

			em.getTransaction().begin();
			est.setNome("Bar da Vila");
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