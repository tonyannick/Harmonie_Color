package services;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

/**
 * @author NTOUTOUME MENZOUGHE YANNICK
 * @version 1.0
 *
 */
public class SliderServices {
    /**
     * Fonction qui gère le deplacement en temps réels d'un slider
     * @param slider
     * @param textFieldColorFrom
     */
    public void onSliderChange(Slider slider, TextField textFieldColorFrom){
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textFieldColorFrom.setText((new DecimalFormat("#").format(newValue)));
            }
        });

    }

    /**
     * Fonction qui remet le slider à zero
     * @param sliderColor
     * @param positionColor
     */
    public void initializeSlider(Slider sliderColor,int positionColor){
        sliderColor.setMin(0);
        sliderColor.setShowTickLabels(true);
    }
}
