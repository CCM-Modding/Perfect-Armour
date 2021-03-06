package ccm.perfectarmor;

import static ccm.perfectarmor.util.lib.Archive.MOD_ID;
import ccm.nucleum.omnium.CCMMod;
import ccm.perfectarmor.item.CustomArmor;
import ccm.perfectarmor.types.ArmorPiece;
import ccm.perfectarmor.types.ArmorType;
import ccm.perfectarmor.types.ArmorTypes;
import ccm.perfectarmor.util.helper.PlayerStalker;
import ccm.perfectarmor.util.helper.RecipeHelper;
import ccm.perfectarmor.util.helper.json.JsonDefaults;
import ccm.perfectarmor.util.lib.Archive;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MOD_ID, useMetadata = true, dependencies = "required-after:nucleum_omnium")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class PerfectArmor extends CCMMod
{
    @Instance(MOD_ID)
    public static PerfectArmor instance;
    public CustomArmor helmet;
    public CustomArmor chest;
    public CustomArmor pants;
    public CustomArmor boots;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        initLogger();
        // Getting our ids
        int helmetID = 3000/* Item.helmetLeather.itemID */;
        int chestID = 3001/* Item.plateLeather.itemID */;
        int pantsID = 3002/* Item.legsLeather.itemID */;
        int bootsID = 3003/* Item.bootsLeather.itemID */;
        // Getting rid of Leather
        // Item.itemsList[Item.helmetLeather.itemID] = null;
        // Item.itemsList[Item.plateLeather.itemID] = null;
        // Item.itemsList[Item.legsLeather.itemID] = null;
        // Item.itemsList[Item.bootsLeather.itemID] = null;
        // Getting rid of Iron
        // Item.itemsList[Item.helmetIron.itemID] = null;
        // Item.itemsList[Item.plateIron.itemID] = null;
        // Item.itemsList[Item.legsIron.itemID] = null;
        // Item.itemsList[Item.bootsIron.itemID] = null;
        // Getting rid of Gold
        // Item.itemsList[Item.helmetGold.itemID] = null;
        // Item.itemsList[Item.plateGold.itemID] = null;
        // Item.itemsList[Item.legsGold.itemID] = null;
        // Item.itemsList[Item.bootsGold.itemID] = null;
        // Getting rid of Diamond
        // Item.itemsList[Item.helmetDiamond.itemID] = null;
        // Item.itemsList[Item.plateDiamond.itemID] = null;
        // Item.itemsList[Item.legsDiamond.itemID] = null;
        // Item.itemsList[Item.bootsDiamond.itemID] = null;
        helmet = new CustomArmor(helmetID, 1, 0);
        chest = new CustomArmor(chestID, 1, 1);
        pants = new CustomArmor(pantsID, 1, 2);
        boots = new CustomArmor(bootsID, 1, 3);
        GameRegistry.registerItem(helmet, "custom.helmet", Archive.MOD_ID);
        GameRegistry.registerItem(chest, "custom.chest", Archive.MOD_ID);
        GameRegistry.registerItem(pants, "custom.pants", Archive.MOD_ID);
        GameRegistry.registerItem(boots, "custom.boots", Archive.MOD_ID);
        JsonDefaults.loadJson(event);
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {
        RecipeHelper.deleteVanilla();
        for (ArmorType type : ArmorTypes.getTypes().values())
        {
            safeAddRecipe(type.getHelmet());
            safeAddRecipe(type.getChest());
            safeAddRecipe(type.getPants());
            safeAddRecipe(type.getBoots());
        }
        GameRegistry.registerPlayerTracker(new PlayerStalker());
    }

    private static void safeAddRecipe(ArmorPiece piece)
    {
        if ((piece != null) && piece.hasRecipe())
        {
            GameRegistry.addRecipe(piece.getIRecipe());
        }
    }
}