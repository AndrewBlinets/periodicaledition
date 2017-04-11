package by.andreiblinets.dao;

import by.andreiblinets.entity.PeriodicalEdition;

import java.util.List;

public interface IPeriodicalEditionDAO {
    void addPeridicalEdition(PeriodicalEdition periodicalEdition);
    List<PeriodicalEdition> getAllPeridicalEdition();
}
