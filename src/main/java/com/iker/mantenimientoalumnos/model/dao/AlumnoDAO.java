/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iker.mantenimientoalumnos.model.dao;

import com.iker.mantenimientoalumnos.model.entity.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windows10
 */
public class AlumnoDAO implements IOperationsCRUD<Alumno> {

    private Connection conn = ConexionBD.getConnection();

    @Override
    public List<Alumno> getAll() {
        // Creamos la conexion
        List<Alumno> lista = new ArrayList<Alumno>();
        try {
            // Creamos un objeto para ejecutar la consulta
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM alumno";
            // Obtenemos los resultados de la consulta
            ResultSet rs = st.executeQuery(sql);
            // Recorremos los resultados
            while (rs.next()) {
                Long idAux = rs.getLong("id");
                String nomAux = rs.getString("nombre");
                String ape1Aux = rs.getString("apellidos");
                Integer edadAux = rs.getInt("edad");
                String passwordAux = rs.getString("password");
                // Crea el cliente y lo añade a la lista
                Alumno a = new Alumno(idAux, nomAux, ape1Aux, edadAux, passwordAux);
                lista.add(a);
            }
            // Cerrar los objetos que usan para las consultas
            rs.close();
            st.close();
            // Devolvemos la lista
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Alumno findById(Alumno object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int add(Alumno object) {
        String sql = "INSERT INTO alumno(nombre,apellidos,edad,password) VALUES (?,?,?,?);";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getNombreAlumno());
            ps.setString(2, object.getApellidosAlumno());
            ps.setInt(3, object.getEdadAlumno());
            ps.setString(4, object.getPassword());           
            int i = ps.executeUpdate();
            ps.close();
            return i;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(Alumno object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Alumno object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Alumno findByNombreAndApellidos(Alumno a) {
        try {
            // Creamos un objeto para ejecutar la consulta
            String sql = "SELECT * FROM alumno WHERE nombre=? and apellidos=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //Pasamos parametros
            ps.setString(1, a.getNombreAlumno());
            ps.setString(2, a.getApellidosAlumno());

            // Obtenemos los resultados de la consulta
            ResultSet rs = ps.executeQuery();

            // Recorremos los resultados
            Alumno alumno = null;
            if (rs.next()) {
                Long idAux = rs.getLong("id");
                String nomAux = rs.getString("nombre");
                String ape1Aux = rs.getString("apellidos");
                Integer edadAux = rs.getInt("edad");
                String passwordAux = rs.getString("password");
                // Crea el cliente y lo añade a la lista
                alumno = new Alumno(idAux, nomAux, ape1Aux, edadAux, passwordAux);
            }

            // Cerrar los objetos que usan para las consultas
            rs.close();
            ps.close();

            return alumno;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Alumno findByNameAndPassword(Alumno alumno) {
        try {
            // Creamos un objeto para ejecutar la consulta
            String sql = "SELECT * FROM alumno WHERE nombre=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //Pasamos parametros
            ps.setString(1, alumno.getNombreAlumno());
            ps.setString(2, alumno.getPassword());

            // Obtenemos los resultados de la consulta
            ResultSet rs = ps.executeQuery();

            // Recorremos los resultados
            Alumno a = null;
            if (rs.next()) {
                Long idAux = rs.getLong("id");
                String nomAux = rs.getString("nombre");
                String ape1Aux = rs.getString("apellidos");
                Integer edadAux = rs.getInt("edad");
                String passwordAux = rs.getString("password");
                // Crea el cliente y lo añade a la lista
                a = new Alumno(idAux, nomAux, ape1Aux, edadAux, passwordAux);
            }

            // Cerrar los objetos que usan para las consultas
            rs.close();
            ps.close();

            return a;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
