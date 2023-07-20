package paquete03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete02.Estudiante;

public class Enlace {

    private Connection conn;

    public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:db/base001.base";
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarEstudiante(Estudiante estudiante) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO estudiante (nombre, apellido, "
                    + "calificacion1, calificacion2, calificacion3) "
                    + "values ('%s', '%s', %.2f, %.2f, %.2f)",
                    estudiante.obtenerNombre(),
                    estudiante.obtenerApellido(),
                    estudiante.obtenerCalificacion1(),
                    estudiante.obtenerCalificacion2(),
                    estudiante.obtenerCalificacion3());
            statement.executeUpdate(data);
            obtenerConexion().close();

        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }

    }

    public ArrayList<Estudiante> obtenerDataEstudiante() {
        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from estudiante";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.establecerNombre(rs.getString("nombre"));
                estudiante.establecerApellido(rs.getString("apellido"));
                estudiante.establecerCalificacion1(rs.getDouble("calificacion1"));
                estudiante.establecerCalificacion2(rs.getDouble("calificacion2"));
                estudiante.establecerCalificacion3(rs.getDouble("calificacion3"));
                estudiante.calcularPromedio();
                lista.add(estudiante);
            }

            obtenerConexion().close();

        } catch (SQLException e) {
            System.out.println("Exception: insertarEstudiante");
            System.out.println(e.getMessage());

        }

        return lista;
    }

}
