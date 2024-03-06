package dispatch;

import fireDrill1.fireDrill2.InvalidNumberException;

public class Dispatch {
    private static int deliveries(int numberOfDeliveries){
        if(numberOfDeliveries < 50)
            return 160;
        if(numberOfDeliveries >= 50 && numberOfDeliveries <60)
            return 200;
        if(numberOfDeliveries >= 60 && numberOfDeliveries <70)
            return 250;
        if(numberOfDeliveries >= 70)
            return 500;
        return 0;
    }
    public static int wage(int successfulDeliveries){
        if (successfulDeliveries < 0 || successfulDeliveries > 100)
            throw new InvalidNumberException();
        return (successfulDeliveries * deliveries(successfulDeliveries))+ 5000;
    }
}
