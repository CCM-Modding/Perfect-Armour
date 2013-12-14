package ccm.perfectarmour.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

public class CustomArmor extends ItemArmor implements ISpecialArmor
{
    public CustomArmor(int id, EnumArmorMaterial material, int renderIndex, int type)
    {
        super(id, material, renderIndex, type);
        setHasSubtypes(true);
        setMaxDamage(Short.MAX_VALUE);
    }

    @Override
    public int getDisplayDamage(ItemStack stack)
    {// Display the right damage, NBT ITEM.DAMAGE
        return super.getDisplayDamage(stack);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {// Display the name
        return super.getItemStackDisplayName(stack);
    }
    
    @Override
    public void getSubItems(int id, CreativeTabs tab, List list)
    {// Add all registered types
        super.getSubItems(id, tab, list);
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
    {// take armor and change into armor properties
        ArmorProperties armorProperties = new ArmorProperties(0, 0, 0);
        return null;
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
    {// change to max protection
        return 0;
    }
    
    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
    {// Increase? or reduce? NBT ITEM.DAMAGE
        
    }
}