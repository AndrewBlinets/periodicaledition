package by.andreiblinets.service.command.user;

import by.andreiblinets.dao.entity.PeriodicalEdition;
import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.constans.Parameters;
import by.andreiblinets.service.command.manager.ConfigurationManager;
import by.andreiblinets.service.service.impl.PeriodicalEditionServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowEdition implements ICommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        List<PeriodicalEdition> list = PeriodicalEditionServiceImpl.getInstance().getAll();
        session.setAttribute(Parameters.PERIODICAL_LIST, list);
        page = ConfigurationManager.getInstance().getProperty(PagePath.PERIODICAL_PAGE);
        return page;
    }
}
