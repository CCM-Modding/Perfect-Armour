package ccm.perfectarmour.item;

import com.google.gson.JsonObject;

public final class ArmourType
{
    private JsonObject helmet;
    private JsonObject chest;
    private JsonObject pants;
    private JsonObject boots;

    public ArmourType(JsonObject type)
    {
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