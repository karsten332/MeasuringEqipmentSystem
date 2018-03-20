import java.util.*;

public class MeterArchive {

    private List<Meter> content;

    public MeterArchive(){
        content = new ArrayList<>();
    }

    public void add(Meter meter){
        content.add(meter);
    }

    public boolean remove(String number){
        for(int i = 0; i <content.size(); i++){
            if(content.get(i).getRegistrationNumber().equals(number)){
                content.remove(i);
                return true;
            }
        }
        return false;
    }

    public Meter getMeter(String number){
        for(int i = 0; i <content.size(); i++){
            if(content.get(i).getRegistrationNumber().equals(number)){
                return content.get(i);
            }
        }
        return null;
    }

    /**
     * Checks if the registration number is already in use.
     * Make sure that two objects can't have the same  registration number.
     * @param regNumber
     * @return true/false
     */
    public boolean checkRegistrationNumber(String regNumber){
        for (int i = 0; i <content.size(); i++){
            if (content.get(i).getRegistrationNumber().equals(regNumber)){
                return false;
            }

        }
        return true;
    }

    /**
     * Change the registration number to new registration number.
     * @param registrationNumber String of current registration number
     * @param newRegistrationNumber String of new registration number
     * @return true/false
     */
    public boolean setRegistrationNumber(String registrationNumber, String newRegistrationNumber){
        for(int i=0; i <content.size(); i++){
            if(content.get(i).getRegistrationNumber().equals(registrationNumber)){
                content.get(i).setRegistrationNumber(newRegistrationNumber);

                return true;
            }
        }
        return false;
    }

    /**
     *  Change the meter from good to broken
     * @param registrationNumber
     * @return true or false
     */
    public boolean setMeterBroken(String registrationNumber){
        for(int i=0; i <content.size(); i++){
            if(content.get(i).getRegistrationNumber().equals(registrationNumber)){
                content.get(i).setState(false);

                return true;
            }
        }
        return false;
    }

    /**
     * Prints out the content in ArrayList
     */
    public void show(){
        for(Meter meter : content){
            meter.display();
            System.out.println();
        }
    }

}
