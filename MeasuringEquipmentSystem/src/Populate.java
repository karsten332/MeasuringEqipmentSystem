
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class Populate {

    public static void  serialize(){
        Meter clock20 = new Clock("40",true,"A6",60.00);

        Gson gson = new Gson();
        String json = gson.toJson(clock20);
        System.out.println(json);
    }

    public  static  void populate(MeterArchive meterArchive){
        Gson gson = new Gson();

        try (Reader reader = new FileReader("src/text.json")){
            Clock clock20 = gson.fromJson(reader,Clock.class);
            System.out.println(clock20);
            meterArchive.add(clock20);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
   /* public static void populate(MeterArchive meterArchive){
        String clock40 ="{'registrationNumber' :'401','state' : true,'location' : 'A69',timeInterval :40.00}";

        Gson gson = new Gson();

        Clock clock20 = gson.fromJson(clock40,Clock.class);

        System.out.println(clock20);
        meterArchive.add(clock20);


    } */
}
