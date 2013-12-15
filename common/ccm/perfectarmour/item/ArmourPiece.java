package ccm.perfectarmour.item;

import java.lang.reflect.Method;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import ccm.perfectarmour.util.helper.NBTHelper;
import ccm.perfectarmour.util.helper.json.JsonHelper;
import ccm.perfectarmour.util.helper.json.JsonNBTHelper;
import ccm.perfectarmour.utils.libs.Archive;

import com.google.gson.JsonObject;

public final class ArmourPiece
{
    private final String displayName;
    private final int durability;
    private final int maxAbsorption;
    private final double absorptionRatio;
    private final byte type;
    private final NBTTagCompound recipe;

    public ArmourPiece(String diplayName, int durability, int maxAbsorption, double absorptionRatio, int type, NBTTagCompound recipe)
    {
        displayName = diplayName;
        this.durability = durability;
        this.maxAbsorption = maxAbsorption;
        this.absorptionRatio = absorptionRatio;
        this.type = (byte) type;
        this.recipe = recipe;
        Map<?, ?> result = null;
        try
        {
            Method map = recipe.getClass().getDeclaredMethod("getTagMap", NBTTagCompound.class);
            map.setAccessible(true);
            result = (Map<?, ?>) map.invoke(recipe, recipe);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public ArmourPiece(int type, JsonObject piece)
    {
        this(JsonHelper.getString(piece, "displayName"), JsonHelper.getNumber(piece, "durability").intValue(), JsonHelper.getNumber(piece, "maxAbsorption").intValue(), JsonHelper
                .getNumber(piece, "absorptionRatio").doubleValue(), type, (NBTTagCompound) JsonNBTHelper.parseJSON(JsonHelper.getJsonObject(piece, "recipe")));
    }

    public String getDisplayName()
    {
        return displayName;
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

        piece.setString(Archive.NBT_ARMOUR_PIECE_NAME_DISPLAY, getDisplayName());
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

        String name = NBTHelper.getString(piece, Archive.NBT_ARMOUR_PIECE_NAME_DISPLAY);
        int durability = NBTHelper.getInteger(piece, Archive.NBT_ARMOUR_PIECE_DURABILITY);
        double ratio = NBTHelper.getDouble(piece, Archive.NBT_ARMOUR_PIECE_ABSORBTION_RATIO);
        int max = NBTHelper.getInteger(piece, Archive.NBT_ARMOUR_PIECE_ABSORBTION_MAX);
        NBTTagCompound recipe = NBTHelper.getTag(piece, Archive.NBT_ARMOUR_PIECE_RECIPE);

        return new ArmourPiece(name, durability, max, ratio, type, recipe);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(absorptionRatio);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        result = (prime * result) + ((displayName == null) ? 0 : displayName.hashCode());
        result = (prime * result) + durability;
        result = (prime * result) + maxAbsorption;
        result = (prime * result) + ((recipe == null) ? 0 : recipe.hashCode());
        result = (prime * result) + type;
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ArmourPiece [displayName=");
        builder.append(displayName);
        builder.append(", durability=");
        builder.append(durability);
        builder.append(", maxAbsorption=");
        builder.append(maxAbsorption);
        builder.append(", absorptionRatio=");
        builder.append(absorptionRatio);
        builder.append(", type=");
        builder.append(type);
        builder.append(", recipe=");
        builder.append(recipe);
        builder.append(", hashCode()=");
        builder.append(hashCode());
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof ArmourPiece))
        {
            return false;
        }
        ArmourPiece other = (ArmourPiece) obj;
        if (Double.doubleToLongBits(absorptionRatio) != Double.doubleToLongBits(other.absorptionRatio))
        {
            return false;
        }
        if (displayName == null)
        {
            if (other.displayName != null)
            {
                return false;
            }
        } else if (!displayName.equals(other.displayName))
        {
            return false;
        }
        if (durability != other.durability)
        {
            return false;
        }
        if (maxAbsorption != other.maxAbsorption)
        {
            return false;
        }
        if (recipe == null)
        {
            if (other.recipe != null)
            {
                return false;
            }
        } else if (!recipe.equals(other.recipe))
        {
            return false;
        }
        if (type != other.type)
        {
            return false;
        }
        return true;
    }
}