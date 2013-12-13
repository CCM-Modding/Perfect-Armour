package ccm.perfectarmour;

import static ccm.perfectarmour.utils.libs.Archive.MOD_ID;
import static ccm.perfectarmour.utils.libs.Archive.MOD_NAME;

import java.io.File;

import ccm.perfectarmour.utils.helpers.JsonHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
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

    //@SidedProxy(serverSide = SERVER_PROXY, clientSide = CLIENT_PROXY)
    //public static CommonProxy proxy;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        File configFolder = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/CCM-Modding/");
        configFolder.mkdirs();
        File armours = new File(configFolder.getAbsolutePath() + "/Armours.cfg");
        if(armours.exists()){
            JsonHelper.read(armours);
        }else{
            JsonHelper.addDefaults(armours);
            JsonHelper.read(armours);
        }
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {}

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event)
    {}
}