package tdd.taxi;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

//Done 不超过8公里时每公里0.8元
//Done 超过8公里则每公里加收50%长途费
//Done 停车等待时加收每分钟0.25元
public class TaxiTest {

    private static final double DELTA = 0.00001;

    @Test
    public void should_be_0p8yuan_when_distance_is_1km() {
        verifyCalculate(1, 0.8);
    }

    @Test
    public void should_be_6p4yuan_when_distance_is_8km() {
        verifyCalculate(8, 6.4);
    }

    private void verifyCalculate(int distance, double expected) {
        final Taxi taxi = new Taxi();
        double actual = taxi.calculate(distance,0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void should_be_7p6yuan_when_distance_is_9km() {
        verifyCalculate(9, 7.6);
    }

    @Test
    public void should_be_5p85yuan_when_distance_is_7km_and_wait_1_minute() {
        verifyWaitMinuteCalculate(7, 5.85,1);
    }

    private void verifyWaitMinuteCalculate(int distance, double expect,int waitMinute) {
        final Taxi taxi = new Taxi();
        double actual = taxi.calculate(distance, waitMinute);//7*0.8+0.25
        assertEquals(expect, actual, DELTA);
    }

    @Test
    public void should_be_7p85yuan_when_distance_is_9km_and_wait_1_minute() {
        verifyWaitMinuteCalculate(9, 7.85,1);
    }

    @Test
    public void should_be_8p1yuan_when_distance_is_9km_and_wait_2_minute() {
        verifyWaitMinuteCalculate(9,8.1 ,2);//9*0。8+2*0.25+1*0.4
    }



}
