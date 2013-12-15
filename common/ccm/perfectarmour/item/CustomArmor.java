package ccm.perfectarmour.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import ccm.perfectarmour.util.helper.NBTHelper;
import ccm.perfectarmour.utils.libs.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomArmor extends ItemArmor implements ISpecialArmor
{
    public CustomArmor(int id, EnumArmorMaterial material, int renderIndex, int type)
    {
        super(id, material, renderIndex, type);
        setHasSubtypes(true);
    }

    @Override
    public boolean getShareTag()
    {
        return true;
    }

    @Override
    public int getDamage(ItemStack stack)
    {
        return NBTHelper.getInteger(stack, Archive.NBT_ITEM_DAMAGE);
    }

    @Override
    public int getDisplayDamage(ItemStack stack)
    {
        return getDamage(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack)
    {
        return ArmourPiece.loadFromNBT(armorType, stack.getTagCompound()).getDurability();
    }

    @Override
    public boolean isDamaged(ItemStack stack)
    {
        return NBTHelper.getInteger(stack, Archive.NBT_ITEM_DAMAGE) > 0;
    }

    @Override
    public void setDamage(ItemStack stack, int damage)
    {
        NBTHelper.setInteger(stack, Archive.NBT_ITEM_DAMAGE, damage);
    }

    @Override
    public String getItemDisplayName(ItemStack stack)
    {
        String s = (ArmourType.loadFromNBT(stack.getTagCompound()).getDisplayName() + " " + ArmourPiece.loadFromNBT(armorType, stack.getTagCompound()).getDisplayName());

        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("display"))
        {
            NBTTagCompound nbt = stack.getTagCompound().getCompoundTag("display");

            if (nbt.hasKey("Name"))
            {
                s = nbt.getString("Name");
            }
        }
        return s;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < ArmourTypes.getTypes().size(); i++)
        {
            ArmourType type = ArmourTypes.getTypes().get(i);
            ItemStack tmp = new ItemStack(id, 1, i);

            NBTTagCompound nbt = new NBTTagCompound();
            type.writeToNBT(armorType, nbt);
            tmp.setItemDamage(0);

            tmp.setTagCompound(nbt);
            list.add(tmp);
        }
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
    {
        return new ArmorProperties(0, ArmourPiece.loadFromNBT(armorType, armor.getTagCompound()).absorptionRatio(), ArmourPiece.loadFromNBT(armorType, armor.getTagCompound())
                .maxAbsorption());
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
    {
        return ArmourPiece.loadFromNBT(armorType, armor.getTagCompound()).maxAbsorption();
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
    {
        int newDamage = getDamage(stack) + damage;
        if (newDamage >= getMaxDamage(stack))
        {
            stack.stackSize = 0;
        } else
        {
            setDamage(stack, newDamage);
        }
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return super.getArmorTexture(stack, entity, slot, type);
    }
}