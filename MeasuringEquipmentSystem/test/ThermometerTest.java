import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThermometerTest {

    @Test
    void getMinTemperature() {
        double minTemp = 20;
        double maxTemp = 40;
        Thermometer thermometer = new Thermometer("40",false,"A20",minTemp,maxTemp);
        assertEquals(minTemp,thermometer.getMinTemperature());}

    @Test
    void setMinTemperature() {
        double minTemp = 20;
        double newMinTemp = 30;

        double maxTemp = 40;
        Thermometer thermometer = new Thermometer("40",false,"A20",minTemp,maxTemp);

        thermometer.setMinTemperature(newMinTemp);
        assertEquals(newMinTemp,thermometer.getMinTemperature());
    }

    @Test
    void getMaxTemperature() {
        double minTemp = 20;
        double maxTemp = 40;
        Thermometer thermometer = new Thermometer("40",false,"A20",minTemp,maxTemp);
        assertEquals(maxTemp,thermometer.getMaxTemperature());
    }



    @Test
    void setMaxTemperature() {
        double minTemp = 20;
        double maxTemp = 40;
        double newMaxTemp = 400;
        Thermometer thermometer = new Thermometer("40",false,"A20",minTemp,maxTemp);
        thermometer.setMaxTemperature(newMaxTemp);
        assertEquals(newMaxTemp,thermometer.getMaxTemperature());
    }

    @Test
    void display() {
        double minTemp = 20;
        double maxTemp = 40;
        Thermometer thermometer = new Thermometer("40",false,"A20",minTemp,maxTemp);
        thermometer.display();
    }
}