package utilityRetrofit;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;




public class ConfigReader {

    private static Properties properties  = new Properties();
    public static String readConfigurationFile(String key) {
        try{
            properties = new Properties();
            properties.load(new FileInputStream("./TestConfiguration/cfg.properties"));

        } catch (Exception e){
            System.out.println("Cannot find key: "+key+" in Config file due to exception : "+e);
        }
        return properties.getProperty(key).trim();
    }

}