package ccm.perfectarmour.item;

import ccm.perfectarmour.utils.helpers.JsonHelper;

import com.google.gson.JsonObject;

public final class ArmourType
{
    private String name;
    private String textureName;
    private boolean hasOverlay;
    private ArmourPiece helmet;
    private ArmourPiece chest;
    private ArmourPiece pants;
    private ArmourPiece boots;

    public ArmourType(JsonObject type)
    {
        name = JsonHelper.getString(type, "name");
        textureName = JsonHelper.getString(type, "textureName");
        hasOverlay = JsonHelper.getBoolean(type, "hasOverlay");
        helmet = new ArmourPiece(JsonHelper.getJsonObject(type, "helmet"));
        chest = new ArmourPiece(JsonHelper.getJsonObject(type, "chest"));
        pants = new ArmourPiece(JsonHelper.getJsonObject(type, "pants"));
        boots = new ArmourPiece(JsonHelper.getJsonObject(type, "boots"));
    }

    public final ArmourPiece getHelmet()
    {
        return helmet;
    }

    public final ArmourPiece getChest()
    {
        return chest;
    }

    public final ArmourPiece getPants()
    {
        return pants;
    }

    public final ArmourPiece getBoots()
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