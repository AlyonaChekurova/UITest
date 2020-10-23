package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс для работы с файлом resources/conf.properties
 * Создает поток для чтения данных из файла resources/conf.properties и сохраняет параметры в объекте типа Properties
 * Содержит метод для возврата значения параметра по его идентификатору
 */
public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    /**
     * Создает поток для чтения данных из файла и сохраняет параметры в объекте типа Properties
     */
    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * Метод для возврата значения параметра по его идентификатору
     * @param key - идентификатор параметра
     * @return значение параметра, соответсвующее идентификатору key
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}