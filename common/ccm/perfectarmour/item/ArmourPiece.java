package ccm.perfectarmour.item;

import ccm.perfectarmour.utils.helpers.JsonHelper;

import com.google.gson.JsonObject;

public final class ArmourPiece
{
    private final String name;
    private final int durability;
    private final int maxAbsorption;
    private final double absorptionRatio;
    private final JsonObject recipe;

    public ArmourPiece(JsonObject piece)
    {
        name = JsonHelper.getString(piece, "name");
        durability = JsonHelper.getNumber(piece, "durability").intValue();
        maxAbsorption = JsonHelper.getNumber(piece, "maxAbsorption").intValue();
        absorptionRatio = JsonHelper.getNumber(piece, "absorptionRatio").doubleValue();
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

    public final double absorptionRatio()
    {
        return absorptionRatio;
    }

    public final int maxAbsorption()
    {
        return maxAbsorption;
    }

    public final JsonObject getJsonRecipe()
    {
        return recipe;
    }
}