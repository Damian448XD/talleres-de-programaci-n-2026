package repository;

import java.util.List;

import entity.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ReservaRepository {

    private EntityManagerFactory emf;

    public ReservaRepository() {
        emf = Persistence.createEntityManagerFactory("parqueaderoPU");
    }

    public void crear(Reserva reserva) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();

        em.close();
    }

    public Reserva buscar(int id) {

        EntityManager em = emf.createEntityManager();

        Reserva reserva = em.find(Reserva.class, id);

        em.close();

        return reserva;
    }

    public List<Reserva> listar() {

        EntityManager em = emf.createEntityManager();

        List<Reserva> reservas = em.createQuery(
                "SELECT r FROM Reserva r",
                Reserva.class
        ).getResultList();

        em.close();

        return reservas;
    }

    public void actualizar(Reserva reserva) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(reserva);
        em.getTransaction().commit();

        em.close();
    }

    public void eliminar(int id) {

        EntityManager em = emf.createEntityManager();

        Reserva reserva = em.find(Reserva.class, id);

        if (reserva != null) {
            em.getTransaction().begin();
            em.remove(reserva);
            em.getTransaction().commit();
        }

        em.close();
    }
}