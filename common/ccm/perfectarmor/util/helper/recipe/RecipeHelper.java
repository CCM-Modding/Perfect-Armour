package ccm.perfectarmor.util.helper.recipe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ccm.perfectarmor.PerfectArmor;
import ccm.perfectarmor.types.ArmorPiece;

public class RecipeHelper
{
    public static IRecipe getRecipe(ArmorPiece piece, NBTTagCompound recipe)
    {
        String[] temp = fix(recipe.toString());
        Object[] data = new Object[temp.length];
        int index = 3;
        for (int i = 0; i < temp.length; i += 2)
        {
            String s = temp[i];
            if (s.equalsIgnoreCase("top"))
            {
                data[0] = temp[i + 1];
            } else if (s.equalsIgnoreCase("middle"))
            {
                data[1] = temp[i + 1];
            } else if (s.equalsIgnoreCase("bottom"))
            {
                data[2] = temp[i + 1];
            } else
            {
                data[index++] = s.toCharArray()[0];
                ItemStack tmp = getItemStack(temp[i + 1]);
                data[index++] = tmp.itemID > 0 ? tmp : temp[i + 1];
            }
        }
        int id;
        switch (piece.getType())
        {
            case 0:
                id = PerfectArmor.instance.helmet.itemID;
                break;
            case 1:
                id = PerfectArmor.instance.chest.itemID;
                break;
            case 2:
                id = PerfectArmor.instance.pants.itemID;
                break;
            case 3:
                id = PerfectArmor.instance.boots.itemID;
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

    private static String[] fix(String in)
    {
        String[] tmp = in.split(",");
        List<String> temp = new ArrayList<String>();
        for (String s : tmp)
        {
            String[] r = s.split(":");
            for (int i = 0; i < r.length; i++)
            {
                temp.add(r[i]);
            }
        }
        return (String[]) temp.toArray();
    }

    private static ItemStack getItemStack(final String itemID)
    {
        int id = 0;
        int meta = 0;

        // Decompose String into (item ID, Meta) pairs
        final String[] tmp = itemID.split("|");
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