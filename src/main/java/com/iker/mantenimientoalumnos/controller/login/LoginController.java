/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iker.mantenimientoalumnos.controller.login;

import com.iker.mantenimientoalumnos.App;
import com.iker.mantenimientoalumnos.model.bll.AlumnoBLL;
import com.iker.mantenimientoalumnos.model.bll.FactoriaBLL;
import com.iker.mantenimientoalumnos.model.entity.Alumno;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author windows10
 */
public class LoginController implements Initializable {

    private static Stage stageLoginController;

    @FXML
    private TextField txtNombre;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblMensaje;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancelar;

    final String mensajeError = "Login invalido, intentalo de nuevo";
    final String mensajeVacio = "Porfavor introduzca usuario y contraseña";

    private AlumnoBLL alumnoBLL = FactoriaBLL.getAlumnoBLL();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void btnCancelarClick(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnLoginClick(ActionEvent event) throws IOException {
        if (validarDatos()) {
            Alumno alumno = new Alumno();
            alumno.setNombreAlumno(txtNombre.getText());
            alumno.setPassword(txtPassword.getText());
            boolean resultado = alumnoBLL.login(alumno);

            if (!resultado) {
                lblMensaje.setText(mensajeError);
            } else {
                Scene scene = new Scene(App.loadFXML("altaalumnosview"), 640, 480);

                stageLoginController = new Stage();
                stageLoginController.initModality((Modality.WINDOW_MODAL));

                stageLoginController.initOwner(((Node) event.getSource()).getScene().getWindow());

                stageLoginController.setScene(scene);
                stageLoginController.show();
            }
        }
    }

    private boolean validarDatos() {
        if (txtNombre.getText().isBlank() || txtPassword.getText().isBlank()) {
            lblMensaje.setText(mensajeVacio);
            return false;
        } else {
            return true;
        }
    }

}
