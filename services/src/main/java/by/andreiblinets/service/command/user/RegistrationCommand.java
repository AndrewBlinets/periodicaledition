package by.andreiblinets.service.command.user;

import by.andreiblinets.dao.entity.User;
import by.andreiblinets.dao.entity.enums.UserRole;
import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.MessageConstants;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.constans.Parameters;
import by.andreiblinets.service.command.manager.ConfigurationManager;
import by.andreiblinets.service.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class RegistrationCommand implements ICommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        User user = null;

            user = getUser(request);
            if(areFieldsNull(user)){
                if(!UserServiceImpl.getInstance().chekLogin(user)){
                    UserServiceImpl.getInstance().add(user);
                    page = ConfigurationManager.getInstance().getProperty(PagePath.INDEX_PAGE);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageConstants.SUCCESS_OPERATION);
                }
                else{
                    page = ConfigurationManager.getInstance().getProperty(PagePath.REGISTRATION_PAGE);
                    request.setAttribute(Parameters.ERROR_USER_EXISTS, MessageConstants.USER_EXISTS);
                }
            }
            else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageConstants.EMPTY_FIELDS);
                page = ConfigurationManager.getInstance().getProperty(PagePath.REGISTRATION_PAGE);
            }

        return page;
    }

    private boolean areFieldsNull(User user) {
        if (!user.getName().isEmpty()
                & !user.getLogin().isEmpty()
                & !user.getPassword().isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private User getUser(HttpServletRequest request) {
        String name = request.getParameter(Parameters.USER_NAME);
        String login = request.getParameter(Parameters.USER_LOGIN);
        String password = request.getParameter(Parameters.USER_PASSWORD);
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setUserRole(UserRole.DISPATCHER);
        return user;
    }
}
