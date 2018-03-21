

import java.util.*;
/**
 * Write a description of class Client3
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client
{
    private  MeterArchive meterArchive;

    private Scanner sn;
    private Populate pop;


    public Client(){

    }

    public static void main(String[] args) {
   try{
       Client obj = new Client();
       obj.mainMethod();

   }
   catch (Exception e) {
       e.printStackTrace();
   }
   }


    public void mainMethod() {
        meterArchive = new MeterArchive();
        pop = new Populate();
        sn = new Scanner(System.in);

        pop.populate(meterArchive);
        populate();
        System.out.println("Change the state of clock with registration number 2 to broken");
        meterArchive.setMeterBroken("2");
        System.out.println("Change the clock with registration number 3 location to A40");
        meterArchive.setLocationNumber("3","A40");
        System.out.println("Remove weight with registration number 5");
        meterArchive.remove("5");
        System.out.println("This is now the list:");
        meterArchive.show();
        System.out.println("Get meter with registration number 3");
        meterArchive.getMeter("3").display();


        Welcome();
        clientResponse();
    }
    Clock c1 = new Clock("2",true,"A1",60.00);
    Clock c2 = new Clock("3",true,"A2",60.00);
    Thermometer t1 = new Thermometer("4",false,"A3",0,400);
    Weight w1 = new Weight("5",true,"A4",0,100);
    /**
     * Gives basic information to user as String.
     */

    public void Welcome(){
        System.out.println("Welcome to Measuring equipment System");
        System.out.println("Type in your commands or type \"help\" for assistance");
    }

    /**
     * Handle the users input and look for keywords to start assignments.
     * End when user types f or finish stop the whole program.
     */
    public void clientResponse() {
        boolean finished = false;
        String text;

        while (!finished){
            System.out.print(">");
            text = sn.nextLine().toLowerCase().trim();

            switch (text){
                case "show" :  meterArchive.show();
                    break;
                case "create" :sn.reset(); create();
                    break;
                case "get":
                    System.out.println("Enter registration number");
                    String n = sn.nextLine();
                    getMeter(n);
                    break;
                case "help" : help();
                    break;
                case "remove" :
                    System.out.println("Enter registration number");
                    String r = sn.nextLine();
                    System.out.println("Removing");
                    getMeter(r);
                    meterArchive.remove(r);
                    System.out.println("Done!");
                    break;
                case "meterbroken" :
                    System.out.println("Enter registration number");
                    String number = sn.nextLine();
                    meterArchive.setMeterBroken(number);
                    getMeter(number);
                    System.out.println("Done!");
                    break;
                case "setnewlocation" :
                    System.out.println("Enter registration number");
                    String registrationNumber = sn.nextLine();
                    System.out.println("Enter new location");
                    String newLocation = sn.nextLine();
                    meterArchive.setLocationNumber(registrationNumber,newLocation);
                    getMeter(registrationNumber);
                    System.out.println("Done!");
                    break;
                case "finished" : finished = true;
                    break;
                case "f" : finished = true;
                    break;
            }
        }
        meterArchive.show();
    }

    /**
     * Gives basic commands to user as String.
     */
    private void help() {
        System.out.println("Type \"show\" to see all the equipment stored.");
        System.out.println("Type \"get\" to see an specific stored item.");
        System.out.println("Type \"remove\" to delete a stored object in the list.");
        System.out.println("Type \"setnewlocation\" to change a registration number.");
        System.out.println("Type \"create\" to create a new meter");
        System.out.println("Type \"meterbroken\" to change a item from good to broken.");
        System.out.println("Type \"finished or \"f\" to end program and show all the equipment.");
    }

    /**
     * Puts meters into the meterArchives ArrayList
     */
    public void populate(){
        Clock c1 = new Clock("2",true,"A1",60.00);
        Clock c2 = new Clock("3",true,"A2",60.00);
        Thermometer t1 = new Thermometer("4",false,"A3",0,400);
        Weight w1 = new Weight("5",true,"A4",0,100);

        meterArchive.add(c1);
        meterArchive.add(c2);
        meterArchive.add(t1);
        meterArchive.add(w1);
        meterArchive.show();
    }

    public void getMeter(String number){
        Meter m = meterArchive.getMeter(number);
        m.display();
        empty();
    }

    /**
     * Used to make new meter based on user input.
     */

    public void create() {
        String regNumber = null;
        String regNumberTest;
        Boolean state = null;
        String status;
        String location;
        String type = null;
        String typeTest;
        Meter name;

        System.out.println("What is the registration number?");
        regNumberTest = sn.nextLine();

        while (regNumber == null){
            if (meterArchive.checkRegistrationNumber(regNumberTest) == false){
                System.out.println( regNumberTest + " is already in use please chose a different one");
                regNumberTest = sn.nextLine();
            }
            else{
                regNumber = regNumberTest;
            }

        }


        System.out.println("What is the state? G/B");
        while (state == null) {
            status = sn.nextLine().toLowerCase().trim();
            if (status.equals("g")){
                state = true;
            } else if (status.equals("b")){
                state = false;
            } else {
                System.out.println("Please type in G/B");
            }
        }

        System.out.println("Where can you find it?");
        location = sn.nextLine().toLowerCase().trim();
        System.out.println("What type is it? (clock,weight, thermometer)");
        typeTest = sn.nextLine().toLowerCase().trim();
        boolean test3 = false;
        while(!test3){
            if(typeTest.equals("clock") || typeTest.equals("weight") || typeTest.equals("thermometer")){
                type = typeTest;
                test3 = true;
            }
            else{
                System.out.println(typeTest + "is not a valid type. Please enter a valid type");
                typeTest = sn.nextLine().toLowerCase().trim();
            }

        }

        switch (type){
               case "clock": double timeInterval = 0;
                   System.out.println("What is the time interval? (00.00)");
                   while (!sn.hasNextDouble()){
                       sn.nextLine();
                       System.out.println("Try again, wrong type");
                   }
                   timeInterval = sn.nextDouble();
                   name = new Clock(regNumber,state,location,timeInterval);
                   meterArchive.add(name);
                   sn.nextLine();
                    break;

            case "thermometer": Double minTemperature = null; Double maxTemperature = null; double minTemperatureCheck = -200; double maxTemperatureCheck = 1000;     double test;

            System.out.println("What is the lowest temperature?");

                while(minTemperature == null){
                    try {
                        test = Double.parseDouble(sn.next());
                        if(test >= minTemperatureCheck){
                            minTemperature = test;
                        }
                        else{
                            System.out.println("minimum temperature must be more than or equal" + minTemperatureCheck);
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("minimum temperature must be more than or equal " + minTemperatureCheck);
                    }
                }
                System.out.println("What is the highest temperature?");

                while (maxTemperature == null){
                    try{
                        test = Double.parseDouble(sn.next());
                     if (test <= maxTemperatureCheck && test > minTemperature){
                            maxTemperature = test;
                     }
                     else {
                         System.out.println("Maximum temperature must be more than minimum temperature and lower than " + maxTemperatureCheck);
                      }
                    }
                    catch (NumberFormatException e){
                        System.out.println("maximum temperature must be more than minimum temperature and lower than" + maxTemperatureCheck);
                    }
                }
                name = new Thermometer(regNumber,state,location,minTemperature,maxTemperature);
                meterArchive.add(name);
                break;
                case "weight" : Double minWeight = null; Double maxWeight = null; double minWeightCheck = 0; double maxWeightCheck = 1000; double testWeight;
                System.out.println("What is the minimum weight?");

                while(minWeight == null){
                    try{
                        testWeight = Double.parseDouble(sn.next());
                        if (testWeight >= minWeightCheck && testWeight <  maxWeightCheck){
                            minWeight = testWeight;
                        }
                        else {
                            System.out.println("minimum weight must be more than or equal " + minWeightCheck + " and less than " +  maxWeightCheck);
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("minimum weight must be more than or equal 0 ");
                    }
                }

                System.out.println("What is the maximum weight?");
                while(maxWeight == null){
                    try{
                        testWeight = Double.parseDouble(sn.next());
                        if (testWeight <= maxWeightCheck && testWeight > minWeight){
                            maxWeight = testWeight;
                        }
                        else {
                            System.out.println("maximum weight must be more than minimum weight and less than " + maxWeightCheck);
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("maximum weight must be more than minimum weight and less than " + maxWeightCheck);
                    }
                }
                name = new Weight(regNumber,state,location,minWeight, maxWeight);
                meterArchive.add(name);
                break;
        }

        System.out.println("You did it!");
    }
    /**
     * Prints out empty lines
     */
    public void empty() {
        for (int i = 0; i > 5; i++) {
            sn.nextLine();
        }
    }
}
