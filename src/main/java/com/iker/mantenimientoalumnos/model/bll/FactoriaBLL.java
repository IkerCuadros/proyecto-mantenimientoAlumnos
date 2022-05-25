/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iker.mantenimientoalumnos.model.bll;

import com.iker.mantenimientoalumnos.model.dao.AlumnoDAO;

/**
 *
 * @author windows10
 */
public class FactoriaBLL {
    
    private static AlumnoBLL alumnoBLL = null;

    public static AlumnoBLL getAlumnoBLL() {
        if (alumnoBLL == null) {
            alumnoBLL = new AlumnoBLL();
        }
        return alumnoBLL;
    }
    
}
