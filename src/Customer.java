import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    ArrayList<Double> customerPayments = new ArrayList<>();

    public void printPayments() {
        System.out.println(customerPayments);
    }

    public static void welcome(Customer customer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select operation type\n" +
                "0. Exit\n" +
                "1. Pay\n" +
                "2. Search a payment\n" +
                "3. Refund a payment\n" +
                "4. Max/min payments\n" +
                "5. Show 3 big payments "
        );
        int operationType = sc.nextInt();
        if (operationType == 0) {
            System.exit(0);
        }
        else if (operationType==1) {
            System.out.println("How will you pay?\n" +
                    "1. Cash\n" +
                    "2. Credit card"
            );
            int payMethod = sc.nextInt();
            System.out.println("Please, input payment amount:");
            double amount = sc.nextDouble();

            if (payMethod == 1) {
                Payment payment = new Cash(customer, amount);

                payment.pay();
                customer.customerPayments.add(amount);
            } else if (payMethod == 2) {
                Payment payment = new CreditCard(customer, amount);
                payment.pay();
                if (payment instanceof EDV) {
                    System.out.println("We will refund to you 18 % EDV");
                }
                customer.customerPayments.add(amount);
            } else {
                System.out.println("Try again..");

            }
        }
        else if (operationType==2) {
            System.out.println("Input which amount do you search:");
            double searchingAmount = sc.nextDouble();
           if (customer.customerPayments.contains(searchingAmount)){
               System.out.println(customer.getName()+" " + "have this payment");
           }
           else
               System.out.println(customer.getName()+" " + "have not this payment");

        }
        else if (operationType==3) {
            System.out.println("Input amount you want to refund:");
            double refundingAmount = sc.nextDouble();
            if (customer.customerPayments.contains(refundingAmount)){
                customer.customerPayments.remove(refundingAmount);
            }
            else System.out.println(customer.getName()+" has not pay this amount");
        }
        else if (operationType==4) {
            double max = 0;
            double min = customer.customerPayments.get(1);
            for (double payments : customer.customerPayments) {
                if (payments > max) {
                    max=payments;
                }
                if (min > payments) {
                    min =payments;
                }
            }
            System.out.println(customer.getName()+"'s max payment:"+max);
            System.out.println(customer.getName()+"'s min payment:"+min);

        }
        else if (operationType==5){
            double max = 0;
            for (Double payments : customer.customerPayments) {
                if (max<payments) {
                    max=payments;
                }
            }
            System.out.println(max);
            double secondMax = 0;
            for (Double payments : customer.customerPayments) {
                if (max>payments && payments>secondMax) {
                    secondMax=payments;
                }
            }
            System.out.println(secondMax);

        double thirdMax = 0;
        for (Double payments : customer.customerPayments) {
            if (secondMax>payments && payments>thirdMax) {
                thirdMax=payments;
            }
        }
        System.out.println(thirdMax);
    }

        customer.printPayments();
        welcome(customer);
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Customer setId(int id) {
        this.id = id;
        return this;
    }
}
