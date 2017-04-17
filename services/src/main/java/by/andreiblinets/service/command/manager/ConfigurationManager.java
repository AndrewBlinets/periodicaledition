package by.andreiblinets.service.command.manager;

import by.andreiblinets.service.command.constans.ConfigConstant;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigConstant.CONFIGS_SOURCE);
    private static ConfigurationManager instance;

    private ConfigurationManager(){}

    public static synchronized ConfigurationManager getInstance(){
        if(instance == null){
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getProperty(String key){
        return bundle.getString(key);
    }
}
