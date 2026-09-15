package util;

import entity.Plaza;
import repository.PlazaRepository;

public class PruebaPlaza {

    public static void main(String[] args) {

        PlazaRepository repository = new PlazaRepository();

        // CREATE
        Plaza plaza = new Plaza(11, "P11", "LIBRE");
        repository.crear(plaza);
        System.out.println("CREATE: Plaza P11 creada.");

        // READ
        Plaza encontrada = repository.buscar(11);
        System.out.println(
            "READ: " +
            encontrada.getCodigo() +
            " - " +
            encontrada.getEstado()
        );

        // UPDATE
        encontrada.setEstado("OCUPADA");
        repository.actualizar(encontrada);
        System.out.println("UPDATE: Plaza P11 actualizada.");

        // READ después del UPDATE
        Plaza actualizada = repository.buscar(11);
        System.out.println(
            "READ: " +
            actualizada.getCodigo() +
            " - " +
            actualizada.getEstado()
        );

        // DELETE
        repository.eliminar(11);
        System.out.println("DELETE: Plaza P11 eliminada.");

        // Comprobar DELETE
        Plaza eliminada = repository.buscar(11);

        if (eliminada == null) {
            System.out.println("CRUD COMPLETO: correcto.");
        }
    }
}