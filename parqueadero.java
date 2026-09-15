import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

    private List<Plaza> plazas =
            new ArrayList<>();

    private List<Reserva> reservas =
            new ArrayList<>();


    public Parqueadero() {

        for (int i = 1; i <= 10; i++) {

            plazas.add(
                new Plaza(
                    i,
                    String.format("P%02d", i)
                )
            );
        }
    }


    public List<Plaza> getPlazas() {

        return plazas;
    }


    /*
     * Buscar una plaza libre
     */

    public synchronized Plaza buscarPlazaLibre() {

        for (Plaza plaza : plazas) {

            if (
                plaza.getEstado()
                     .equals("LIBRE")
            ) {

                return plaza;
            }
        }

        return null;
    }


    /*
     * Realizar reserva
     */

    public synchronized boolean reservar(
            String usuario,
            int idPlaza) {

        for (Plaza plaza : plazas) {

            if (plaza.getId() == idPlaza) {

                if (plaza.reservar()) {

                    reservas.add(
                        new Reserva(
                            usuario,
                            plaza
                        )
                    );

                    System.out.println(
                        "✅ " +
                        usuario +
                        " reservó " +
                        plaza.getCodigo()
                    );

                    return true;
                }

                System.out.println(
                    "❌ " +
                    usuario +
                    ": la plaza " +
                    plaza.getCodigo() +
                    " no está disponible."
                );

                return false;
            }
        }

        return false;
    }


    /*
     * Confirmar ingreso
     */

    public synchronized boolean ingresar(
            String usuario) {

        for (Reserva reserva : reservas) {

            if (
                reserva.getUsuario()
                       .equals(usuario)
            ) {

                Plaza plaza =
                    reserva.getPlaza();

                plaza.ocupar();

                System.out.println(
                    "🚗 " +
                    usuario +
                    " ingresó al parqueadero."
                );

                return true;
            }
        }

        System.out.println(
            "❌ No existe reserva para " +
            usuario
        );

        return false;
    }


    /*
     * Registrar salida
     */

    public synchronized void salir(
            String usuario) {

        for (Reserva reserva : reservas) {

            if (
                reserva.getUsuario()
                       .equals(usuario)
            ) {

                reserva.getPlaza().liberar();

                System.out.println(
                    "🚗 " +
                    usuario +
                    " salió. Plaza " +
                    reserva.getPlaza().getCodigo() +
                    " liberada."
                );

                return;
            }
        }
    }


    /*
     * Mostrar mapa
     */

    public void mostrarMapa() {

        System.out.println();
        System.out.println(
            "========== MAPA =========="
        );

        for (Plaza plaza : plazas) {

            String simbolo;

            switch (
                plaza.getEstado()
            ) {

                case "LIBRE":
                    simbolo = "🟢";
                    break;

                case "RESERVADA":
                    simbolo = "🟡";
                    break;

                default:
                    simbolo = "🔴";
            }

            System.out.println(
                simbolo +
                " " +
                plaza.getCodigo() +
                " - " +
                plaza.getEstado()
            );
        }

        System.out.println(
            "=========================="
        );
    }
}