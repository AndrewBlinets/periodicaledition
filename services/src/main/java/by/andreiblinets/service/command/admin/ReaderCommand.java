package by.andreiblinets.service.command.admin;

import by.andreiblinets.dao.dao.impl.PaymentDAOImpl;
import by.andreiblinets.dao.entity.User;
import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.constans.Parameters;
import by.andreiblinets.service.command.manager.ConfigurationManager;
import by.andreiblinets.service.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ReaderCommand implements ICommand {

    private static Logger logger = Logger.getLogger(PaymentDAOImpl.class.getName());

    public String execute(HttpServletRequest request) {
        String page = null;
        try{
            HttpSession session = request.getSession();
            List<User> list = UserServiceImpl.getInstance().getAll();
            session.setAttribute(Parameters.READERS_LIST, list);
            page = ConfigurationManager.getInstance().getProperty(PagePath.ADMIN_SHOW_READER);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            page = ConfigurationManager.getInstance().getProperty(PagePath.ERROR_PAGE);
        }
        return page;
    }
}
