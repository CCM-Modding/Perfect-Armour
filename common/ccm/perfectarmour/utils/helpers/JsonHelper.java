package ccm.perfectarmour.utils.helpers;

import java.io.File;
import java.io.FileReader;

import ccm.perfectarmour.item.ArmourTypes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
}