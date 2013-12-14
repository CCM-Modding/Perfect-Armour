package ccm.perfectarmour.item;

import net.minecraft.item.crafting.IRecipe;
import ccm.perfectarmour.utils.helpers.JsonHelper;

import com.google.gson.JsonObject;

public final class ArmourPiece
{
    private String name;
    private int durability;
    private int protection;
    private IRecipe recipe;

    public ArmourPiece(JsonObject piece)
    {
        name = JsonHelper.getString(piece, "name");
        durability = (Integer) JsonHelper.getNumber(piece, "name");
        protection = (Integer) JsonHelper.getNumber(piece, "name");
        recipe = JsonHelper.getIRecipe(piece, "recipe");
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

    public final IRecipe getRecipe()
    {
        return recipe;
    }
}