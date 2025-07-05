import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kartin 16 reqemini daxil et:");
        long cardNumber = new Scanner(System.in).nextLong();
        for (;9999999999999999l<cardNumber || cardNumber<1000000000000000l; ){
            System.out.println("Bir daha yoxlayin");
            cardNumber = new Scanner(System.in).nextLong();
        }
        if (cardNumber / 1000000000000000l == 4) {
            System.out.println("Kartnovu: Visa");
        } else if (cardNumber / 1000000000000000l == 5 || cardNumber / 1000000000000000l == 6) {
            System.out.println("Kartnovu: Mastercard");
        } else System.out.println("Kart novu teyin edilmedi");

        System.out.println("Neche eded odenish olacaq? : ");
        int payments = new Scanner(System.in).nextInt();
        double sum=0;
        for (int i = 0; i<payments; i++) {
            System.out.println("Meblegi daxil et:");
            int pay = new Scanner(System.in).nextInt();
            if (pay<=0){
                System.out.println("Yanlish secim.");
                continue;
            }
            else  sum+=pay;

        }
        System.out.println("Mubadile olunacaq mebleg: "+ sum+ " USD");
        System.out.println("Alacaginiz vesait: " + sum*1.7+" AZN" );

    }
}