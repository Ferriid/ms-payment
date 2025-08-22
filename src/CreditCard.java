public class CreditCard extends Payment implements EDV {
    public CreditCard(Customer customer, double amount) {
        super(customer, amount);
    }

    @Override
    public double pay() {
        System.out.println("Successfully credit card payment");
        return 0;
    }
}
