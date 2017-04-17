package by.andreiblinets.service.command;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
    String execute(HttpServletRequest request);
}
