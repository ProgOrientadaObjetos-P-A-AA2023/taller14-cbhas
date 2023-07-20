package paquete03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete02.Trabajador;

public class Enlace {

    private Connection conn;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/base01.db";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarTrabajador(Trabajador trabajador) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO trabajador (cedula, nombre, "
                    + "correo, sueldo, mesSueldo) "
                    + "values ('%s', '%s', '%s', %d, '%s')",
                    trabajador.obtenerCedula(),
                    trabajador.obtenerNombre(),
                    trabajador.obtenerCorreo(),
                    trabajador.obtenerSueldo(),
                    trabajador.obtenerMesSueldo());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<Trabajador> obtenerDataTrabajador() {
        ArrayList<Trabajador> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from trabajador;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.establecerCedula(rs.getString("cedula"));
                trabajador.establecerNombre(rs.getString("nombre"));
                trabajador.establecerCorreo(rs.getString("correo"));
                trabajador.establecerSueldo(rs.getInt("sueldo"));
                trabajador.establecerMesSueldo(rs.getString("mesSueldo"));
                lista.add(trabajador);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCiudad");
            System.out.println(e.getMessage());

        }
        return lista;
    }

}
