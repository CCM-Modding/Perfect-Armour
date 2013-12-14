package ccm.perfectarmour.item;

import net.minecraft.nbt.NBTTagCompound;
import ccm.perfectarmour.utils.helpers.NBTHelper;
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
    private final NBTTagCompound recipe;

    public ArmourPiece(String name, int durability, int maxAbsorption, double absorptionRatio, int type, NBTTagCompound recipe)
    {
        this.name = name;
        this.durability = durability;
        this.maxAbsorption = maxAbsorption;
        this.absorptionRatio = absorptionRatio;
        this.type = (byte) type;
        this.recipe = recipe;
    }

    public ArmourPiece(int type, JsonObject piece)
    {
        this(JsonHelper.getString(piece, "name"), JsonHelper.getNumber(piece, "durability").intValue(), JsonHelper.getNumber(piece, "maxAbsorption").intValue(), JsonHelper
                .getNumber(piece, "absorptionRatio").doubleValue(), type, (NBTTagCompound) JsonNBTHelper.parseJSON(JsonHelper.getJsonObject(piece, "recipe")));
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

    public NBTTagCompound getNBTRecipe()
    {
        return recipe;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        String s = (Archive.NBT_ARMOUR_PIECE + "_" + getType());
        NBTTagCompound piece = new NBTTagCompound(s);

        piece.setString(Archive.NBT_ARMOUR_PIECE_NAME, getName());
        piece.setInteger(Archive.NBT_ARMOUR_PIECE_DURABILITY, getDurability());
        piece.setDouble(Archive.NBT_ARMOUR_PIECE_ABSORBTION_RATIO, absorptionRatio());
        piece.setInteger(Archive.NBT_ARMOUR_PIECE_ABSORBTION_MAX, maxAbsorption());
        piece.setCompoundTag(Archive.NBT_ARMOUR_PIECE_RECIPE, getNBTRecipe());

        nbt.setCompoundTag(s, piece);
        return nbt;
    }

    public static ArmourPiece loadFromNBT(int type, NBTTagCompound nbt)
    {
        String s = (Archive.NBT_ARMOUR_PIECE + "_" + type);
        NBTTagCompound piece = NBTHelper.getTag(nbt, s);

        String name = NBTHelper.getString(piece, Archive.NBT_ARMOUR_PIECE_NAME);
        int durability = NBTHelper.getInteger(piece, Archive.NBT_ARMOUR_PIECE_DURABILITY);
        double ratio = NBTHelper.getDouble(piece, Archive.NBT_ARMOUR_PIECE_ABSORBTION_RATIO);
        int max = NBTHelper.getInteger(piece, Archive.NBT_ARMOUR_PIECE_ABSORBTION_MAX);
        NBTTagCompound recipe = NBTHelper.getTag(piece, Archive.NBT_ARMOUR_PIECE_RECIPE);

        return new ArmourPiece(name, durability, max, ratio, type, recipe);
    }
}