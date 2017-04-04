package by.andreiblinets.dao;

import by.andreiblinets.entity.PeriodicalEdition;

import java.util.List;

public interface PeriodicalEditionDAO {
    void addPeridicalEdition(PeriodicalEdition periodicalEdition);
    List<PeriodicalEdition> getAllPeridicalEdition();
}
