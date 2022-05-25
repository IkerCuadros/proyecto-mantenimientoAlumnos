/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iker.mantenimientoalumnos.model.entity;

import java.util.Objects;

/**
 *
 * @author windows10
 */
public class Alumno {
    
    private Long idAlumno;
    private String nombreAlumno;
    private String apellidosAlumno;
    private Integer edadAlumno;
    private String password;

    public Alumno() {
        super();
    }

    public Alumno(Long idAlumno, String nombreAlumno, String apellidosAlumno, Integer edadAlumno, String password) {
        super();
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidosAlumno = apellidosAlumno;
        this.edadAlumno = edadAlumno;
        this.password = password;
    }

    public Alumno(String nombreAlumno, String apellidosAlumno, Integer edadAlumno, String password) {
        super();
        this.nombreAlumno = nombreAlumno;
        this.apellidosAlumno = apellidosAlumno;
        this.edadAlumno = edadAlumno;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidosAlumno() {
        return apellidosAlumno;
    }

    public void setApellidosAlumno(String apellidosAlumno) {
        this.apellidosAlumno = apellidosAlumno;
    }

    public Integer getEdadAlumno() {
        return edadAlumno;
    }

    public void setEdadAlumno(Integer edadAlumno) {
        this.edadAlumno = edadAlumno;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombreAlumno=" + nombreAlumno + ", apellidosAlumno=" + apellidosAlumno + ", edadAlumno=" + edadAlumno + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idAlumno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.idAlumno, other.idAlumno)) {
            return false;
        }
        return true;
    }
    
    
    
}
