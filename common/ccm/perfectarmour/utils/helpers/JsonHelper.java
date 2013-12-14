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

    public static String getString(JsonObject element, String name)
    {
        return element.get("textureName").getAsString();
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
            armourType.addProperty("textureName", "leather");
            armourType.addProperty("hasOverlay", true);
            // helmet
            JsonObject armour = new JsonObject();
            armour.addProperty("name", "Helmet");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            JsonObject recipe = new JsonObject();
            recipe.addProperty("top", "xxx");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "   ");
            recipe.addProperty("x", 334);
            armour.add("recipe", recipe);
            armourType.add("helmet", armour);
            // chest
            armour = new JsonObject();
            armour.addProperty("name", "Chest");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "x x");
            recipe.addProperty("middile", "xxx");
            recipe.addProperty("bottom", "xxx");
            recipe.addProperty("x", 334);
            armour.add("recipe", recipe);
            armourType.add("chest", armour);
            // pants
            armour = new JsonObject();
            armour.addProperty("name", "Pants");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "xxx");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "x x");
            recipe.addProperty("x", 334);
            armour.add("recipe", recipe);
            armourType.add("pants", armour);
            // boots
            armour = new JsonObject();
            armour.addProperty("name", "Boots");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "   ");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "x x");
            recipe.addProperty("x", 334);
            armour.add("recipe", recipe);
            armourType.add("boots", armour);
            rootArray.add(armourType);
            // Iron
            armourType = new JsonObject();
            armourType.addProperty("name", "Iron");
            armourType.addProperty("textureName", "iron");
            // helmet
            armour = new JsonObject();
            armour.addProperty("name", "Helmet");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "xxx");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "   ");
            recipe.addProperty("x", 265);
            armour.add("recipe", recipe);
            armourType.add("helmet", armour);
            // chest
            armour = new JsonObject();
            armour.addProperty("name", "Chest");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "x x");
            recipe.addProperty("middile", "xxx");
            recipe.addProperty("bottom", "xxx");
            recipe.addProperty("x", 265);
            armour.add("recipe", recipe);
            armourType.add("chest", armour);
            // pants
            armour = new JsonObject();
            armour.addProperty("name", "Pants");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "xxx");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "x x");
            recipe.addProperty("x", 265);
            armour.add("recipe", recipe);
            armourType.add("pants", armour);
            // boots
            armour = new JsonObject();
            armour.addProperty("name", "Boots");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "   ");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "x x");
            recipe.addProperty("x", 265);
            armour.add("recipe", recipe);
            armourType.add("boots", armour);
            rootArray.add(armourType);
            // Gold
            armourType = new JsonObject();
            armourType.addProperty("name", "Gold");
            armourType.addProperty("textureName", "gold");
            // helmet
            armour = new JsonObject();
            armour.addProperty("name", "Helmet");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "xxx");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "   ");
            recipe.addProperty("x", 266);
            armour.add("recipe", recipe);
            armourType.add("helmet", armour);
            // chest
            armour = new JsonObject();
            armour.addProperty("name", "Chest");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "x x");
            recipe.addProperty("middile", "xxx");
            recipe.addProperty("bottom", "xxx");
            recipe.addProperty("x", 266);
            armour.add("recipe", recipe);
            armourType.add("chest", armour);
            // pants
            armour = new JsonObject();
            armour.addProperty("name", "Pants");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "xxx");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "x x");
            recipe.addProperty("x", 266);
            armour.add("recipe", recipe);
            armourType.add("pants", armour);
            // boots
            armour = new JsonObject();
            armour.addProperty("name", "Boots");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "   ");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "x x");
            recipe.addProperty("x", 266);
            armour.add("recipe", recipe);
            armourType.add("boots", armour);
            rootArray.add(armourType);
            // Diamond
            armourType = new JsonObject();
            armourType.addProperty("name", "Diamond");
            armourType.addProperty("textureName", "diamond");
            // helmet
            armour = new JsonObject();
            armour.addProperty("name", "Helmet");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "xxx");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "   ");
            recipe.addProperty("x", 264);
            armour.add("recipe", recipe);
            armourType.add("helmet", armour);
            // chest
            armour = new JsonObject();
            armour.addProperty("name", "Chest");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "x x");
            recipe.addProperty("middile", "xxx");
            recipe.addProperty("bottom", "xxx");
            recipe.addProperty("x", 264);
            armour.add("recipe", recipe);
            armourType.add("chest", armour);
            // pants
            armour = new JsonObject();
            armour.addProperty("name", "Pants");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "xxx");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "x x");
            recipe.addProperty("x", 264);
            armour.add("recipe", recipe);
            armourType.add("pants", armour);
            // boots
            armour = new JsonObject();
            armour.addProperty("name", "Boots");
            armour.addProperty("durability", 500);
            armour.addProperty("protection", 50);
            recipe = new JsonObject();
            recipe.addProperty("top", "   ");
            recipe.addProperty("middile", "x x");
            recipe.addProperty("bottom", "x x");
            recipe.addProperty("x", 264);
            armour.add("recipe", recipe);
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