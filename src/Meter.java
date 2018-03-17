
import java.util.Objects;

public abstract class Meter {
    private String registrationNumber;
    private boolean state; // true er at den fungerer
    private String location;

    public Meter() {
    }

    public Meter(String registrationNumber, boolean state, String location){
        setRegistrationNumber(registrationNumber);
        setState(state);
        setLocation(location);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {

        this.registrationNumber = registrationNumber;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isState() {

        return state;
    }

    public String getCondition(){
        if(isState() == true){
            return "good";
        }
        else{
            return "broken";
        }
    }
    public String getLocation() {
        return location;
    }

    public void display(){
        System.out.println("Registration number: " + getRegistrationNumber());
        System.out.println("Condition: " + getCondition());
        System.out.println("Location: " + getLocation());

    }

    @Override
    public String toString() {
        return
                "Meter{" +
                        "registrationNumber='" + registrationNumber + '\'' +
                        ", state=" + state +
                        ", location='" + location + '\'' +
                        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meter meter = (Meter) o;
        return isState() == meter.isState() &&
                Objects.equals(getRegistrationNumber(), meter.getRegistrationNumber()) &&
                Objects.equals(getLocation(), meter.getLocation());
    }

}
