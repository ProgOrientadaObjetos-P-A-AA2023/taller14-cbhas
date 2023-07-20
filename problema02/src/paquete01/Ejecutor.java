package paquete01;

import paquete03.Enlace;

public class Ejecutor {

    public static void main(String[] args) {
        Enlace c = new Enlace();

        for (int i = 0; i < c.obtenerDataEstudiante().size(); i++) {
            System.out.printf("%s", c.obtenerDataEstudiante().get(i));
        }

    }

}
