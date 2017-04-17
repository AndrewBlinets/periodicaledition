package by.andreiblinets.service.command.factory;

import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.user.LoginUser;
import by.andreiblinets.service.command.util.RequestParameterParser;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static CommandFactory instance;

    private CommandFactory(){}

    public static synchronized CommandFactory getInstance(){
        if(instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }

    public ICommand defineCommand(HttpServletRequest request){
        ICommand current = null;
        try{
            CommandType type = RequestParameterParser.getCommandType(request);
            current = type.getCurrentCommand();
        }
        catch(IllegalArgumentException e){
            current = new LoginUser();
        }
        return current;
    }
}
