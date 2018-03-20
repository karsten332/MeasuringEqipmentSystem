import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {

    @Test
    void getTimeInterval() {
        double timeInterval = 40;
        Clock clock = new Clock("40", false, "A40",timeInterval);
        assertEquals(40,clock.getTimeInterval());

    }

    @Test
    void setTimeInterval() {
    Clock clock = new Clock("40", false, "A40",40);
    clock.setTimeInterval(60);
    assertEquals(60,clock.getTimeInterval());
    }

    @Test
    void display(){
        Clock clock1 = new Clock("69", false, "here", 60);
        clock1.display();
    }

}