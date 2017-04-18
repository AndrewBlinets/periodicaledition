package by.andreiblinets.service.command.user;

import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class GoBackCommand implements ICommand {

    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getInstance().getProperty(PagePath.INDEX_PAGE);
    }
}
