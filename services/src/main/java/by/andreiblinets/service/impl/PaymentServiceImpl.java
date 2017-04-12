package by.andreiblinets.service.impl;


import by.andreiblinets.dao.impl.IPaymentDAOImpl;
import by.andreiblinets.entity.Payment;
import by.andreiblinets.service.IService;

import java.util.List;

public class PaymentServiceImpl implements IService<Payment> {

    private static PaymentServiceImpl instance;
    private IPaymentDAOImpl paymentDAO = IPaymentDAOImpl.getInstance();

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
