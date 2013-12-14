package ccm.perfectarmour.item;

import ccm.perfectarmour.utils.helpers.JsonHelper;

import com.google.gson.JsonObject;

public final class ArmourType
{
    private final String name;
    private final String textureName;
    private final boolean hasOverlay;
    private final ArmourPiece helmet;
    private final ArmourPiece chest;
    private final ArmourPiece pants;
    private final ArmourPiece boots;

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

    public final ArmourPiece getHelmet()
    {// 0
        return helmet;
    }

    public final ArmourPiece getChest()
    {// 1
        return chest;
    }

    public final ArmourPiece getPants()
    {// 2
        return pants;
    }

    public final ArmourPiece getBoots()
    {// 3
        return boots;
    }
}