package by.andreiblinets.service.command.admin;

import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class Add implements ICommand {
    public String execute(HttpServletRequest request) {
       return ConfigurationManager.getInstance().getProperty(PagePath.ADD_ERITION_PAGE);
    }
}
