import java.util.ArrayList;

public abstract class Payment {
    public Customer customer;
    public double amount;

    public Payment(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public abstract double pay();

}