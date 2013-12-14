package ccm.perfectarmour.utils.helpers.json;

import java.io.File;
import java.io.FileReader;

import ccm.perfectarmour.item.ArmourTypes;

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

    public static String getString(JsonObject element, String name)
    {
        if (element.get(name) != null)
        {
            return element.get(name).getAsString();
        }
        return null;
    }

    public static boolean getBoolean(JsonObject element, String name)
    {
        if (element.get(name) != null)
        {
            return element.get(name).getAsBoolean();
        }
        return false;
    }

    public static JsonObject getJsonObject(JsonObject element, String name)
    {
        if (element.get(name) != null)
        {
            return element.get(name).getAsJsonObject();
        }
        return null;
    }

    public static Number getNumber(JsonObject element, String name)
    {
        if (element.get(name) != null)
        {
            return element.get(name).getAsNumber();
        }
        return 0;
    }
}