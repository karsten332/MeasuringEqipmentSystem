
public class Weight extends Meter {
    private double minWeight;
    private double maxWeight;

    public Weight(){

    }

    public Weight(String registrationNumber, boolean state, String location, double minWeight, double maxWeight) {
        super(registrationNumber,state,location);
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void display(){
        System.out.println("Weight");
        super.display();
        System.out.println("Max Weight: " + getMaxWeight());
        System.out.println("Min Weight: " + getMinWeight());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Weight weight = (Weight) o;
        return Double.compare(weight.getMinWeight(), getMinWeight()) == 0 &&
                Double.compare(weight.getMaxWeight(), getMaxWeight()) == 0;
    }

    @Override
    public String toString() {
        return super.toString() + "Weight{" +
                "minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                '}';
    }
}

