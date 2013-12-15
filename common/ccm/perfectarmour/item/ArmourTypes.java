package ccm.perfectarmour.item;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;

public final class ArmourTypes
{
    private static final Map<Integer, ArmourType> types = new HashMap<Integer, ArmourType>();

    public static final void addType(JsonElement type)
    {
        types.put(Integer.valueOf(id), new ArmourType(type.getAsJsonObject()));
    }

    public static final Map<Integer, ArmourType> getTypes()
    {
        return types;
    }

    public static final ArmourType getType(int id)
    {
        return types.get(Integer.valueOf(id));
    }
}