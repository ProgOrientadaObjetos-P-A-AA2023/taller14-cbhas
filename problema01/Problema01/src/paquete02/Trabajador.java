package paquete02;

public class Trabajador {

    private String cedula;
    private String nombre;
    private String correo;
    private int sueldo;
    private String mesSueldo;

    public String obtenerCedula() {
        return cedula;
    }

    public void establecerCedula(String ce) {
        cedula = ce;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public void establecerCorreo(String co) {
        correo = co;
    }

    public int obtenerSueldo() {
        return sueldo;
    }

    public void establecerSueldo(int s) {
        sueldo = s;
    }

    public String obtenerMesSueldo() {
        return mesSueldo;
    }

    public void establecerMesSueldo(String mS) {
        mesSueldo = mS;
    }

}
