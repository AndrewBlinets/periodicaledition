package by.andreiblinets.service.command.user;


import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class GoToRegistration implements ICommand {

    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getInstance().getProperty(PagePath.REGISTRATION_PAGE);
        return page;
       // return null;
    }
}
