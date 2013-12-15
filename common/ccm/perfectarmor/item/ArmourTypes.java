package ccm.perfectarmor.item;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;

public final class ArmourTypes
{
    private static final Map<Integer, ArmourType> types = new HashMap<Integer, ArmourType>();

    public static final void addType(JsonElement element)
    {
        ArmourType type = new ArmourType(element.getAsJsonObject());
        types.put(type.getID(), type);
    }

    public static final ArmourType getType(int id)
    {
        return types.get(Integer.valueOf(id));
    }

    public static final Map<Integer, ArmourType> getTypes()
    {
        return types;
    }
}