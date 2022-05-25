package com.iker.mantenimientoalumnos.controller.alumno;

import com.iker.mantenimientoalumnos.App;
import com.iker.mantenimientoalumnos.model.bll.AlumnoBLL;
import com.iker.mantenimientoalumnos.model.bll.FactoriaBLL;
import com.iker.mantenimientoalumnos.model.dao.FactoriaDAO;
import com.iker.mantenimientoalumnos.model.entity.Alumno;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlumnoController implements Initializable {

    private AlumnoBLL alumnoBLL = FactoriaBLL.getAlumnoBLL();
    private static Stage stageAltaAlumno;
    
    @FXML
    private TableView alumnoTableView;
    
    @FXML 
    private TableColumn idAlumno;
    @FXML 
    private TableColumn nombreAlumno;
    @FXML 
    private TableColumn apellidosAlumno;
    @FXML 
    private TableColumn edadAlumno;
    
    @FXML
    private Button btnNuevo;
    
    //Path de la carpeta de imagenes
    final String URLRECURSOS = getClass().getResource("/images/").toExternalForm();
    
    private ObservableList<Alumno> listaAlumnosObs = FXCollections.observableArrayList();
    
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnBorrar;
    
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Hay que definir como se carga la tabla
        idAlumno.setCellValueFactory(new PropertyValueFactory<Alumno, Long>("idAlumno"));
        nombreAlumno.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombreAlumno"));
        apellidosAlumno.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellidosAlumno"));
        edadAlumno.setCellValueFactory(new PropertyValueFactory<Alumno, Integer>("edadAlumno"));
        
        cargarLista();
        
        cargarImagen(btnNuevo,"add.png", URLRECURSOS);
        cargarImagen(btnEditar,"cancel.png", URLRECURSOS);
        cargarImagen(btnBorrar,"delete.png", URLRECURSOS);
        
    }
    
    @FXML 
    public void btnNuevoClick(ActionEvent ae) throws IOException{
        Scene scene = new Scene(App.loadFXML("altaalumnosview"), 640, 480);
      
        stageAltaAlumno = new Stage();
        stageAltaAlumno.initModality((Modality.WINDOW_MODAL));
        
        stageAltaAlumno.initOwner(((Node)ae.getSource()).getScene().getWindow());
           
        
        stageAltaAlumno.setScene(scene);
        stageAltaAlumno.show();
        
        cargarLista();
        
    }
    
    //Le damos alcance al stage del alta alumno para en alta alumno controller
    //pueda cerrar la ventana
    public static Stage getStageAltaAlumno() {
        return stageAltaAlumno;
    }

    private void cargarLista() {
        List<Alumno> lista = alumnoBLL.listarAlumnos();
        
        //Añado los datos a la tabla
        listaAlumnosObs.clear();
        listaAlumnosObs.addAll(lista);
        
        //Cargamos los datos en la tabla-
        alumnoTableView.setItems(listaAlumnosObs);
    }

    public static void cargarImagen(Button boton, String imagen, String URL) {
        //CARGAR IMAGEN
        //Busco la ruta absoluta de la imagen
        String ruta = URL + imagen;
        //Cargamos al image en un imageView de javaFX
        ImageView img = new ImageView(new Image(ruta));
        //Modificamos el tamaño para adaptarlo al boton
        img.setFitHeight(15);
        img.setFitWidth(15);
        //Asignamos la imagen al boton
        boton.setGraphic(img);
        //Por defecto ya esta a la izquierda
        boton.setContentDisplay(ContentDisplay.RIGHT);
    }
    
}
