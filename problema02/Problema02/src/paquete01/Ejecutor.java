package paquete01;

import paquete02.Estudiante;
import paquete03.Enlace;

public class Ejecutor {

    public static void main(String[] args) {
        Enlace c = new Enlace();
        Estudiante a = new Estudiante();

        a.calcularPromedio();

        for (int i = 0; i < c.obtenerDataEstudiante().size(); i++) {
            System.out.printf("%s %s\n"
                    + "Calificaciones:"
                    + "\n\t%.2f\n"
                    + "\t%.2f\n"
                    + "\t%.2f\n"
                    + "Promedio: %.2f",
                    c.obtenerDataEstudiante().get(i).obtenerNombre(),
                    c.obtenerDataEstudiante().get(i).obtenerApellido(),
                    c.obtenerDataEstudiante().get(i).obtenerCalificacion1(),
                    c.obtenerDataEstudiante().get(i).obtenerCalificacion2(),
                    c.obtenerDataEstudiante().get(i).obtenerCalificacion3());
        }
    }
}
