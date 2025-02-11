package model.services;

public interface PaymentService {
    double payment(double value, int installmentQuantity, int installmentNumber);
}
