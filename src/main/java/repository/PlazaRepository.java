package repository;

import java.util.List;

import entity.Plaza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PlazaRepository {

    private EntityManagerFactory emf;

    public PlazaRepository() {
        emf = Persistence.createEntityManagerFactory("parqueaderoPU");
    }

    public void crear(Plaza plaza) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(plaza);
        em.getTransaction().commit();

        em.close();
    }

    public Plaza buscar(int id) {

        EntityManager em = emf.createEntityManager();

        Plaza plaza = em.find(Plaza.class, id);

        em.close();

        return plaza;
    }

    public List<Plaza> listar() {

        EntityManager em = emf.createEntityManager();

        List<Plaza> plazas = em.createQuery(
                "SELECT p FROM Plaza p",
                Plaza.class
        ).getResultList();

        em.close();

        return plazas;
    }

    public void actualizar(Plaza plaza) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(plaza);
        em.getTransaction().commit();

        em.close();
    }

    public void eliminar(int id) {

        EntityManager em = emf.createEntityManager();

        Plaza plaza = em.find(Plaza.class, id);

        if (plaza != null) {
            em.getTransaction().begin();
            em.remove(plaza);
            em.getTransaction().commit();
        }

        em.close();
    }
}