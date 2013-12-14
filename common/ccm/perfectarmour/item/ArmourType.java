package ccm.perfectarmour.item;

import ccm.perfectarmour.utils.helpers.JsonHelper;

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
        name = JsonHelper.getString(type, "name");
        textureName = JsonHelper.getString(type, "textureName");
        hasOverlay = JsonHelper.getBoolean(type, "hasOverlay");
        helmet = JsonHelper.getJsonObject(type, "helmet");
        chest = JsonHelper.getJsonObject(type, "chest");
        pants = JsonHelper.getJsonObject(type, "pants");
        boots = JsonHelper.getJsonObject(type, "boots");
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
    
    public final String getName()
    {
        return name;
    }

    public final String getTextureName()
    {
        return textureName;
    }

    public final boolean hasOverlay()
    {
        return hasOverlay;
    }
}