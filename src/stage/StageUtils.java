package stage;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import variables.MyVariables;

import java.io.IOException;
import java.util.Optional;

/**
 * @author NTOUTOUME MENZOUGHE YANNICK
 * @version 1.0
 *
 */
public class StageUtils {

    /**
     * Fonction qui affiche une interface à partir du chemin vers un fichier fxml
     * @param fxml
     * @throws IOException si l'url est incorrect
     */
    public void loadStage(String fxml) {
        try {
            var root = FXMLLoader.load(StageUtils.class.getResource(fxml));
            var stage = new Stage();
            stage.setScene(new Scene((Parent)root));
            stage.setTitle(MyVariables.APPNAME);
            stage.getIcons().add(new Image("./images/icon.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            handleWindowsClose(stage);
            handleMaximizeWindow(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui demande à l'user de valider sa demande de fermeture de l'appli
     * @param stage
     */
    private void handleWindowsClose(Stage stage) {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                var alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(MyVariables.closingApp);
                alert.setHeaderText(null);
                alert.setContentText(MyVariables.areYouReallyWantToCloseTheApp);
                var boutonQuitter = new ButtonType(MyVariables.yes);
                var boutonRester = new ButtonType(MyVariables.no);
                alert.getButtonTypes().setAll(boutonQuitter, boutonRester);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == boutonRester) {
                    event.consume();
                }
            }
        });
    }

    /**
     * Fonction qui désactive l'agrandissement de la fenetre de l'appli
     * @param stage
     */
    private void handleMaximizeWindow(Stage stage){
        stage.setMaximized(false);
        stage.setResizable(false);
    }
}
