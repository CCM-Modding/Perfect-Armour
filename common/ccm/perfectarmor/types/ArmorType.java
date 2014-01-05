package ccm.perfectarmor.types;

import net.minecraft.nbt.NBTTagCompound;
import ccm.perfectarmor.util.helper.NBTHelper;
import ccm.perfectarmor.util.helper.json.JsonHelper;
import ccm.perfectarmor.util.lib.Archive;

import com.google.gson.JsonObject;

public final class ArmorType
{
    private final int id;
    private final String textureName;
    private final String displayName;
    private final boolean hasOverlay;
    private ArmorPiece helmet;
    private ArmorPiece chest;
    private ArmorPiece pants;
    private ArmorPiece boots;

    public ArmorType(int id,
                     String textureName,
                     String displayName,
                     boolean hasOverlay,
                     ArmorPiece helmet,
                     ArmorPiece chest,
                     ArmorPiece pants,
                     ArmorPiece boots)
    {
        this.id = id;
        this.textureName = textureName;
        this.displayName = displayName;
        this.hasOverlay = hasOverlay;
        this.helmet = helmet;
        this.chest = chest;
        this.pants = pants;
        this.boots = boots;
        initChildren();
    }

    public ArmorType(JsonObject type, ArmorPiece helmet, ArmorPiece chest, ArmorPiece pants, ArmorPiece boots)
    {
        id = JsonHelper.getNumber(type, "id").intValue();
        textureName = JsonHelper.getString(type, "textureName");
        displayName = JsonHelper.getString(type, "displayName");
        hasOverlay = JsonHelper.getBoolean(type, "hasOverlay");
        this.helmet = helmet;
        this.chest = chest;
        this.pants = pants;
        this.boots = boots;
        initChildren();
    }

    public ArmorType(JsonObject type)
    {
        id = JsonHelper.getNumber(type, "id").intValue();
        textureName = JsonHelper.getString(type, "textureName");
        displayName = JsonHelper.getString(type, "displayName");
        hasOverlay = JsonHelper.getBoolean(type, "hasOverlay");
        helmet = new ArmorPiece(0, JsonHelper.getJsonObject(type, "helmet"));
        chest = new ArmorPiece(1, JsonHelper.getJsonObject(type, "chest"));
        pants = new ArmorPiece(2, JsonHelper.getJsonObject(type, "pants"));
        boots = new ArmorPiece(3, JsonHelper.getJsonObject(type, "boots"));
        initChildren();
    }

    private void initChildren()
    {
        if (helmet != null)
        {
            helmet.setParent(this);
            if (helmet.isWorthless())
            {
                helmet = null;
            }
        }
        if (chest != null)
        {
            chest.setParent(this);
            if (chest.isWorthless())
            {
                chest = null;
            }
        }
        if (pants != null)
        {
            pants.setParent(this);
            if (pants.isWorthless())
            {
                pants = null;
            }
        }
        if (boots != null)
        {
            boots.setParent(this);
            if (boots.isWorthless())
            {
                boots = null;
            }
        }
    }

    public int getID()
    {
        return id;
    }

    public String getTextureName()
    {
        return textureName;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public boolean hasOverlay()
    {
        return hasOverlay;
    }

    public ArmorPiece getPiece(int type)
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

    public ArmorPiece getHelmet()
    {// 0
        return helmet;
    }

    public ArmorPiece getChest()
    {// 1
        return chest;
    }

    public ArmorPiece getPants()
    {// 2
        return pants;
    }

    public ArmorPiece getBoots()
    {// 3
        return boots;
    }

    public NBTTagCompound writeToNBT(int type, NBTTagCompound nbt)
    {
        nbt.setInteger(Archive.NBT_ARMOR_TYPE_ID, getID());
        nbt.setString(Archive.NBT_ARMOR_TYPE_NAME_TEXTURE, getTextureName());
        nbt.setString(Archive.NBT_ARMOR_TYPE_NAME_DISPLAY, getDisplayName());
        nbt.setBoolean(Archive.NBT_ARMOR_TYPE_HAS_OVERLAY, hasOverlay());
        getPiece(type).writeToNBT(nbt);
        return nbt;
    }

    public static ArmorType loadFromNBT(NBTTagCompound nbt)
    {
        int id = NBTHelper.getInteger(nbt, Archive.NBT_ARMOR_TYPE_ID);
        String texture = NBTHelper.getString(nbt, Archive.NBT_ARMOR_TYPE_NAME_TEXTURE);
        String display = NBTHelper.getString(nbt, Archive.NBT_ARMOR_TYPE_NAME_DISPLAY);
        boolean hasOverlay = NBTHelper.getBoolean(nbt, Archive.NBT_ARMOR_TYPE_HAS_OVERLAY);
        ArmorPiece helmet = ArmorPiece.loadFromNBT(0, nbt);
        ArmorPiece chest = ArmorPiece.loadFromNBT(1, nbt);
        ArmorPiece pants = ArmorPiece.loadFromNBT(2, nbt);
        ArmorPiece boots = ArmorPiece.loadFromNBT(3, nbt);
        return new ArmorType(id, texture, display, hasOverlay, helmet, chest, pants, boots);
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
        result = (prime * result) + id;
        result = (prime * result) + ((pants == null) ? 0 : pants.hashCode());
        result = (prime * result) + ((textureName == null) ? 0 : textureName.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("ArmorType [id=");
        builder.append(id);
        builder.append(", textureName=");
        builder.append(textureName);
        builder.append(", displayName=");
        builder.append(displayName);
        builder.append(", hasOverlay=");
        builder.append(hasOverlay);
        builder.append(", helmet=");
        builder.append(helmet);
        builder.append(", chest=");
        builder.append(chest);
        builder.append(", pants=");
        builder.append(pants);
        builder.append(", boots=");
        builder.append(boots);
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
        if (!(obj instanceof ArmorType))
        {
            return false;
        }
        ArmorType other = (ArmorType) obj;
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
        if (id != other.id)
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
        if (textureName == null)
        {
            if (other.textureName != null)
            {
                return false;
            }
        } else if (!textureName.equals(other.textureName))
        {
            return false;
        }
        return true;
    }
}