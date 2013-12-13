package ccm.perfectarmour.utils.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ccm.perfectarmour.item.ArmourTypes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonHelper
{
    public static final JsonParser PARSER = new JsonParser();

    public static void read(File file)
    {
        JsonArray rootArray = null;
        try
        {
            rootArray = PARSER.parse(new FileReader(file)).getAsJsonArray();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        for (JsonElement element : rootArray)
        {
            ArmourTypes.addType(element.getAsJsonObject());
        }
    }

    public static void addDefaults(File file)
    {
        try
        {
            file.createNewFile();
            // Create main array
            JsonArray rootArray = new JsonArray();
                // Leather
                JsonObject armourType = new JsonObject();
                armourType.addProperty("name", "Leather");
                    // helmet
                    JsonObject armour = new JsonObject();
                        armour.addProperty("name", "Helmet");
                        armour.addProperty("texture", "/leather.png");
                        armour.addProperty("durability", "500");
                        armour.addProperty("protection", "50");
                    armourType.add("helmet", armour);
                    // chest
                    armour = new JsonObject();
                        armour.addProperty("name", "Chest");
                        armour.addProperty("texture", "/leather.png");
                        armour.addProperty("durability", "500");
                        armour.addProperty("protection", "50");
                    armourType.add("chest", armour);
                    // pants
                    armour = new JsonObject();
                        armour.addProperty("name", "Pants");
                        armour.addProperty("texture", "/leather.png");
                        armour.addProperty("durability", "500");
                        armour.addProperty("protection", "50");
                    armourType.add("pants", armour);
                    // boots
                    armour = new JsonObject();
                        armour.addProperty("name", "Boots");
                        armour.addProperty("texture", "/leather.png");
                        armour.addProperty("durability", "500");
                        armour.addProperty("protection", "50");
                    armourType.add("boots", armour);
                rootArray.add(armourType);
                // Iron
                armourType = new JsonObject();
                armourType.addProperty("name", "Iron");
                    // helmet
                    armour = new JsonObject();
                        armour.addProperty("name", "Helmet");
                        armour.addProperty("texture", "/leather.png");
                        armour.addProperty("durability", "500");
                        armour.addProperty("protection", "50");
                    armourType.add("helmet", armour);
                    // chest
                    armour = new JsonObject();
                        armour.addProperty("name", "Chest");
                        armour.addProperty("texture", "/leather.png");
                        armour.addProperty("durability", "500");
                        armour.addProperty("protection", "50");
                    armourType.add("chest", armour);
                    // pants
                    armour = new JsonObject();
                        armour.addProperty("name", "Pants");
                        armour.addProperty("texture", "/leather.png");
                        armour.addProperty("durability", "500");
                        armour.addProperty("protection", "50");
                    armourType.add("pants", armour);
                    // boots
                    armour = new JsonObject();
                        armour.addProperty("name", "Boots");
                        armour.addProperty("texture", "/leather.png");
                        armour.addProperty("durability", "500");
                        armour.addProperty("protection", "50");
                    armourType.add("boots", armour);
                rootArray.add(armourType);
                // Gold
                armourType = new JsonObject();
                armourType.addProperty("name", "Gold");
                    // helmet
                    armour = new JsonObject();
                        
                    armourType.add("helmet", armour);
                    // chest
                    armour = new JsonObject();
                        
                    armourType.add("chest", armour);
                    // pants
                    armour = new JsonObject();
                        
                    armourType.add("pants", armour);
                    // boots
                    armour = new JsonObject();
                        
                    armourType.add("boots", armour);
                rootArray.add(armourType);
                // Diamond
                armourType = new JsonObject();
                armourType.addProperty("name", "Diamond");
                    // helmet
                    armour = new JsonObject();
                        
                    armourType.add("helmet", armour);
                    // chest
                    armour = new JsonObject();
                        
                    armourType.add("chest", armour);
                    // pants
                    armour = new JsonObject();
                        
                    armourType.add("pants", armour);
                    // boots
                    armour = new JsonObject();
                        
                    armourType.add("boots", armour);
                rootArray.add(armourType);
            // Done making Defaults, now writing them 
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            bw.write(gson.toJson(rootArray));
            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}