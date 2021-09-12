package file;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

/**
 * @author NTOUTOUME MENZOUGHE YANNICK
 * @version 1.0
 *
 */
public class PropertieFilesUtils {

    /**
     * Fonction qui lit le contenu d'un fichier properties
     * @param nomFichier
     * @throws IOException si l'url n'est pas valabe
     * @return
     */
    public Properties loadPropertiesFile(String nomFichier){
        var properties = new Properties();
        try( var inputStream = PropertieFilesUtils.class.getClassLoader().getResourceAsStream(nomFichier)) {
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Fonction qui recupere toutes les clés d'un fichier properties
     * @param properties
     * @return set contenant les clés du fichier
     */
    public Set<Object> getAllPropertiesKeys(Properties properties){
        Set<Object> keys = properties.keySet();
        return keys;
    }

    /**
     * Fonction qui récupère la valeur d'une clé
     * @param key
     * @param properties
     * @return la valeur de la clé
     */
    public String getPropertyValue(String key, Properties properties){
        var allValues = properties.getProperty(key);
        return allValues;
    }
}
