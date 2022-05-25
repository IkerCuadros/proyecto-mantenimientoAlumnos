/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iker.mantenimientoalumnos.model.bll;

import com.iker.mantenimientoalumnos.exceptions.MyException;
import com.iker.mantenimientoalumnos.model.dao.AlumnoDAO;
import com.iker.mantenimientoalumnos.model.dao.FactoriaDAO;
import com.iker.mantenimientoalumnos.model.entity.Alumno;
import java.util.List;

/**
 *
 * @author windows10
 */
public class AlumnoBLL {
    
    private AlumnoDAO alumnoDAO = FactoriaDAO.getAlumnoDAO();
    
    public List<Alumno> listarAlumnos(){
        return alumnoDAO.getAll();
    }

    public int anyadirAlumno(Alumno alumno) throws MyException {
        //Comproba que el alumno no existe
        Alumno a = alumnoDAO.findByNombreAndApellidos(alumno);
        int resultado = -1;
        
        if (a==null) {
            resultado = alumnoDAO.add(alumno);
            return resultado;
            
        }else{
            throw new MyException("Ya existe el alumno");
        }
    }
    
    public boolean login(Alumno alumno){
        Alumno resultado = alumnoDAO.findByNameAndPassword(alumno);
        if (resultado!=null) {
            return true;
        }else{
            return false;
        }
    }
}
