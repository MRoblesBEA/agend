package agenda;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The data as an observable list of Persons.
 */
public class MainApp extends Application {
    //private ObservableList<Person> personData = FXCollections.observableArrayList();

    private Stage stagePrincipal;
    private AnchorPane rootPane;

    /**
     * Constructor
     */
    //public MainApp() {
    //}

    /**
     * Returns the data as an observable list of Persons.
     *
     * @param stagePrincipal
     * @throws java.lang.Exception
     */
    //public ObservableList<Person> getPersonData() {
     // return personData;
    //}
//    public void showPersonOverview() {
    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();
    }

    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/personOverView.fxml"));
            rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            //stagePrincipal.setTitle("Ventana Principal");
            stagePrincipal.setScene(scene);
            PersonOverviewController controller = loader.getController();
           
            controller.setMainApp(this);
            stagePrincipal.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //public boolean showPersonEditDialog(Person person) {
        public boolean showPersonEditDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stagePrincipal);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
           // PersonEditDialogController controller = loader.getController();
            //controller.setDialogStage(dialogStage);
            //controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            //return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
         return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}