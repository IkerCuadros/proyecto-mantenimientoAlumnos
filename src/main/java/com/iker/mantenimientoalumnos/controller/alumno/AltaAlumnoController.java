/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iker.mantenimientoalumnos.controller.alumno;

import com.iker.mantenimientoalumnos.exceptions.MyException;
import com.iker.mantenimientoalumnos.model.bll.AlumnoBLL;
import com.iker.mantenimientoalumnos.model.bll.FactoriaBLL;
import com.iker.mantenimientoalumnos.model.entity.Alumno;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author windows10
 */
public class AltaAlumnoController implements Initializable{

    private AlumnoBLL alumnoBLL = FactoriaBLL.getAlumnoBLL();
    
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtPassword2;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnLimpiar;
    
    final String URLRECURSOS = getClass().getResource("/images/").toExternalForm();

    @FXML
    private void btnOkClick(ActionEvent event) {

        boolean continuarValidando = true;

        //Comprobamos que todos los campos tienen valores
        if (txtNombre.getText().isBlank()
                || txtApellidos.getText().isBlank()
                || txtEdad.getText().isBlank()
                || txtPassword.getText().isBlank()
                || txtPassword2.getText().isBlank()) {

            continuarValidando = false;

            Alert a = new Alert(Alert.AlertType.ERROR, "No puede haber valores vacios.");
            a.showAndWait();
        }
        
        //Comprobamos que la edad sea un entero
        if (continuarValidando) {
            try {
                Integer a = Integer.valueOf(txtEdad.getText());
            } catch (NumberFormatException e) {
                continuarValidando = false;
                Alert a = new Alert(Alert.AlertType.ERROR, "La edad no es numerica.");
                a.showAndWait();
            }
        }
        
        //Comprobamos que las contraseñas son iguales
        if (continuarValidando) {
            if (!txtPassword.getText().equals(txtPassword2.getText())) {
                continuarValidando = false;
                Alert a = new Alert(Alert.AlertType.ERROR, "Las contraseñas no son iguales");
                a.showAndWait();
            }
        }
        
        //Solicitamos el alta del alumno
        if (continuarValidando) {
            Alumno a = new Alumno(txtNombre.getText(), txtApellidos.getText(), 
                    Integer.valueOf(txtEdad.getText()), txtPassword.getText());
            
            try {
                int resultado = alumnoBLL.anyadirAlumno(a);
                if (resultado>0) {
                    Alert alertaInjerccion = new Alert(Alert.AlertType.INFORMATION, "Alumno introducido con EXITO");
                    alertaInjerccion.showAndWait();
                    AlumnoController.getStageAltaAlumno().close();
                }
            } catch (MyException ex) {
                Alert al = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                al.showAndWait();
            }
        }

    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
    }

    @FXML
    private void btnLimpiarClick(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AlumnoController.cargarImagen(btnOk, "ok.jpg", URLRECURSOS);
        AlumnoController.cargarImagen(btnCancelar, "cancel.png", URLRECURSOS);
        AlumnoController.cargarImagen(btnLimpiar, "clean.png", URLRECURSOS);
    }

}
