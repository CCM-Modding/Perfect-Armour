package ccm.perfectarmor.util.helper;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;
import ccm.perfectarmor.PerfectArmor;
import ccm.perfectarmor.types.ArmorPiece;

public class RecipeHelper
{
    public static IRecipe getRecipe(ArmorPiece piece, NBTTagCompound recipe)
    {
        Object[] temp = fix(recipe.toString());
        Object[] data = new Object[temp.length - 3];
        int index = 3;
        for (int i = 0; i < temp.length; i += 2)
        {
            String s = (String) temp[i];
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
                ItemStack tmp = getItemStack((String) temp[i + 1]);
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

    private static Object[] fix(String in)
    {
        if(in.contains("ARMOR.PIECE.RECIPE")){
            in = in.replace("ARMOR.PIECE.RECIPE", "");
        }
        in = in.substring(2);
        in = in.replace(",]", "");
        String[] tmp = in.split(",");
        List<String> temp = new ArrayList<String>();
        for (String s : tmp)
        {
            String[] r = s.split(":");
            for (String element : r)
            {
                temp.add(element);
            }
        }
        return temp.toArray();
    }

    private static ItemStack getItemStack(final String itemID)
    {
        int id = 0;
        int meta = 0;

        // Decompose String into (item ID, Meta) pairs
        final String[] tmp = itemID.split("&");
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

    private static List<ItemStack> delete = new ArrayList<ItemStack>();
    static
    {
        // leather
        delete.add(new ItemStack(Item.helmetLeather));
        delete.add(new ItemStack(Item.plateLeather));
        delete.add(new ItemStack(Item.legsLeather));
        delete.add(new ItemStack(Item.bootsLeather));
        // iron
        delete.add(new ItemStack(Item.helmetIron));
        delete.add(new ItemStack(Item.plateIron));
        delete.add(new ItemStack(Item.legsIron));
        delete.add(new ItemStack(Item.bootsIron));
        // gold
        delete.add(new ItemStack(Item.helmetGold));
        delete.add(new ItemStack(Item.plateGold));
        delete.add(new ItemStack(Item.legsGold));
        delete.add(new ItemStack(Item.bootsGold));
        // diamond
        delete.add(new ItemStack(Item.helmetDiamond));
        delete.add(new ItemStack(Item.plateDiamond));
        delete.add(new ItemStack(Item.legsDiamond));
        delete.add(new ItemStack(Item.bootsDiamond));
    }

    public static void deleteVanilla()
    {
        List<IRecipe> minecraftRecipes = CraftingManager.getInstance().getRecipeList();
        for (int i = 0; i < minecraftRecipes.size(); ++i)
        {
            IRecipe tmp = minecraftRecipes.get(i);
            ItemStack result = tmp.getRecipeOutput();
            if (result != null)
            {
                for (final ItemStack toRemove : delete)
                {
                    if(toRemove.isItemEqual(result)){
                        minecraftRecipes.remove(i);
                        --i;
                    }
                }
            }
        }
    }
}