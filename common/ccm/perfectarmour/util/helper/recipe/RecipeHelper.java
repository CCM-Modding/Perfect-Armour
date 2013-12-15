package ccm.perfectarmour.util.helper.recipe;

import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class RecipeHelper
{
    public static IRecipe getRecipe(Map<?, ?> data)
    {
        IRecipe recipe = null;

        Object[] inputs;
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<?, ?> e : data.entrySet())
        {
            String s = (String) e.getKey();
            if (e.getValue().toString().length() == 3)
            {
                if (s.equalsIgnoreCase("top"))
                {
                    builder.insert(0, e.getValue().toString());
                } else if (s.equalsIgnoreCase("middle"))
                {
                    builder.insert(3, e.getValue().toString());
                } else if (s.equalsIgnoreCase("bottom"))
                {
                    builder.insert(6, e.getValue().toString());
                }
            }
            
        }

        return recipe;
    }

    private static ItemStack getItemStack(final String itemID)
    {
        int id = 0;
        int meta = 0;

        if (itemID.contains(":"))
        {// Decompose String into (item ID, Meta) pairs
            final String[] tmp = itemID.split(":");
            if ((tmp != null) && (tmp.length > 0))
            {
                try
                {
                    id = Integer.parseInt(tmp[0]);
                    if (tmp.length > 1)
                    {
                        try
                        {
                            meta = Integer.parseInt(tmp[1]);
                        } catch (final Exception ex)
                        {
                            meta = 0;
                        }
                    }
                } catch (final Exception ex)
                {
                    id = 0;
                }
            }
        } else
        {// Its only an id
            id = Integer.parseInt(itemID);
        }
        return new ItemStack(id, 1, meta);
    }
}