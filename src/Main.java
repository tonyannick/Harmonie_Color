import fxinject.Inject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import stage.StageUtils;
import variables.MyVariables;

public class Main extends Application {

    @Inject
    private StageUtils stageUtils;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stageUtils = new StageUtils();
        stageUtils.loadStage(MyVariables.viewConverterFXML);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
