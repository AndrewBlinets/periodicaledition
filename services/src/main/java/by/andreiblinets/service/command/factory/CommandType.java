package by.andreiblinets.service.command.factory;

import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.admin.ReaderCommand;
import by.andreiblinets.service.command.user.*;

public enum CommandType {

    LOGIN, GOTOREGISTRATION, BACK, REGISTRATION, LOGOUT, READER;

    public ICommand getCurrentCommand() throws EnumConstantNotPresentException{
        switch(this){
            case LOGIN:
            {
                return new LoginUser();
            }

            case GOTOREGISTRATION:
            {
                return new GoToRegistration();
            }

            case BACK:
            {
                return new BackCommand();
            }

            case REGISTRATION:
            {
                return new Registration();
            }

            case LOGOUT:
                return new LogoutUser();

            case READER:
            {
                return new ReaderCommand();
            }

            default:
            {
                return new LoginUser();
            }
        }
    }

}
