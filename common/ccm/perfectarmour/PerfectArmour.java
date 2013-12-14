package ccm.perfectarmour;

import static ccm.perfectarmour.utils.libs.Archive.CLIENT_PROXY;
import static ccm.perfectarmour.utils.libs.Archive.MOD_ID;
import static ccm.perfectarmour.utils.libs.Archive.MOD_NAME;
import static ccm.perfectarmour.utils.libs.Archive.SERVER_PROXY;

import java.io.File;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import ccm.perfectarmour.item.CustomArmor;
import ccm.perfectarmour.proxy.CommonProxy;
import ccm.perfectarmour.utils.helpers.json.JsonDefaults;
import ccm.perfectarmour.utils.helpers.json.JsonHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = MOD_ID, name = MOD_NAME, useMetadata = true)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class PerfectArmour
{
    @Instance(MOD_ID)
    public static PerfectArmour instance;

    @SidedProxy(serverSide = SERVER_PROXY, clientSide = CLIENT_PROXY)
    public static CommonProxy proxy;

    CustomArmor helmet;
    CustomArmor chest;
    CustomArmor pants;
    CustomArmor boots;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        File configFolder = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/CCM-Modding/");
        configFolder.mkdirs();
        File armours = new File(configFolder.getAbsolutePath() + "/Armours.cfg");
        if (!armours.exists())
        {
            JsonDefaults.addDefaults(armours);
        }
        JsonHelper.read(armours);
        
        // Getting our ids
        int helmetID = Item.helmetLeather.itemID;
        int chestID = Item.plateLeather.itemID;
        int pantsID = Item.legsLeather.itemID;
        int bootsID = Item.bootsLeather.itemID;

        // Getting rid of Leather
        Item.itemsList[Item.helmetLeather.itemID] = null;
        Item.itemsList[Item.plateLeather.itemID] = null;
        Item.itemsList[Item.legsLeather.itemID] = null;
        Item.itemsList[Item.bootsLeather.itemID] = null;
        // Getting rid of Iron
        Item.itemsList[Item.helmetIron.itemID] = null;
        Item.itemsList[Item.plateIron.itemID] = null;
        Item.itemsList[Item.legsIron.itemID] = null;
        Item.itemsList[Item.bootsIron.itemID] = null;
        // Getting rid of Gold
        Item.itemsList[Item.helmetGold.itemID] = null;
        Item.itemsList[Item.plateGold.itemID] = null;
        Item.itemsList[Item.legsGold.itemID] = null;
        Item.itemsList[Item.bootsGold.itemID] = null;
        // Getting rid of Diamond
        Item.itemsList[Item.helmetDiamond.itemID] = null;
        Item.itemsList[Item.plateDiamond.itemID] = null;
        Item.itemsList[Item.legsDiamond.itemID] = null;
        Item.itemsList[Item.bootsDiamond.itemID] = null;

        helmet = new CustomArmor(helmetID, EnumArmorMaterial.IRON, 1, 0);
        chest = new CustomArmor(chestID, EnumArmorMaterial.IRON, 1, 1);
        pants = new CustomArmor(pantsID, EnumArmorMaterial.IRON, 1, 2);
        boots = new CustomArmor(bootsID, EnumArmorMaterial.IRON, 1, 3);
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {}

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event)
    {}
}