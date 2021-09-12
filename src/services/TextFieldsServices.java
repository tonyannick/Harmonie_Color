package services;


import javafx.scene.control.TextField;

/**
 * @author NTOUTOUME MENZOUGHE YANNICK
 * @version 1.0
 *
 */
public class TextFieldsServices {

    /**
     * Fonction qui remet les textfieds à zero
     * @param textField
     */
    public void initializeTextFields(TextField textField){
        textField.setText("0");
    }
}
