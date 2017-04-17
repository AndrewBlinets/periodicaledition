package by.andreiblinets.service.service.impl;


import by.andreiblinets.dao.dao.impl.PaymentDAOImpl;
import by.andreiblinets.dao.entity.Payment;
import by.andreiblinets.service.service.IService;

import java.util.List;

public class PaymentServiceImpl implements IService<Payment> {

    private static PaymentServiceImpl instance;
    private PaymentDAOImpl paymentDAO = PaymentDAOImpl.getInstance();

    public synchronized static PaymentServiceImpl getInstance() {
        if (instance == null) {
            instance = new PaymentServiceImpl();
        }
        return instance;
    }

    public Long add(Payment payment) {
        return paymentDAO.create(payment);
    }

    public void update(Payment payment) {
        paymentDAO.update(payment);
    }

    public List<Payment> getAll() {
        return paymentDAO.readAll();
    }

    public void delete(Long id) {
        paymentDAO.delete(id);
    }

    public Payment getById(Long id) {
        return paymentDAO.readById(id);
    }

}
