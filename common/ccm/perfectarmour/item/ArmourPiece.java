package ccm.perfectarmour.item;

import net.minecraft.nbt.NBTTagCompound;
import ccm.perfectarmour.utils.helpers.JsonHelper;

import com.google.gson.JsonObject;

public final class ArmourPiece
{
    private final String name;
    private final int durability;
    private final int maxAbsorption;
    private final double absorptionRatio;
    private final int type;
    private final JsonObject recipe;

    public ArmourPiece(int type, JsonObject piece)
    {
        this.type = type;
        name = JsonHelper.getString(piece, "name");
        durability = JsonHelper.getNumber(piece, "durability").intValue();
        maxAbsorption = JsonHelper.getNumber(piece, "maxAbsorption").intValue();
        absorptionRatio = JsonHelper.getNumber(piece, "absorptionRatio").doubleValue();
        recipe = JsonHelper.getJsonObject(piece, "recipe");
    }

    public String getName()
    {
        return name;
    }

    public int getType()
    {
        return type;
    }

    public int getDurability()
    {
        return durability;
    }

    public double absorptionRatio()
    {
        return absorptionRatio;
    }

    public int maxAbsorption()
    {
        return maxAbsorption;
    }

    public JsonObject getJsonRecipe()
    {
        return recipe;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        return nbt;
    }

    public static ArmourPiece loadFromNBT(NBTTagCompound nbt)
    {
        return null;
    }
}