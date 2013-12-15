package ccm.perfectarmor.types;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;

import com.google.gson.JsonElement;

public final class ArmorTypes
{
    private static final Map<Integer, ArmorType> types = new HashMap<Integer, ArmorType>();

    public static final void addType(JsonElement element)
    {
        ArmorType type = new ArmorType(element.getAsJsonObject());
        types.put(type.getID(), type);
    }

    public static final ArmorType getType(int id)
    {
        return types.get(Integer.valueOf(id));
    }

    public static final ArmorType getType(ItemStack stack)
    {
        return getType(ArmorType.loadFromNBT(stack.getTagCompound()).getID());
    }

    public static final Map<Integer, ArmorType> getTypes()
    {
        return types;
    }
}