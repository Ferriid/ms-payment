public class Cash extends Payment{
    public Cash(Customer customer, double amount) {
        super(customer, amount);
    }

    @Override
    public double pay() {
        System.out.println("Successfully cash payment");
        return 0;
    }


}
