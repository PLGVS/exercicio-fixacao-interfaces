package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String [] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("Entre os dados do contrato: ");
            System.out.print("Numero: ");
            int number = sc.nextInt();
            System.out.print("Data (dd/MM/yyyy): ");
            Date date = sdf.parse(sc.next());
            System.out.print("Valor do contrato: ");
            double value = sc.nextDouble();
            System.out.print("Entre com o número de parcelas: ");
            int installmentQuantity = sc.nextInt();

            Contract c = new Contract(number, date, value, installmentQuantity, new PaypalService());

            for (Installment i : c.getInstallmentList()){
                System.out.println(sdf.format(i.getDueDate()) + " - " + i.getAmount());
            }

        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
    }
}
