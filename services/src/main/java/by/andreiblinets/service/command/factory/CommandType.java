package by.andreiblinets.service.command.factory;

import by.andreiblinets.service.command.ICommand;
import by.andreiblinets.service.command.admin.Add;
import by.andreiblinets.service.command.admin.AddEdition;
import by.andreiblinets.service.command.admin.BackAdmin;
import by.andreiblinets.service.command.admin.ReaderCommand;
import by.andreiblinets.service.command.user.*;

public enum CommandType {

    LOGIN, GOTOREGISTRATION, BACK, REGISTRATION, LOGOUT, READER, EDITIONS,
    BACKADMIN, ADDEDITION, ADD;

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

            case EDITIONS:
            {
                return new ShowEdition();
            }

            case BACKADMIN:
            {
                return new BackAdmin();
            }

            case ADDEDITION:
            {
                return new AddEdition();
            }

            case ADD:
            {
                return new Add();
            }

            default:
            {
                return new LoginUser();
            }
        }
    }

}
