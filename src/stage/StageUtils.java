package stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import variables.MyVariables;

import java.io.IOException;

public class StageUtils {

    /**
     * Fonction qui affiche une interface à partir du chemin vers un fichier fxml
     * @param fxml
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
