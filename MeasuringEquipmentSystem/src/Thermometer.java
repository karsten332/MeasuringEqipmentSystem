
public class Thermometer extends Meter {
    private double minTemperature;
    private double maxTemperature;

    public Thermometer() {

    }

    public Thermometer(String registrationNumber, boolean state, String location, double minTemperature, double maxTemperature) {
        super(registrationNumber,state,location);
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void display(){
        System.out.println("Thermometer");
        super.display();
        System.out.println("Max Temperature: " + getMaxTemperature() +"°C");
        System.out.println("Min Temperature: " + getMinTemperature() + "°C");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Thermometer that = (Thermometer) o;
        return Double.compare(that.getMinTemperature(), getMinTemperature()) == 0 &&
                Double.compare(that.getMaxTemperature(), getMaxTemperature()) == 0;
    }

    @Override
    public String toString() {
        return super.toString() + "Thermometer{" +
                "minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}


