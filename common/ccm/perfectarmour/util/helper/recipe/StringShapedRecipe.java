package ccm.perfectarmour.util.helper.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class StringShapedRecipe implements IRecipe
{

    public StringShapedRecipe(Object object, String string)
    {

    }

    @Override
    public boolean matches(InventoryCrafting inventorycrafting, World world)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventorycrafting)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getRecipeSize()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
