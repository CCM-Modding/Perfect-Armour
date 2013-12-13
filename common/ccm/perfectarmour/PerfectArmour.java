package ccm.perfectarmour;

import static ccm.perfectarmour.utils.libs.Archive.CLIENT_PROXY;
import static ccm.perfectarmour.utils.libs.Archive.MOD_ID;
import static ccm.perfectarmour.utils.libs.Archive.MOD_NAME;
import static ccm.perfectarmour.utils.libs.Archive.SERVER_PROXY;

import java.io.File;

import net.minecraftforge.common.Configuration;
import ccm.perfectarmour.proxy.CommonProxy;
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
    
    public static Configuration config;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        File configFolder = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/CCM-Modding/");
        File configFile = new File(configFolder.getAbsolutePath() + "/" + MOD_ID + ".cfg");
        File armours = new File(configFolder.getAbsolutePath() + "/Armours.cfg");
        config = new Configuration(configFile, true);
        
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {}

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event)
    {}
}