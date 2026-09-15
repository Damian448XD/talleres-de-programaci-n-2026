import java.util.Random;
// experimental
public class Sensor extends Thread {

    private Plaza plaza;
    private Random random = new Random();

    public Sensor(Plaza plaza) {
        this.plaza = plaza;
    }

    @Override
    public void run() {

        while (true) {

            try {

                boolean detectaVehiculo =
                        random.nextBoolean();

                synchronized (plaza) {

                    String estado =
                            plaza.getEstado();

                    if (detectaVehiculo) {

                        /*
                         * Si está libre,
                         * el sensor puede marcarla ocupada.
                         */

                        if (estado.equals("LIBRE")) {

                            plaza.ocupar();

                            System.out.println(
                                "📡 Sensor " +
                                plaza.getCodigo() +
                                ": OCUPADO"
                            );
                        }

                        /*
                         * Si está reservada,
                         * generamos un conflicto.
                         */

                        else if (
                            estado.equals("RESERVADA")
                        ) {

                            System.out.println(
                                "⚠ CONFLICTO: Sensor " +
                                plaza.getCodigo() +
                                " detectó un vehículo " +
                                "pero la plaza estaba RESERVADA."
                            );
                        }

                    } else {

                        /*
                         * El sensor detecta
                         * que no hay vehículo.
                         */

                        if (estado.equals("OCUPADA")) {

                            plaza.liberar();

                            System.out.println(
                                "📡 Sensor " +
                                plaza.getCodigo() +
                                ": LIBRE"
                            );
                        }
                    }
                }

                /*
                 * Esperar entre 2 y 5 segundos
                 */

                Thread.sleep(
                    2000 + random.nextInt(3000)
                );

            } catch (InterruptedException e) {

                System.out.println(
                    "Sensor detenido: " +
                    plaza.getCodigo()
                );

                break;
            }
        }
    }
}