package by.andreiblinets.service.command.util;

import by.andreiblinets.service.command.factory.CommandType;

import javax.servlet.http.HttpServletRequest;
import by.andreiblinets.service.command.constans.Parameters;

public class RequestParameterParser {
    public static CommandType getCommandType(HttpServletRequest request){
        String commandName = request.getParameter(Parameters.COMMAND);
        CommandType commandType = CommandType.LOGIN;
        if(commandName != null) {
            commandType = CommandType.valueOf(commandName.toUpperCase());
        }
        return commandType;
    }
}
