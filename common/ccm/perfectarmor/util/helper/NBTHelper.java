package ccm.perfectarmor.util.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class NBTHelper
{
    public static void initCompound(final ItemStack item)
    {
        if (item.getTagCompound() == null)
        {
            item.setTagCompound(new NBTTagCompound());
        }
    }

    public static boolean hasTag(final ItemStack item, final String keyName)
    {
        initCompound(item);

        return item.getTagCompound().hasKey(keyName);
    }

    public static NBTTagCompound getTag(final ItemStack item, final String keyName)
    {
        if (!hasTag(item, keyName))
        {
            item.getTagCompound().setCompoundTag(keyName, new NBTTagCompound());
        }
        return item.getTagCompound().getCompoundTag(keyName);
    }

    public static void removeTag(final ItemStack item, final String keyName)
    {
        if (hasTag(item, keyName))
        {
            item.getTagCompound().removeTag(keyName);
        }
    }

    // String
    public static String getString(final ItemStack item, final String keyName)
    {
        if (!hasTag(item, keyName))
        {
            setString(item, keyName, "");
        }
        return item.getTagCompound().getString(keyName);
    }

    public static void setString(final ItemStack item, final String keyName, final String keyValue)
    {
        initCompound(item);

        item.getTagCompound().setString(keyName, keyValue);
    }

    // boolean
    public static boolean getBoolean(final ItemStack item, final String keyName)
    {
        if (!hasTag(item, keyName))
        {
            setBoolean(item, keyName, false);
        }
        return item.getTagCompound().getBoolean(keyName);
    }

    public static void setBoolean(final ItemStack item, final String keyName, final boolean keyValue)
    {
        initCompound(item);

        item.getTagCompound().setBoolean(keyName, keyValue);
    }

    // byte
    public static byte getByte(final ItemStack item, final String keyName)
    {
        if (!hasTag(item, keyName))
        {
            setByte(item, keyName, (byte) 0);
        }
        return item.getTagCompound().getByte(keyName);
    }

    public static void setByte(final ItemStack item, final String keyName, final byte keyValue)
    {
        initCompound(item);

        item.getTagCompound().setByte(keyName, keyValue);
    }

    // int
    public static int getInteger(final ItemStack item, final String keyName)
    {
        if (!hasTag(item, keyName))
        {
            setInteger(item, keyName, 0);
        }
        return item.getTagCompound().getInteger(keyName);
    }

    public static void setInteger(final ItemStack item, final String keyName, final int keyValue)
    {
        initCompound(item);

        item.getTagCompound().setInteger(keyName, keyValue);
    }

    // double
    public static double getDouble(final ItemStack item, final String keyName)
    {
        if (!hasTag(item, keyName))
        {
            setDouble(item, keyName, 0);
        }
        return item.getTagCompound().getDouble(keyName);
    }

    public static void setDouble(final ItemStack item, final String keyName, final double keyValue)
    {
        initCompound(item);

        item.getTagCompound().setDouble(keyName, keyValue);
    }

    // NON ITEM BASED NBT

    // String
    public static String getString(final NBTTagCompound nbt, final String keyName)
    {
        if (!nbt.hasKey(keyName))
        {
            nbt.setString(keyName, "");
        }
        return nbt.getString(keyName);
    }

    // boolean
    public static boolean getBoolean(final NBTTagCompound nbt, final String keyName)
    {
        if (!nbt.hasKey(keyName))
        {
            nbt.setBoolean(keyName, false);
        }
        return nbt.getBoolean(keyName);
    }

    // byte
    public static byte getByte(final NBTTagCompound nbt, final String keyName)
    {
        if (!nbt.hasKey(keyName))
        {
            nbt.setByte(keyName, (byte) 0);
        }
        return nbt.getByte(keyName);
    }

    // int
    public static int getInteger(final NBTTagCompound nbt, final String keyName)
    {
        if (!nbt.hasKey(keyName))
        {
            nbt.setInteger(keyName, 0);
        }
        return nbt.getInteger(keyName);
    }

    // double
    public static double getDouble(final NBTTagCompound nbt, final String keyName)
    {
        if (!nbt.hasKey(keyName))
        {
            nbt.setDouble(keyName, 0);
        }
        return nbt.getDouble(keyName);
    }

    // Tag
    public static NBTTagCompound getTag(final NBTTagCompound nbt, final String keyName)
    {
        if (!nbt.hasKey(keyName))
        {
            nbt.setCompoundTag(keyName, new NBTTagCompound());
        }
        return nbt.getCompoundTag(keyName);
    }
}