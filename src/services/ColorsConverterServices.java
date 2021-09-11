package services;

public class ColorsConverterServices {

    /**
     * Fonction qui convertie une couleur rgb au format hexa
     * @param red
     * @param green
     * @param blue
     * @return
     */
    public String convertRGBToHex(int red, int green, int blue){
        var hex = String.format("#%02X%02X%02X", red, green, blue);
        return hex;
    }

}
