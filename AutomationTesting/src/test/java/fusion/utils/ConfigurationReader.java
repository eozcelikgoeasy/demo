package fusion.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- create properties object
    //2- get the path and store in String
    //3-  open the file use Fileinputstream method
    //4-  load the file to properties object by using load method from properties
    //5- close.file
    //plus dont forget to handle exceptions

    //1- create properties object
    private static Properties properties=new Properties();
    //encapsulation is hiding data from outside and then using getter method to get detail

    static { // will get excute before everything
        //2- get the path and store in String
        String pathForProperties="Configuration.properties";
        //3-  open the file use Fileinputstream method

        try {
            FileInputStream fileInputStream=new FileInputStream(pathForProperties);
            //4-  load the file to properties object by using load method from properties
            properties.load(fileInputStream); // file needs to be loaded in the automation

            //5- close.file
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Properties file not founded.");
        }


    }


    public static String getProperties(String keyWord) {

        return properties.getProperty(keyWord);
    }
}
