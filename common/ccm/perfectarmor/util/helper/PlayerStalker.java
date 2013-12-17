package ccm.perfectarmor.util.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import cpw.mods.fml.common.IPlayerTracker;

public final class PlayerStalker implements IPlayerTracker
{
    public static final String NBT = "CCM.PLAYER.PERFECTARMOR.KNOWS";

    @Override
    public void onPlayerLogin(final EntityPlayer player)
    {
        final NBTTagCompound tag = player.getEntityData();
        if (!tag.hasKey(NBT))
        {
            tag.setBoolean(NBT, true);
            player.inventory.addItemStackToInventory(get());
        }
    }

    private ItemStack get()
    {
        ItemStack tmp = new ItemStack(Item.writtenBook);
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setString("title", "Perfect Armor");
        nbt.setString("author", "CCM Modding");

        NBTTagList pages = new NBTTagList("pages");
        // Clay can edit below
        pages.appendTag(new NBTTagString("1", "Text goes here for page 1 and stuffs!"));
        pages.appendTag(new NBTTagString("2", "Text goes here for page 2 and stuffs!"));

        // Clay can edit above
        nbt.setTag("pages", pages);
        tmp.setTagCompound(nbt);

        return tmp;
    }

    @Override
    public void onPlayerLogout(final EntityPlayer player)
    {}

    @Override
    public void onPlayerChangedDimension(final EntityPlayer player)
    {}

    @Override
    public void onPlayerRespawn(final EntityPlayer player)
    {}
}
