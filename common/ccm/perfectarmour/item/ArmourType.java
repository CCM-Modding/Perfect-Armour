package ccm.perfectarmour.item;

import net.minecraft.nbt.NBTTagCompound;
import ccm.perfectarmour.utils.helpers.JsonHelper;

import com.google.gson.JsonObject;

public final class ArmourType
{
    private final String name;
    private final String textureName;
    private final boolean hasOverlay;
    private final ArmourPiece helmet;
    private final ArmourPiece chest;
    private final ArmourPiece pants;
    private final ArmourPiece boots;

    public ArmourType(String name, String textureName, boolean hasOverlay, ArmourPiece helmet, ArmourPiece chest, ArmourPiece pants, ArmourPiece boots)
    {
        this.name = name;
        this.textureName = textureName;
        this.hasOverlay = hasOverlay;
        this.helmet = helmet;
        this.chest = chest;
        this.pants = pants;
        this.boots = boots;
    }

    public ArmourType(JsonObject type, ArmourPiece helmet, ArmourPiece chest, ArmourPiece pants, ArmourPiece boots)
    {
        this(JsonHelper.getString(type, "name"), 
              JsonHelper.getString(type, "textureName"),
              JsonHelper.getBoolean(type, "hasOverlay"),
              helmet, chest, pants, boots);
    }
    
    public ArmourType(JsonObject type)
    {
        this(type, 
              new ArmourPiece(0, JsonHelper.getJsonObject(type, "helmet")), 
              new ArmourPiece(1, JsonHelper.getJsonObject(type, "chest")), 
              new ArmourPiece(2, JsonHelper.getJsonObject(type, "pants")), 
              new ArmourPiece(3, JsonHelper.getJsonObject(type, "boots")));
    }

    public String getName()
    {
        return name;
    }

    public String getTextureName()
    {
        return textureName;
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

    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt.setString("", getName());
        nbt.setString("", getTextureName());
        nbt.setBoolean("", hasOverlay());
        getHelmet().writeToNBT(nbt);
        getChest().writeToNBT(nbt);
        getPants().writeToNBT(nbt);
        getBoots().writeToNBT(nbt);
        return nbt;
    }

    public static ArmourType loadFromNBT(NBTTagCompound nbt)
    {
        return null;
    }
}