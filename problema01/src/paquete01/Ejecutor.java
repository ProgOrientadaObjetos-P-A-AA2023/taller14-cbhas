package paquete01;

import java.util.Scanner;
import paquete02.Trabajador;
import paquete03.Enlace;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Enlace e = new Enlace();
        Trabajador t = new Trabajador();

        boolean bandera = true;

        while (bandera) {
            System.out.print("Ingrese '1' para ingresar el sueldo de un trabajador\n"
                    + "Ingresa '2' para mostrar la base de datos\n"
                    + "Ingrese '3' para salir del programa\n> ");
            String opcion = entrada.nextLine();

            if ("1".equals(opcion)) {
                System.out.print("\nIngrese la cédula del trabajador:\n> ");
                String cedula = entrada.nextLine();

                System.out.print("\nIngrese el nombre del trabajador:\n> ");
                String nombre = entrada.nextLine();

                System.out.print("\nIngrese el correo del trabajador:\n> ");
                String correo = entrada.nextLine();

                System.out.print("\nIngrese el sueldo del trabajador:\n> ");
                int sueldo = entrada.nextInt();

                entrada.nextLine();

                System.out.print("\nIngrese el mes del sueldo del trabajador:\n> ");
                String mesSueldo = entrada.nextLine();

                t.establecerCedula(cedula);
                t.establecerNombre(nombre);
                t.establecerCorreo(correo);
                t.establecerSueldo(sueldo);
                t.establecerMesSueldo(mesSueldo);

                e.insertarTrabajador(t);

                System.out.print("\nIngrese 'si' para salir del programa:\n> ");
                opcion = entrada.nextLine();

                if ("si".equals(opcion)) {
                    bandera = false;
                }

            } else if ("2".equals(opcion)) {
                for (int i = 0; i < e.obtenerDataTrabajador().size(); i++) {
                    System.out.printf("%s", e.obtenerDataTrabajador().get(i));
                }
                
            } else if ("3".equals(opcion)) {
                return;

            } else {
                System.out.println("Opción incorrecta!");
                return;
            }

        }

    }

}
