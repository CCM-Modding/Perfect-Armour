package ccm.perfectarmour.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import ccm.perfectarmour.utils.libs.Archive;

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
    {
        if (stack.hasTagCompound())
        {
            NBTTagCompound nbt = stack.getTagCompound();

            if (nbt.hasKey(Archive.NBT_ITEM_DAMAGE))
            {
                return nbt.getInteger(Archive.NBT_ITEM_DAMAGE);
            }
        }
        return 0;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        String s = (type.getName() + " " + pice.getName());

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
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < ArmourTypes.getTypes().size(); i++)
        {
            ItemStack tmp = new ItemStack(id, 1, i);

            // Do NBT BLACK MAGIC

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
        if (stack.hasTagCompound())
        {
            NBTTagCompound nbt = stack.getTagCompound();

            if (nbt.hasKey(Archive.NBT_ITEM_DAMAGE))
            {
                nbt.setInteger(Archive.NBT_ITEM_DAMAGE, (nbt.getInteger(Archive.NBT_ITEM_DAMAGE) + damage));
            }
        }
    }
}