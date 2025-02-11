package model.entities;

import model.services.PaymentService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Contract {
    private Integer number;
    private Date date;
    private Double value;
    private List<Installment> installmentList = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Contract(){
    }

    public Contract(Integer number, Date date, Double value, Integer installmentQuantity, PaymentService paymentService) {
        this.number = number;
        this.date = date;
        this.value = value;
        for (int i = 0; i < installmentQuantity; i++){
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, i + 1);
            Date dueDate = cal.getTime();
            installmentList.add(new Installment(dueDate, paymentService.payment(value, installmentQuantity, i + 1)));
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Installment> getInstallmentList() {
        return installmentList;
    }

}
