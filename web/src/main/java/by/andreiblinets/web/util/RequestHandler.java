package by.andreiblinets.web.util;

import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.constans.PagePath;
import by.andreiblinets.service.command.factory.CommandFactory;
import by.andreiblinets.service.command.manager.ConfigurationManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestHandler {

    private RequestHandler() {
    }

    public static void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CommandFactory commandFactory = CommandFactory.getInstance();
        ICommand сommand = commandFactory.defineCommand(request);
        String page = сommand.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getInstance().getProperty(PagePath.INDEX_PAGE);
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
