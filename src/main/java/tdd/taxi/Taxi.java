package tdd.taxi;

public class Taxi {

    private static final double UNIT_PRICE = 0.8;
    public static final double UNIT_WAITINT_PRICE = 0.25;
    public static final int BASIC_DISTANCE = 8;


    public double calculate(int distance, int waitMinute) {
        double basice_price=UNIT_PRICE * distance;
        double wait_price= UNIT_WAITINT_PRICE *waitMinute;
        if(distance<=BASIC_DISTANCE){
            return basice_price+ wait_price;
        }
        return basice_price+(distance- BASIC_DISTANCE)*(UNIT_PRICE/2)
                +wait_price;
    }
}
