package paquete02;

public class Estudiante {

    private String nombre;
    private String apellido;
    private double calificacion1;
    private double calificacion2;
    private double calificacion3;
    private double promedio;

    public String obtenerNombre() {
        return nombre;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void establecerApellido(String a) {
        apellido = a;
    }

    public double obtenerCalificacion1() {
        return calificacion1;
    }

    public void establecerCalificacion1(double c1) {
        calificacion1 = c1;
    }

    public double obtenerCalificacion2() {
        return calificacion2;
    }

    public void establecerCalificacion2(double c2) {
        calificacion2 = c2;
    }

    public double obtenerCalificacion3() {
        return calificacion3;
    }

    public void establecerCalificacion3(double c3) {
        calificacion3 = c3;
    }

    public double obtenerPromedio() {
        return promedio;
    }

    public void calcularPromedio() {
        promedio = (calificacion1 + calificacion2 + calificacion3) / 3;
    }

}
