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

            JsonArray rootArray = new JsonArray();
            JsonObject armourType = new JsonObject();
            JsonObject armour = new JsonObject();
            
            
            armourType.add("helmet", armour);
            
            armour = new JsonObject();
            armourType.add("chest", armour);
            
            armour = new JsonObject();
            armourType.add("pants", armour);
            
            armour = new JsonObject();
            armourType.add("boots", armour);
            rootArray.add(armourType);

            armourType = new JsonObject();
            
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