package by.andreiblinets.service.command.admin;

import by.andreiblinets.dao.entity.User;
import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.constans.Parameters;
import by.andreiblinets.service.command.manager.ConfigurationManager;
import by.andreiblinets.service.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ReaderCommand implements ICommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        List<User> list = UserServiceImpl.getInstance().getAll();
        session.setAttribute(Parameters.READERS_LIST, list);
        page = ConfigurationManager.getInstance().getProperty(PagePath.ADMIN_SHOW_READER);
        return page;
    }
}
