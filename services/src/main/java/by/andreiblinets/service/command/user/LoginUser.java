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

public class LoginUser implements ICommand {
    public String execute(HttpServletRequest request) {
            String page = null;
            User user = null;
            user = getLoginAndPassword(request);
            if(areFieldsNull(user)){
                user = UserServiceImpl.getInstance().autification(user.getLogin(),user.getPassword());
                if(user != null){
                    if (user.getUserRole().equals(UserRole.ADMINISTRATOR))
                    {
                        page = ConfigurationManager.getInstance().getProperty(PagePath.ADMIN_PAGE);
                    }
                    else
                    {
                        page = ConfigurationManager.getInstance().getProperty(PagePath.DISPATCHER_PAGE);
                    }
                }
                else{
                    page = ConfigurationManager.getInstance().getProperty(PagePath.INDEX_PAGE);
                    request.setAttribute(Parameters.ERROR_USER_LOGIN_OR_PASSWORD, MessageConstants.ERROR_USER_LOGIN_OR_PASSWORD);
                }
            }
            else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageConstants.EMPTY_FIELDS);
                page = ConfigurationManager.getInstance().getProperty(PagePath.REGISTRATION_PAGE);
            }

            return page;
        }

    private boolean areFieldsNull(User user) {
        if (!user.getLogin().isEmpty()
                & !user.getPassword().isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private User getLoginAndPassword(HttpServletRequest request) {
        String login = request.getParameter(Parameters.USER_LOGIN);
        String password = request.getParameter(Parameters.USER_PASSWORD);
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }
}
