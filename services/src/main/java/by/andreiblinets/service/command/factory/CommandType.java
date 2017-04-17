package by.andreiblinets.service.command.factory;

import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.user.GoToRegistration;
import by.andreiblinets.service.command.user.LoginUser;

public enum CommandType {

    LOGIN, GOTOREGISTRATION;

    public ICommand getCurrentCommand() throws EnumConstantNotPresentException{
        switch(this){
            case LOGIN:
                return new LoginUser();

            case GOTOREGISTRATION:
                return new GoToRegistration();

            default:
                return new LoginUser();
        }
    }

}
