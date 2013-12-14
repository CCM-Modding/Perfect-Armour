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
    private final ArmourType type;
    private final ArmourPiece pice;

    public CustomArmor(int id, EnumArmorMaterial material, int renderIndex, int type, ArmourType aType)
    {
        super(id, material, renderIndex, type);
        setHasSubtypes(true);
        setMaxDamage(Short.MAX_VALUE);
        this.type = aType;
        pice = aType.getPiece(type);
    }

    @Override
    public int getDisplayDamage(ItemStack stack)
    {// Display the right damage, NBT ITEM.DAMAGE
        return super.getDisplayDamage(stack);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return (type.getName() + " " + pice.getName());
    }

    @Override
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < ArmourTypes.getTypes().size(); i++)
        {
            ItemStack tmp = new ItemStack(id, 1, i);

            // Do NBT MAGIC

            list.add(tmp);
        }
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
    {
        return new ArmorProperties(0, pice.absorptionRatio(), pice.maxAbsorption());
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
    {
        return pice.maxAbsorption();
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
    {
        // Increase? or reduce? NBT ITEM.DAMAGE
    }
}