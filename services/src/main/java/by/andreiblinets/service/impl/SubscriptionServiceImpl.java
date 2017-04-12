package by.andreiblinets.service.impl;

import by.andreiblinets.dao.impl.ISubscriptionDAOImpl;
import by.andreiblinets.entity.Subscription;
import by.andreiblinets.service.IService;

import java.util.List;

public class SubscriptionServiceImpl implements IService<Subscription> {

    private static SubscriptionServiceImpl instance;
    private ISubscriptionDAOImpl subscriptionDAO = ISubscriptionDAOImpl.getInstance();

    public synchronized static SubscriptionServiceImpl getInstance() {
        if (instance == null) {
            instance = new SubscriptionServiceImpl();
        }
        return instance;
    }

    public Long add(Subscription subscription) {
        return subscriptionDAO.create(subscription);
    }

    public void update(Subscription subscription) {
        subscriptionDAO.update(subscription);
    }

    public List<Subscription> getAll() {
        return subscriptionDAO.readAll();
    }

    public void delete(Long id) {
        subscriptionDAO.delete(id);
    }

    public Subscription getById(Long id) {
        return subscriptionDAO.readById(id);
    }

}
