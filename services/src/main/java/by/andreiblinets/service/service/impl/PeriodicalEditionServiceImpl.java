package by.andreiblinets.service.service.impl;

import by.andreiblinets.dao.dao.impl.PeriodicalEditionDAOImpl;
import by.andreiblinets.dao.entity.PeriodicalEdition;
import by.andreiblinets.service.service.IService;

import java.util.List;

public class PeriodicalEditionServiceImpl implements IService<PeriodicalEdition> {

    private static PeriodicalEditionServiceImpl instance;
    private PeriodicalEditionDAOImpl periodicalEditionDAO = PeriodicalEditionDAOImpl.getInstance();

    public synchronized static PeriodicalEditionServiceImpl getInstance() {
        if (instance == null) {
            instance = new PeriodicalEditionServiceImpl();
        }
        return instance;
    }

    public Long add(PeriodicalEdition periodicalEdition) {
        return periodicalEditionDAO.create(periodicalEdition);
    }

    public void update(PeriodicalEdition periodicalEdition) {
        periodicalEditionDAO.update(periodicalEdition);
    }

    public List<PeriodicalEdition> getAll() {
        return periodicalEditionDAO.readAll();
    }

    public void delete(Long id) {
        periodicalEditionDAO.delete(id);
    }

    public PeriodicalEdition getById(Long id) {
        return periodicalEditionDAO.readById(id);
    }
}
