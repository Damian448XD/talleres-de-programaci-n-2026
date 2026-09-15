import java.util.Random;

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        Parqueadero parqueadero =
                new Parqueadero();

        System.out.println(
            "================================"
        );

        System.out.println(
            "   PARQUEADERO UNIVERSITARIO"
        );

        System.out.println(
            "       SISTEMA IoT SIMULADO"
        );

        System.out.println(
            "================================"
        );


        /*
         * ==================================
         * CREAR SENSORES
         * ==================================
         */

        System.out.println(
            "\nIniciando sensores..."
        );

        for (Plaza plaza :
                parqueadero.getPlazas()) {

            Sensor sensor =
                new Sensor(plaza);

            sensor.start();
        }


        /*
         * ==================================
         * MOSTRAR MAPA
         * ==================================
         */

        parqueadero.mostrarMapa();


        /*
         * ==================================
         * SIMULAR USUARIOS
         * ==================================
         */

        Thread.sleep(3000);

        System.out.println(
            "\n===== PRUEBA DE RESERVAS ====="
        );


        /*
         * Varios usuarios intentan
         * reservar simultáneamente.
         */

        Thread usuario1 =
            new Thread(() -> {

                parqueadero.reservar(
                    "Juan",
                    1
                );

            });


        Thread usuario2 =
            new Thread(() -> {

                parqueadero.reservar(
                    "Maria",
                    1
                );

            });


        Thread usuario3 =
            new Thread(() -> {

                parqueadero.reservar(
                    "Carlos",
                    2
                );

            });


        usuario1.start();
        usuario2.start();
        usuario3.start();


        usuario1.join();
        usuario2.join();
        usuario3.join();


        /*
         * ==================================
         * MOSTRAR MAPA
         * ==================================
         */

        parqueadero.mostrarMapa();


        /*
         * ==================================
         * CONFIRMAR INGRESO
         * ==================================
         */

        Thread.sleep(3000);

        System.out.println(
            "\n===== INGRESOS ====="
        );

        parqueadero.ingresar("Juan");


        /*
         * ==================================
         * ESPERAR
         * ==================================
         */

        Thread.sleep(5000);


        /*
         * ==================================
         * SALIDA
         * ==================================
         */

        System.out.println(
            "\n===== SALIDA ====="
        );

        parqueadero.salir("Juan");


        /*
         * ==================================
         * MAPA FINAL
         * ==================================
         */

        parqueadero.mostrarMapa();


        System.out.println(
            "\nSistema ejecutándose..."
        );
    }
}