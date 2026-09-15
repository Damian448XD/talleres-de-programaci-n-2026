package util;

import entity.Plaza;
import entity.Reserva;
import repository.ReservaRepository;

public class PruebaReserva {

    public static void main(String[] args) {

        ReservaRepository repository =
                new ReservaRepository();

        Plaza plaza = new Plaza(1, "P01", "LIBRE");

        Reserva reserva =
                new Reserva("Carlos", plaza, "ACTIVA");

        repository.crear(reserva);

        System.out.println("CREATE: Reserva creada.");

        Reserva encontrada =
                repository.buscar(reserva.getId());

        System.out.println(
            "READ: " +
            encontrada.getUsuario() +
            " - " +
            encontrada.getEstado()
        );

        encontrada.setEstado("FINALIZADA");

        repository.actualizar(encontrada);

        System.out.println("UPDATE: Reserva actualizada.");

        Reserva actualizada =
                repository.buscar(reserva.getId());

        System.out.println(
            "READ: " +
            actualizada.getUsuario() +
            " - " +
            actualizada.getEstado()
        );

        repository.eliminar(reserva.getId());

        System.out.println("DELETE: Reserva eliminada.");

        if (repository.buscar(reserva.getId()) == null) {
            System.out.println("CRUD RESERVA: correcto.");
        }
    }
}