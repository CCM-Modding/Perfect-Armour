package ccm.perfectarmor.util.helper.json;

import java.util.Map;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.nbt.NBTTagString;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public final class JsonNBTHelper
{
    public static NBTBase parseJSON(JsonElement element)
    {
        if (element != null)
        {
            if (!element.isJsonNull())
            {
                if (element.isJsonObject())
                {
                    return parseJSON(element.getAsJsonObject());
                }
                if (element.isJsonPrimitive())
                {
                    return parseJSON(element.getAsJsonPrimitive());
                }
                if (element.isJsonArray())
                {
                    return parseJSON(element.getAsJsonArray());
                }
            }
        }
        return null;
    }

    private static NBTTagCompound parseJSON(JsonObject element)
    {
        NBTTagCompound nbt = new NBTTagCompound();
        for (Map.Entry<String, JsonElement> entry : element.entrySet())
        {
            nbt.setTag(entry.getKey(), parseJSON(entry.getValue()));
        }
        return nbt;
    }

    private static NBTTagList parseJSON(JsonArray element)
    {
        NBTTagList nbt = new NBTTagList();
        for (JsonElement e : element)
        {
            nbt.appendTag(parseJSON(e));
        }
        return nbt;
    }

    private static NBTBase parseJSON(JsonPrimitive element)
    {
        if (element.isString())
        {
            return new NBTTagString("", element.getAsString());
        }
        if (element.isBoolean())
        {
            return new NBTTagByte("", (byte) (element.getAsBoolean() ? 1 : 0));
        }

        Number n = element.getAsNumber();
        if (n instanceof Byte)
        {
            return new NBTTagByte("", n.byteValue());
        }
        if (n instanceof Short)
        {
            return new NBTTagShort("", n.shortValue());
        }
        if (n instanceof Integer)
        {
            return new NBTTagInt("", n.intValue());
        }
        if (n instanceof Long)
        {
            return new NBTTagLong("", n.longValue());
        }
        if (n instanceof Float)
        {
            return new NBTTagFloat("", n.floatValue());
        }
        if (n instanceof Double)
        {
            return new NBTTagDouble("", n.doubleValue());
        }
        return null;
    }
}