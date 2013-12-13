package ccm.perfectarmour.item;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;

public final class ArmourTypes
{
    private static final List<ArmourType> types = new ArrayList<ArmourType>();

    public static final void addType(JsonElement type)
    {
        types.add(new ArmourType(type.getAsJsonObject()));
    }

    public static final List<ArmourType> getTypes()
    {
        return new ArrayList<ArmourType>(types);
    }
}