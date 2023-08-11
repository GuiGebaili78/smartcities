package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.domain.TipoLoja;

public class TipoLojaBuscar {

	public static void main(String[] args) {
		EntityManager em = null;
		try {

			int idProcurado = 1;
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

			TipoLoja estab = em.find(TipoLoja.class, idProcurado);

			System.out.println("Estabelecimento encontrado: " + estab);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

}
