package by.andreiblinets.service.command.admin;

import by.andreiblinets.dao.dao.impl.PaymentDAOImpl;
import by.andreiblinets.dao.entity.PeriodicalEdition;
import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.MessageConstants;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.constans.Parameters;
import by.andreiblinets.service.command.manager.ConfigurationManager;
import by.andreiblinets.service.service.impl.PeriodicalEditionServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddEdition implements ICommand {

    private static Logger logger = Logger.getLogger(PaymentDAOImpl.class.getName());

    public String execute(HttpServletRequest request) {
        String page;
        PeriodicalEdition periodicalEdition;
        try {
            periodicalEdition = getPeriodicalEdition(request);
            if (areFieldsNull(periodicalEdition)) {
                PeriodicalEditionServiceImpl.getInstance().add(periodicalEdition);
                page = ConfigurationManager.getInstance().getProperty(PagePath.ADMIN_PAGE);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageConstants.SUCCESS_OPERATION);
            } else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageConstants.EMPTY_FIELDS);
                page = ConfigurationManager.getInstance().getProperty(PagePath.ADD_ERITION_PAGE);
            }
        }
        catch (NumberFormatException e)
        {
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageConstants.PRICE_MUST_NUMBER);
            page = ConfigurationManager.getInstance().getProperty(PagePath.ADD_ERITION_PAGE);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
            page = ConfigurationManager.getInstance().getProperty(PagePath.ERROR_PAGE);
        }
        return page;
    }

    private boolean areFieldsNull(PeriodicalEdition periodicalEdition) {
        if (!periodicalEdition.getName().isEmpty()
                & periodicalEdition.getPrice() != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private PeriodicalEdition getPeriodicalEdition(HttpServletRequest request) throws NumberFormatException {
        String name = request.getParameter(Parameters.PERIODICAL_EDITION_NAME);
        String price = request.getParameter(Parameters.PERIODICAL_EDITION_PRACE);
        PeriodicalEdition periodicalEdition = new PeriodicalEdition();
        periodicalEdition.setName(name);
        periodicalEdition.setPrice(Double.parseDouble(price));
        return periodicalEdition;
    }
}
