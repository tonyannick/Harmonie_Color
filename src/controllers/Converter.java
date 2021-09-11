package controllers;


import file.PropertieFilesUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import services.ColorsConverterServices;
import services.SliderServices;
import services.TextFieldsServices;
import variables.MyVariables;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class Converter implements Initializable {

    @FXML
    private TextField redTextField;
    @FXML
    private TextField greenTextField;
    @FXML
    private TextField blueTextField;
    @FXML
    private Slider redSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private TextField hexTextField;
    @FXML
    private Rectangle rectangleColor;
    @FXML
    private ComboBox comBoxColorName;
    private ObservableList<String> keysColorsPropertiesList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comBoxColorName.setItems(fillComboBoxColorNames());

        TextFieldsServices textFieldsServices = new TextFieldsServices();
        SliderServices sliderServices = new SliderServices();

        textFieldsServices.initializeTextFields(redTextField);
        textFieldsServices.initializeTextFields(blueTextField);
        textFieldsServices.initializeTextFields(greenTextField);

        sliderServices.initializeSlider(redSlider,MyVariables.REDSLIDER);
        sliderServices.initializeSlider(blueSlider,MyVariables.BLUESLIDER);
        sliderServices.initializeSlider(greenSlider,MyVariables.GREENSLIDER);

        sliderServices.onSliderChange(redSlider,redTextField);
        sliderServices.onSliderChange(blueSlider,blueTextField);
        sliderServices.onSliderChange(greenSlider,greenTextField);
    }

    /**
     * Fonction qui appele le service pour afficher la couleur seelctionnée dans le preview
     */
    @FXML
    public void convertirLaCouleurEnHexadecimal(){
        ColorsConverterServices colorsConverterServices = new ColorsConverterServices();
        rectangleColor.setFill(Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue()));
        hexTextField.setText( colorsConverterServices.convertRGBToHex((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue()));
    }

    /**
     * Fonction qui reinitialise tous les textfields à zero
     */
    @FXML
    public void resetColor(){
        blueTextField.setText("0");
        redTextField.setText("0");
        greenTextField.setText("0");
        redSlider.setValue(0);
        blueSlider.setValue(0);
        greenSlider.setValue(0);
        hexTextField.clear();
        rectangleColor.setFill(Color.rgb(255,255,255));
    }

    /**
     * Fonction qui remplit le comboBox des noms des couleurs depuis le fichiers des propriétés
     * @return observalist des noms
     */
    private ObservableList<String>  fillComboBoxColorNames(){
        var propertieFilesUtils = new PropertieFilesUtils();
        var colorProperties = propertieFilesUtils.loadPropertiesFile(MyVariables.colorsPropertiesFile);
        Set<Object> allKeys = propertieFilesUtils.getAllPropertiesKeys(colorProperties);
        for(Object k:allKeys){
            var key = (String)k;
            keysColorsPropertiesList.add(key);
            //System.out.println(key+": "+propertieFilesUtils.getPropertyValue(key,colorProperties));
        }
        return keysColorsPropertiesList;
    }


    /**
     * Fonction qui convertie le nom d'une couleur depuis la comboBox
     */
    @FXML
    public void convertColorFromName(){
        var key = comBoxColorName.getSelectionModel().getSelectedItem().toString();
        var propertieFilesUtils = new PropertieFilesUtils();
        var colorProperties = propertieFilesUtils.loadPropertiesFile(MyVariables.colorsPropertiesFile);
        var color = propertieFilesUtils.getPropertyValue(key,colorProperties);
        rectangleColor.setFill(Color.web(color));
    }


}
