package ccm.perfectarmour.item;

import net.minecraft.nbt.NBTTagCompound;
import ccm.perfectarmour.utils.helpers.json.JsonHelper;
import ccm.perfectarmour.utils.helpers.json.JsonNBTHelper;
import ccm.perfectarmour.utils.libs.Archive;

import com.google.gson.JsonObject;

public final class ArmourPiece
{
    private final String name;
    private final int durability;
    private final int maxAbsorption;
    private final double absorptionRatio;
    private final byte type;
    private final JsonObject recipe;

    public ArmourPiece(int type, JsonObject piece)
    {
        this.type = (byte) type;
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

    public byte getType()
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
        nbt.setString(Archive.NBT_ARMOUR_PIECE_NAME, getName());
        nbt.setByte(Archive.NBT_ARMOUR_PIECE_TYPE, getType());
        nbt.setInteger(Archive.NBT_ARMOUR_PIECE_DURABILITY, getDurability());
        nbt.setDouble(Archive.NBT_ARMOUR_PIECE_ABSORBTION_RATIO, absorptionRatio());
        nbt.setInteger(Archive.NBT_ARMOUR_PIECE_ABSORBTION_MAX, maxAbsorption());
        nbt.setTag(Archive.NBT_ARMOUR_PIECE_RECIPE, JsonNBTHelper.parseJSON(getJsonRecipe()));
        return nbt;
    }

    public static ArmourPiece loadFromNBT(NBTTagCompound nbt)
    {
        return null;
    }
}