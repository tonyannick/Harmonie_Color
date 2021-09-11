package services;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.text.DecimalFormat;

public class SliderServices {
//TextField textFieldColorResult
    public void onSliderChange(Slider slider, TextField textFieldColorFrom){
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textFieldColorFrom.setText((new DecimalFormat("#").format(newValue)));
            }
        });

    }

    public void initializeSlider(Slider sliderColor,int positionColor){
        sliderColor.setMin(0);
        sliderColor.setShowTickLabels(true);
    }
}
