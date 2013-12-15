package ccm.perfectarmor.item;

import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ISpecialArmor;
import ccm.perfectarmor.types.ArmorPiece;
import ccm.perfectarmor.types.ArmorType;
import ccm.perfectarmor.types.ArmorTypes;
import ccm.perfectarmor.util.helper.NBTHelper;
import ccm.perfectarmor.util.lib.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomArmor extends ItemArmor implements ISpecialArmor
{
    public CustomArmor(int id, int renderIndex, int type)
    {
        super(id, EnumArmorMaterial.DIAMOND, renderIndex, type);
        setHasSubtypes(true);
    }

    @Override
    public Icon getIcon(ItemStack stack, int pass)
    {
        System.out.println(ArmorTypes.getType(stack).getIcon());
        System.out.println(ArmorTypes.getType(stack).getOverlay());
        return pass == 1 ? ArmorTypes.getType(stack).getOverlay() : ArmorTypes.getType(stack).getIcon();
    }

    @Override
    public void registerIcons(IconRegister register)
    {
        for (ArmorType type : ArmorTypes.getTypes().values())
        {
            StringBuilder sb = new StringBuilder();
            sb.append(Archive.MOD_ID + ":");
            sb.append(type.getTextureName());
            sb.append("/");
            switch (armorType)
            {
                case 0:
                    sb.append("helmet");
                    break;
                case 1:
                    sb.append("chestplate");
                    break;
                case 2:
                    sb.append("leggins");
                    break;
                case 3:
                    sb.append("boots");
                    break;
            }
            if (type.hasOverlay())
            {
                type.setOverlay(register.registerIcon(sb.toString() + "_overlay"));
            }
            type.setIcon(register.registerIcon(sb.toString()));
        }
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
        return getPiece(stack).getDurability();
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
        String s = (ArmorTypes.getType(stack).getDisplayName() + " " + getPiece(stack).getDisplayName());

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
        for (Map.Entry<Integer, ArmorType> e : ArmorTypes.getTypes().entrySet())
        {
            ItemStack tmp = new ItemStack(id, 1, e.getKey());
            NBTTagCompound nbt = new NBTTagCompound();

            e.getValue().writeToNBT(armorType, nbt);
            tmp.setTagCompound(nbt);
            tmp.setItemDamage(0);

            list.add(tmp);
        }
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
    {
        return new ArmorProperties(0, getPiece(armor).absorptionRatio(), getPiece(armor).maxAbsorption());
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
    {
        return getPiece(armor).maxAbsorption();
    }

    private ArmorPiece getPiece(ItemStack stack)
    {
        return ArmorPiece.loadFromNBT(armorType, stack.getTagCompound());
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
        StringBuilder builder = new StringBuilder();

        builder.append(Archive.MOD_ID + ":textures/models/armor/");
        builder.append(ArmorTypes.getType(stack).getTextureName());
        builder.append("_layer_");
        switch (getPiece(stack).getType())
        {
            case 2:
                builder.append(2);
                break;
            default:
                builder.append(1);
                break;
        }
        if (ArmorTypes.getType(stack).hasOverlay() && (type != null) && type.equalsIgnoreCase("overlay"))
        {
            builder.append("_overlay");
        }
        builder.append(".png");

        return builder.toString();
    }
}