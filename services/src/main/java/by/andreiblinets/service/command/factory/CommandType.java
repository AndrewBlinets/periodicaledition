package by.andreiblinets.service.command.factory;

import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.user.GoBackCommand;
import by.andreiblinets.service.command.user.GoToRegistration;
import by.andreiblinets.service.command.user.LoginUser;

public enum CommandType {

    LOGIN, GOTOREGISTRATION, BACK;

    public ICommand getCurrentCommand() throws EnumConstantNotPresentException{
        switch(this){
            case LOGIN:
                return new LoginUser();

            case GOTOREGISTRATION:
                return new GoToRegistration();

            case BACK:
                return new GoBackCommand();

            default:
                return new LoginUser();
        }
    }

}
