package ccm.perfectarmour.item;

import com.google.gson.JsonObject;

public final class ArmourType
{
    private String name;
    private String textureName;
    private boolean hasOverlay;
    private JsonObject helmet;
    private JsonObject chest;
    private JsonObject pants;
    private JsonObject boots;

    public ArmourType(JsonObject type)
    {
        name = type.get("name").getAsString();
        textureName = type.get("textureName").getAsString();
        hasOverlay = type.get("hasOverlay").getAsBoolean();
        helmet = type.get("helmet").getAsJsonObject();
        chest = type.get("chest").getAsJsonObject();
        pants = type.get("pants").getAsJsonObject();
        boots = type.get("boots").getAsJsonObject();
    }

    public final JsonObject getHelmet()
    {
        return helmet;
    }

    public final JsonObject getChest()
    {
        return chest;
    }

    public final JsonObject getPants()
    {
        return pants;
    }

    public final JsonObject getBoots()
    {
        return boots;
    }
}