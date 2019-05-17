package com.Stiw3054.groupProject;

import java.io.*;
import java.util.Properties;

class PropertiesFile {
    String line;

    private Properties prop = new Properties();

    String ReadPropertiesPath() {
        try (InputStream input = new FileInputStream("config.properties")) {
            // load a properties file;
            prop.load(input);
            line = prop.getProperty("path");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    String ReadPropertiesName() {
        try (InputStream input = new FileInputStream("config.properties")) {
            // load a properties file
            prop.load(input);
            line = prop.getProperty("textFile");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    String ReadPropertiesState() {
        try (InputStream input = new FileInputStream("config.properties")) {
            // load a properties file
            prop.load(input);
            line = prop.getProperty("state");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    String ReadPropertiesTop() {
        try (InputStream input = new FileInputStream("config.properties")) {
            // load a properties file
            prop.load(input);
            line = prop.getProperty("top");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
    String ReadPropertiesPlayer() {
        try (InputStream input = new FileInputStream("config.properties")) {
            // load a properties file
            prop.load(input);
            line = prop.getProperty("player");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }

}
