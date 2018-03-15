import java.util.Objects;

public class Clock extends Meter {
    private double timeInterval;

    public Clock() {
    }

    public Clock(String registrationNumber, boolean state, String location,double timeInterval) {
        super(registrationNumber,state,location);
        this.timeInterval = timeInterval;
    }

    public double getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(double timeInterval) {
        this.timeInterval = timeInterval;
    }

    public void display(){
        System.out.println("Clock");
        super.display();
        System.out.println("Time interval: " + getTimeInterval() + "s");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Clock clock = (Clock) o;
        return Double.compare(clock.getTimeInterval(), getTimeInterval()) == 0;
    }

    @Override
    public String toString() {        return super.toString() + "Clock{" +
                "timeInterval=" + timeInterval +
                '}';


    }
}