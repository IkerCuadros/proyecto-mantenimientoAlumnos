package com.iker.mantenimientoalumnos.model.dao;

public class FactoriaDAO {

    private static AlumnoDAO AlumnoDAO = null;
    // private static ComercialDAO comerciaDAO = null;
    // private static PedidosDAO pedidosDAO = null;

    public static AlumnoDAO getAlumnoDAO() {
        if (AlumnoDAO == null) {
            AlumnoDAO = new AlumnoDAO();
        }
        return AlumnoDAO;
    }
}
