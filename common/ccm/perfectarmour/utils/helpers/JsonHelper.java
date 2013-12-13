package ccm.perfectarmour.utils.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

import ccm.perfectarmour.item.ArmourTypes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

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

    public static File addDefaults(File file)
    {
        try
        {
            JsonWriter writer = new JsonWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8")));
            writer.beginArray();
            
            writer.beginObject();
            
            writer.endObject();
            
            writer.beginObject();
            
            writer.endObject();
            
            writer.endArray();
            writer.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return file;
    }
}