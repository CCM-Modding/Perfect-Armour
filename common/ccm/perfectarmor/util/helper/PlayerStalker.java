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
        nbt.setString("title", "Perfect Armor Help");
        nbt.setString("author", "CCM Modding");
        NBTTagList pages = new NBTTagList("pages");
        // Clay can edit below
        pages.appendTag(new NBTTagString("1",
                                         "Welcome to perfect armour! This book will make understand the mod better. You are running our Final Modjam Verstion! Hope you enjoy what we have thus far."));
        pages.appendTag(new NBTTagString("2",
                                         "If you have any issues/ideas please visit our Git issues page. Lets get started! If you are using the special config from Modjam there are extra armours provided."));
        pages.appendTag(new NBTTagString("3",
                                         "There is a graphical limitation on the Armor bar. This is unavoidable and each half is 0.04 absorptionRatio in the config. I'll explain all of the config on the next page."));
        pages.appendTag(new NBTTagString("4",
                                         "Most of the config is quite simple. Here are the trouble makers. maxAbsorption - The amount of damage before the armor dose not work at all. absorptionRatio - This is a number between 0.01-1.00"));
        pages.appendTag(new NBTTagString("5",
                                         "This mod is still going to be developed after modjam to support enchants, mod armor editing and other features. I hope this mod works well for whoever uses it!"));
        pages.appendTag(new NBTTagString("6",
                                         "I know this is not the best documentaion. It will a much better verstion after modjam on the git. -Claycorp P.S. This was made quickly its bad I know. Sorry."));
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
    {
        final NBTTagCompound tag = player.getEntityData();
        if (!tag.hasKey(NBT))
        {
            tag.setBoolean(NBT, true);
        }
    }
}