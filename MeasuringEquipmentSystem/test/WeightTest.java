import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightTest {

    @Test
    void getMinWeight() {
        double minWeight = 400;
        double maxWeight = 600;
        Weight weight = new Weight("20",true,"B40",minWeight,maxWeight);
        assertEquals(minWeight,weight.getMinWeight());
    }

    @Test
    void setMinWeight() {
        double minWeight = 400;
        double newMinWeight = 200;
        double maxWeight = 600;
        Weight weight = new Weight("20",true,"B40",minWeight,maxWeight);
        weight.setMinWeight(newMinWeight);
        assertEquals(newMinWeight,weight.getMinWeight());

    }

    @Test
    void getMaxWeight() {
        double minWeight = 400;
        double maxWeight = 600;
        Weight weight = new Weight("20",true,"B40",minWeight, maxWeight);
        assertEquals(maxWeight,weight.getMaxWeight());
    }

    @Test
    void setMaxWeight() {
        double minWeight = 400;
        double maxWeight = 600;
        double newMaxWeight = 800;
        Weight weight = new Weight("20",true,"B40",minWeight, maxWeight);
        weight.setMaxWeight(newMaxWeight);
        assertEquals(newMaxWeight,weight.getMaxWeight());

    }

    @Test
    void display() {
        double minWeight = 400;
        double maxWeight = 600;
        Weight weight = new Weight("20",true,"B40",minWeight,maxWeight);
        weight.display();
    }
}