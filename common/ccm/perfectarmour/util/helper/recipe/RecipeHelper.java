package ccm.perfectarmour.util.helper.recipe;

import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class RecipeHelper
{
    public static IRecipe getRecipe(Map<?, ?> recipeData)
    {
        StringBuilder recipe = new StringBuilder();
        StringBuilder data = new StringBuilder();
        for (Map.Entry<?, ?> e : recipeData.entrySet())
        {
            String s = (String) e.getKey();
            if (s.equalsIgnoreCase("top"))
            {
                recipe.insert(0, e.getValue().toString());
            } else if (s.equalsIgnoreCase("middle"))
            {
                recipe.insert(3, e.getValue().toString());
            } else if (s.equalsIgnoreCase("bottom"))
            {
                recipe.insert(6, e.getValue().toString());
            } else
            {
                data.append(s);
                data.append(e.getValue().toString());
            }
        }

        return new StringShapedRecipe(null, (recipe.toString() + data.toString()));
    }

    private static ItemStack getItemStack(final String itemID)
    {
        int id = 0;
        int meta = 0;

        // Decompose String into (item ID, Meta) pairs
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
        return new ItemStack(id, 1, meta);
    }
}