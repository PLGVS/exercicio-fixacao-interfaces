package model.services;

public class PaypalService implements PaymentService{

    @Override
    public double payment(double value, int installmentQuantity, int installmentNumber){
        double baseValue = (value/installmentQuantity) + ((value/installmentQuantity) * (0.01 * installmentNumber));
        return baseValue + (baseValue * 0.02);
    }
}
