import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeterArchiveTest {

    @Test
    void add() {
        Clock c2 = new Clock("3",true,"A2",60.00);
        MeterArchive meterArchive = new MeterArchive();

        meterArchive.add(c2);
    }

    @Test
    void remove() {

        MeterArchive meterArchive = new MeterArchive();
        Clock c1 = new Clock("3",true,"A2",60.00);
        Thermometer t1 = new Thermometer("4",false,"A3",0,400);
        Weight w1 = new Weight("5",true,"A4",0,100);

        meterArchive.add(c1);
        meterArchive.add(t1);
        meterArchive.add(w1);

        meterArchive.remove("5");

        assertNull(meterArchive.getMeter("5"));



    }

    @Test
    void getMeter() {
        MeterArchive meterArc1 = new MeterArchive();
        Weight weight1 = new Weight("2", false, "A2", 20, 60);
        meterArc1.add(weight1);
        assertSame(weight1, meterArc1.getMeter("2"));
    }

    @Test
    void setRegistrationNumber() {

        String registrationNumber = "3";
        String newRegistrationNumber = "6";
        MeterArchive meterArchive = new MeterArchive();
        Clock c2 = new Clock("3",true,"A2",60.00);
        Thermometer t1 = new Thermometer("4",false,"A3",0,400);
        Weight w1 = new Weight("5",true,"A4",0,100);

        meterArchive.add(c2);
        meterArchive.add(t1);
        meterArchive.add(w1);

        meterArchive.setRegistrationNumber(registrationNumber,newRegistrationNumber);

        assertEquals("6",c2.getRegistrationNumber());



    }

    @Test
    void setMeterBroken() {

        boolean answer = false;
        String registrationNumber = "3";

        MeterArchive meterArchive = new MeterArchive();
        Clock c1 = new Clock("3",true,"A2",60.00);
        Thermometer t1 = new Thermometer("4",false,"A3",0,400);
        Weight w1 = new Weight("5",true,"A4",0,100);

        meterArchive.add(c1);
        meterArchive.add(t1);
        meterArchive.add(w1);

        meterArchive.setMeterBroken(registrationNumber);

        assertEquals(answer,c1.isState());


    }

    @Test
    void show() {
        MeterArchive meterArchive = new MeterArchive();
        Clock c2 = new Clock("3",true,"A2",60.00);
        Thermometer t1 = new Thermometer("4",false,"A3",0,400);
        Weight w1 = new Weight("5",true,"A4",0,100);

        meterArchive.add(c2);
        meterArchive.add(t1);
        meterArchive.add(w1);

        meterArchive.show();


    }
}