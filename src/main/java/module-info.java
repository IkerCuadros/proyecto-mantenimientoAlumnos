module com.iker.mantenimientoalumnos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.iker.mantenimientoalumnos to javafx.fxml;
    opens com.iker.mantenimientoalumnos.controller.login to javafx.fxml;
    opens com.iker.mantenimientoalumnos.controller.alumno to javafx.fxml;
    opens com.iker.mantenimientoalumnos.model.entity to javafx.base;
    
    exports com.iker.mantenimientoalumnos;
    exports com.iker.mantenimientoalumnos.controller.login;
    exports com.iker.mantenimientoalumnos.controller.alumno;
    exports com.iker.mantenimientoalumnos.model.entity;
    
}

