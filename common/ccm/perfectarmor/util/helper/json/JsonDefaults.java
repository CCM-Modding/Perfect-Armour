package ccm.perfectarmor.util.helper.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class JsonDefaults
{
    public static void loadJson(final FMLPreInitializationEvent event)
    {
        File configFolder = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/CCM-Modding/");
        configFolder.mkdirs();
        File armours = new File(configFolder.getAbsolutePath() + "/Armours.cfg");
        if (!armours.exists())
        {
            JsonDefaults.addDefaults(armours);
        }
        JsonHelper.read(armours);
    }

    public static void addDefaults(File file)
    {
        try
        {
            file.createNewFile();
            // Create main array
            JsonArray rootArray = new JsonArray();

            addLeather(rootArray);
            addIron(rootArray);
            addGold(rootArray);
            addDiamond(rootArray);
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

    private static void addLeather(JsonArray rootArray)
    {
        JsonObject armourType = new JsonObject();
        armourType.addProperty("id", "0");
        armourType.addProperty("textureName", "leather");
        armourType.addProperty("displayName", "Leather");
        armourType.addProperty("hasOverlay", true);
        // helmet
        JsonObject armour = new JsonObject();
        armour.addProperty("displayName", "Helmet");
        armour.addProperty("durability", 56);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.04);
        JsonObject recipe = new JsonObject();
        recipe.addProperty("top", "xxx");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "   ");
        recipe.addProperty("x", "334");
        armour.add("recipe", recipe);
        armourType.add("helmet", armour);
        // chest
        armour = new JsonObject();
        armour.addProperty("displayName", "Chest");
        armour.addProperty("durability", 81);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.12);
        recipe = new JsonObject();
        recipe.addProperty("top", "x x");
        recipe.addProperty("middle", "xxx");
        recipe.addProperty("bottom", "xxx");
        recipe.addProperty("x", "334");
        armour.add("recipe", recipe);
        armourType.add("chest", armour);
        // pants
        armour = new JsonObject();
        armour.addProperty("displayName", "Pants");
        armour.addProperty("durability", 76);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.08);
        recipe = new JsonObject();
        recipe.addProperty("top", "xxx");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "x x");
        recipe.addProperty("x", "334");
        armour.add("recipe", recipe);
        armourType.add("pants", armour);
        // boots
        armour = new JsonObject();
        armour.addProperty("displayName", "Boots");
        armour.addProperty("durability", 66);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.04);
        recipe = new JsonObject();
        recipe.addProperty("top", "   ");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "x x");
        recipe.addProperty("x", "334");
        armour.add("recipe", recipe);
        armourType.add("boots", armour);
        rootArray.add(armourType);
    }

    private static void addIron(JsonArray rootArray)
    {
        JsonObject armourType = new JsonObject();
        armourType.addProperty("id", "1");
        armourType.addProperty("textureName", "iron");
        armourType.addProperty("displayName", "Iron");
        // helmet
        JsonObject armour = new JsonObject();
        armour.addProperty("displayName", "Helmet");
        armour.addProperty("durability", 166);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.08);
        JsonObject recipe = new JsonObject();
        recipe.addProperty("top", "xxx");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "   ");
        recipe.addProperty("x", "265");
        armour.add("recipe", recipe);
        armourType.add("helmet", armour);
        // chest
        armour = new JsonObject();
        armour.addProperty("displayName", "Chest");
        armour.addProperty("durability", 241);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.24);
        recipe = new JsonObject();
        recipe.addProperty("top", "x x");
        recipe.addProperty("middle", "xxx");
        recipe.addProperty("bottom", "xxx");
        recipe.addProperty("x", "265");
        armour.add("recipe", recipe);
        armourType.add("chest", armour);
        // pants
        armour = new JsonObject();
        armour.addProperty("displayName", "Pants");
        armour.addProperty("durability", 226);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.20);
        recipe = new JsonObject();
        recipe.addProperty("top", "xxx");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "x x");
        recipe.addProperty("x", "265");
        armour.add("recipe", recipe);
        armourType.add("pants", armour);
        // boots
        armour = new JsonObject();
        armour.addProperty("displayName", "Boots");
        armour.addProperty("durability", 196);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.08);
        recipe = new JsonObject();
        recipe.addProperty("top", "   ");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "x x");
        recipe.addProperty("x", "265");
        armour.add("recipe", recipe);
        armourType.add("boots", armour);
        rootArray.add(armourType);
    }

    private static void addGold(JsonArray rootArray)
    {
        JsonObject armourType = new JsonObject();
        armourType.addProperty("id", "2");
        armourType.addProperty("textureName", "gold");
        armourType.addProperty("displayName", "Gold");
        // helmet
        JsonObject armour = new JsonObject();
        armour.addProperty("displayName", "Helmet");
        armour.addProperty("durability", 78);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.08);
        JsonObject recipe = new JsonObject();
        recipe.addProperty("top", "xxx");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "   ");
        recipe.addProperty("x", "266");
        armour.add("recipe", recipe);
        armourType.add("helmet", armour);
        // chest
        armour = new JsonObject();
        armour.addProperty("displayName", "Chest");
        armour.addProperty("durability", 113);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.20);
        recipe = new JsonObject();
        recipe.addProperty("top", "x x");
        recipe.addProperty("middle", "xxx");
        recipe.addProperty("bottom", "xxx");
        recipe.addProperty("x", "266");
        armour.add("recipe", recipe);
        armourType.add("chest", armour);
        // pants
        armour = new JsonObject();
        armour.addProperty("displayName", "Pants");
        armour.addProperty("durability", 106);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.12);
        recipe = new JsonObject();
        recipe.addProperty("top", "xxx");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "x x");
        recipe.addProperty("x", "266");
        armour.add("recipe", recipe);
        armourType.add("pants", armour);
        // boots
        armour = new JsonObject();
        armour.addProperty("displayName", "Boots");
        armour.addProperty("durability", 92);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.04);
        recipe = new JsonObject();
        recipe.addProperty("top", "   ");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "x x");
        recipe.addProperty("x", "266");
        armour.add("recipe", recipe);
        armourType.add("boots", armour);
        rootArray.add(armourType);
    }

    private static void addDiamond(JsonArray rootArray)
    {
        JsonObject armourType = new JsonObject();
        armourType.addProperty("id", "3");
        armourType.addProperty("textureName", "diamond");
        armourType.addProperty("displayName", "Diamond");
        // helmet
        JsonObject armour = new JsonObject();
        armour.addProperty("displayName", "Helmet");
        armour.addProperty("durability", 364);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.12);
        JsonObject recipe = new JsonObject();
        recipe.addProperty("top", "xxx");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "   ");
        recipe.addProperty("x", "264");
        armour.add("recipe", recipe);
        armourType.add("helmet", armour);
        // chest
        armour = new JsonObject();
        armour.addProperty("displayName", "Chest");
        armour.addProperty("durability", 529);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.32);
        recipe = new JsonObject();
        recipe.addProperty("top", "x x");
        recipe.addProperty("middle", "xxx");
        recipe.addProperty("bottom", "xxx");
        recipe.addProperty("x", "264");
        armour.add("recipe", recipe);
        armourType.add("chest", armour);
        // pants
        armour = new JsonObject();
        armour.addProperty("displayName", "Pants");
        armour.addProperty("durability", 496);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.24);
        recipe = new JsonObject();
        recipe.addProperty("top", "xxx");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "x x");
        recipe.addProperty("x", "264");
        armour.add("recipe", recipe);
        armourType.add("pants", armour);
        // boots
        armour = new JsonObject();
        armour.addProperty("displayName", "Boots");
        armour.addProperty("durability", 430);
        armour.addProperty("maxAbsorption", 500000);
        armour.addProperty("absorptionRatio", 0.12);
        recipe = new JsonObject();
        recipe.addProperty("top", "   ");
        recipe.addProperty("middle", "x x");
        recipe.addProperty("bottom", "x x");
        recipe.addProperty("x", "264");
        armour.add("recipe", recipe);
        armourType.add("boots", armour);
        rootArray.add(armourType);
    }
}
