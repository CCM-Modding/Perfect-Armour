package ccm.perfectarmor.util.helper.recipe;

import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ccm.perfectarmor.PerfectArmour;
import ccm.perfectarmor.types.ArmorPiece;

public class RecipeHelper
{
    public static IRecipe getRecipe(ArmorPiece piece, Map<?, ?> recipeData)
    {
        Object[] data = new Object[(recipeData.entrySet().size() * 2) - 3];
        int index = 3;
        for (Map.Entry<?, ?> e : recipeData.entrySet())
        {
            String s = e.getKey().toString();
            if (s.equalsIgnoreCase("top"))
            {
                data[0] = e.getValue().toString();
            } else if (s.equalsIgnoreCase("middle"))
            {
                data[1] = e.getValue().toString();
            } else if (s.equalsIgnoreCase("bottom"))
            {
                data[2] = e.getValue().toString();
            } else
            {
                data[index++] = s.toCharArray()[0];
                ItemStack tmp = getItemStack(e.getValue().toString());
                data[index++] = tmp.itemID > 0 ? tmp : e.getValue().toString();
            }
        }
        int id;
        switch (piece.getType())
        {
            case 0:
                id = PerfectArmour.instance.helmet.itemID;
                break;
            case 1:
                id = PerfectArmour.instance.chest.itemID;
                break;
            case 2:
                id = PerfectArmour.instance.pants.itemID;
                break;
            case 3:
                id = PerfectArmour.instance.boots.itemID;
                break;
            default:
                id = 0;
                break;
        }
        ItemStack result = new ItemStack(id, 1, piece.getParent().getID());
        NBTTagCompound nbt = new NBTTagCompound();

        piece.getParent().writeToNBT(piece.getType(), nbt);
        result.setTagCompound(nbt);
        result.setItemDamage(0);

        return new ShapedOreRecipe(result, data);
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