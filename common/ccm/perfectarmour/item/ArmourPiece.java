package ccm.perfectarmour.item;

import ccm.perfectarmour.utils.helpers.JsonHelper;

import com.google.gson.JsonObject;

public final class ArmourPiece
{
    private final String name;
    private final int durability;
    private final int protection;
    private final JsonObject recipe;

    public ArmourPiece(JsonObject piece)
    {
        name = JsonHelper.getString(piece, "name");
        durability = (Integer) JsonHelper.getNumber(piece, "name");
        protection = (Integer) JsonHelper.getNumber(piece, "name");
        recipe = JsonHelper.getJsonObject(piece, "recipe");
    }

    public final String getName()
    {
        return name;
    }

    public final int getDurability()
    {
        return durability;
    }

    public final int getProtection()
    {
        return protection;
    }

    public final JsonObject getJsonRecipe()
    {
        return recipe;
    }
}