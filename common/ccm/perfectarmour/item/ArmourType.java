package ccm.perfectarmour.item;

import net.minecraft.nbt.NBTTagCompound;
import ccm.perfectarmour.util.helper.NBTHelper;
import ccm.perfectarmour.util.helper.json.JsonHelper;
import ccm.perfectarmour.utils.libs.Archive;

import com.google.gson.JsonObject;

public final class ArmourType
{
    private final int id;
    private final String name;
    private final String displayName;
    private final boolean hasOverlay;
    private final ArmourPiece helmet;
    private final ArmourPiece chest;
    private final ArmourPiece pants;
    private final ArmourPiece boots;

    public ArmourType(int id,String name, String displayName, boolean hasOverlay, ArmourPiece helmet, ArmourPiece chest, ArmourPiece pants, ArmourPiece boots)
    {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.hasOverlay = hasOverlay;
        this.helmet = helmet;
        this.chest = chest;
        this.pants = pants;
        this.boots = boots;
    }

    public ArmourType(JsonObject type, ArmourPiece helmet, ArmourPiece chest, ArmourPiece pants, ArmourPiece boots)
    {
        this(JsonHelper.getNumber(type, "id").intValue(),JsonHelper.getString(type, "name"), JsonHelper.getString(type, "displayName"), JsonHelper.getBoolean(type, "hasOverlay"), helmet, chest, pants, boots);
    }

    public ArmourType(JsonObject type)
    {
        this(type, new ArmourPiece(0, JsonHelper.getJsonObject(type, "helmet")), new ArmourPiece(1, JsonHelper.getJsonObject(type, "chest")), new ArmourPiece(2,
                JsonHelper.getJsonObject(type, "pants")), new ArmourPiece(3, JsonHelper.getJsonObject(type, "boots")));
    }

    public int getID()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public boolean hasOverlay()
    {
        return hasOverlay;
    }

    public ArmourPiece getPiece(int type)
    {
        switch (type)
        {
            case 0:
                return getHelmet();
            case 1:
                return getChest();
            case 2:
                return getPants();
            case 3:
                return getBoots();
        }
        return null;
    }

    public ArmourPiece getHelmet()
    {// 0
        return helmet;
    }

    public ArmourPiece getChest()
    {// 1
        return chest;
    }

    public ArmourPiece getPants()
    {// 2
        return pants;
    }

    public ArmourPiece getBoots()
    {// 3
        return boots;
    }

    public NBTTagCompound writeToNBT(int type, NBTTagCompound nbt)
    {
        nbt.setString(Archive.NBT_ARMOUR_TYPE_NAME, getName());
        nbt.setString(Archive.NBT_ARMOUR_TYPE_NAME_DISPLAY, getDisplayName());
        nbt.setBoolean(Archive.NBT_ARMOUR_TYPE_HAS_OVERLAY, hasOverlay());
        getPiece(type).writeToNBT(nbt);
        return nbt;
    }

    public static ArmourType loadFromNBT(NBTTagCompound nbt)
    {
        String name = NBTHelper.getString(nbt, Archive.NBT_ARMOUR_TYPE_NAME);
        String texture = NBTHelper.getString(nbt, Archive.NBT_ARMOUR_TYPE_NAME_DISPLAY);
        boolean hasOverlay = NBTHelper.getBoolean(nbt, Archive.NBT_ARMOUR_TYPE_HAS_OVERLAY);
        ArmourPiece helmet = ArmourPiece.loadFromNBT(0, nbt);
        ArmourPiece chest = ArmourPiece.loadFromNBT(1, nbt);
        ArmourPiece pants = ArmourPiece.loadFromNBT(2, nbt);
        ArmourPiece boots = ArmourPiece.loadFromNBT(3, nbt);
        return new ArmourType(name, texture, hasOverlay, helmet, chest, pants, boots);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((boots == null) ? 0 : boots.hashCode());
        result = (prime * result) + ((chest == null) ? 0 : chest.hashCode());
        result = (prime * result) + ((displayName == null) ? 0 : displayName.hashCode());
        result = (prime * result) + (hasOverlay ? 1231 : 1237);
        result = (prime * result) + ((helmet == null) ? 0 : helmet.hashCode());
        result = (prime * result) + ((name == null) ? 0 : name.hashCode());
        result = (prime * result) + ((pants == null) ? 0 : pants.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ArmourType [name=").append(name).append(", displayName=").append(displayName).append(", hasOverlay=").append(hasOverlay);

        builder.append(", helmet=").append(getHelmet() != null ? getHelmet().toString() : "null");
        builder.append(", chest=").append(getChest() != null ? getChest().toString() : "null");
        builder.append(", pants=").append(getPants() != null ? getPants().toString() : "null");
        builder.append(", boots=").append(getBoots() != null ? getBoots().toString() : "null");

        builder.append(", hashCode()=").append(hashCode()).append("]");
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
        if (!(obj instanceof ArmourType))
        {
            return false;
        }
        ArmourType other = (ArmourType) obj;
        if (boots == null)
        {
            if (other.boots != null)
            {
                return false;
            }
        } else if (!boots.equals(other.boots))
        {
            return false;
        }
        if (chest == null)
        {
            if (other.chest != null)
            {
                return false;
            }
        } else if (!chest.equals(other.chest))
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
        if (hasOverlay != other.hasOverlay)
        {
            return false;
        }
        if (helmet == null)
        {
            if (other.helmet != null)
            {
                return false;
            }
        } else if (!helmet.equals(other.helmet))
        {
            return false;
        }
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        } else if (!name.equals(other.name))
        {
            return false;
        }
        if (pants == null)
        {
            if (other.pants != null)
            {
                return false;
            }
        } else if (!pants.equals(other.pants))
        {
            return false;
        }
        return true;
    }
}