package ccm.perfectarmor.types;

import java.lang.reflect.Method;
import java.util.Map;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import ccm.perfectarmor.util.helper.NBTHelper;
import ccm.perfectarmor.util.helper.json.JsonHelper;
import ccm.perfectarmor.util.helper.json.JsonNBTHelper;
import ccm.perfectarmor.util.helper.recipe.RecipeHelper;
import ccm.perfectarmor.util.lib.Archive;

import com.google.gson.JsonObject;

public final class ArmorPiece
{
    private ArmorType parent;
    private final String displayName;
    private final int durability;
    private final int maxAbsorption;
    private final double absorptionRatio;
    private final byte type;
    private final NBTTagCompound recipe;
    private Map<?, ?> recipeData;
    private Icon icon;
    private Icon overlay;

    public ArmorPiece(String displayName, int durability, int maxAbsorption, double absorptionRatio, int type, NBTTagCompound recipe)
    {
        this.displayName = displayName;
        this.durability = durability;
        this.maxAbsorption = maxAbsorption;
        this.absorptionRatio = absorptionRatio;
        this.type = (byte) type;
        this.recipe = recipe;
        try
        {
            Method map = recipe.getClass().getDeclaredMethod("getTagMap", NBTTagCompound.class);
            map.setAccessible(true);
            recipeData = (Map<?, ?>) map.invoke(recipe, recipe);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArmorPiece(int type, JsonObject piece)
    {
        this(JsonHelper.getString(piece, "displayName"), JsonHelper.getNumber(piece, "durability").intValue(), JsonHelper.getNumber(piece, "maxAbsorption").intValue(), JsonHelper
                .getNumber(piece, "absorptionRatio").doubleValue(), type, (NBTTagCompound) JsonNBTHelper.parseJSON(JsonHelper.getJsonObject(piece, "recipe")));
    }

    public Icon getIcon()
    {
        return icon;
    }

    public void setIcon(Icon icon)
    {
        this.icon = icon;
    }

    public Icon getOverlay()
    {
        return overlay;
    }

    public void setOverlay(Icon icon)
    {
        overlay = icon;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public byte getType()
    {
        return type;
    }

    public void setParent(ArmorType parent)
    {
        this.parent = parent;
    }

    public ArmorType getParent()
    {
        return parent;
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

    public IRecipe getIRecipe()
    {
        return RecipeHelper.getRecipe(this, recipeData);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        String s = (Archive.NBT_ARMOR_PIECE + "_" + getType());
        NBTTagCompound piece = new NBTTagCompound(s);

        piece.setString(Archive.NBT_ARMOR_PIECE_NAME_DISPLAY, getDisplayName());
        piece.setInteger(Archive.NBT_ARMOR_PIECE_DURABILITY, getDurability());
        piece.setDouble(Archive.NBT_ARMOR_PIECE_ABSORBTION_RATIO, absorptionRatio());
        piece.setInteger(Archive.NBT_ARMOR_PIECE_ABSORBTION_MAX, maxAbsorption());
        piece.setCompoundTag(Archive.NBT_ARMOR_PIECE_RECIPE, getNBTRecipe());

        nbt.setCompoundTag(s, piece);
        return nbt;
    }

    public static ArmorPiece loadFromNBT(int type, NBTTagCompound nbt)
    {
        String s = (Archive.NBT_ARMOR_PIECE + "_" + type);
        NBTTagCompound piece = NBTHelper.getTag(nbt, s);

        String name = NBTHelper.getString(piece, Archive.NBT_ARMOR_PIECE_NAME_DISPLAY);
        int durability = NBTHelper.getInteger(piece, Archive.NBT_ARMOR_PIECE_DURABILITY);
        double ratio = NBTHelper.getDouble(piece, Archive.NBT_ARMOR_PIECE_ABSORBTION_RATIO);
        int max = NBTHelper.getInteger(piece, Archive.NBT_ARMOR_PIECE_ABSORBTION_MAX);
        NBTTagCompound recipe = NBTHelper.getTag(piece, Archive.NBT_ARMOR_PIECE_RECIPE);

        return new ArmorPiece(name, durability, max, ratio, type, recipe);
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
        if (!(obj instanceof ArmorPiece))
        {
            return false;
        }
        ArmorPiece other = (ArmorPiece) obj;
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