package ccm.perfectarmour.util.lib;

public final class Archive
{
    public static final String MOD_ID = "perfectarmour";
    public static final String MOD_NAME = "Perfect Armour";
    public static final String PROXY = "ccm." + MOD_ID + ".proxy.";
    public static final String SERVER_PROXY = PROXY + "CommonProxy";
    public static final String CLIENT_PROXY = PROXY + "ClientProxy";

    // NBT Black Magic
    public static final String NBT_ITEM_DAMAGE = "ITEM.DAMAGE";
    public static final String NBT_ARMOUR_TYPE = "ARMOUR.TYPE";
    public static final String NBT_ARMOUR_TYPE_ID = NBT_ARMOUR_TYPE + ".ID";
    public static final String NBT_ARMOUR_TYPE_NAME = NBT_ARMOUR_TYPE + ".NAME";
    public static final String NBT_ARMOUR_TYPE_NAME_DISPLAY = NBT_ARMOUR_TYPE_NAME + ".DISPLAY";
    public static final String NBT_ARMOUR_TYPE_HAS_OVERLAY = NBT_ARMOUR_TYPE + ".HAS_OVERLAY";
    public static final String NBT_ARMOUR_PIECE = "ARMOUR.PIECE";
    public static final String NBT_ARMOUR_PIECE_NAME_DISPLAY = NBT_ARMOUR_PIECE + ".NAME.DISPLAY";
    public static final String NBT_ARMOUR_PIECE_DURABILITY = NBT_ARMOUR_PIECE + ".DURABILITY";
    public static final String NBT_ARMOUR_PIECE_RECIPE = NBT_ARMOUR_PIECE + ".RECIPE";
    public static final String NBT_ARMOUR_PIECE_ABSORBTION = NBT_ARMOUR_PIECE + ".ABSORBTION";
    public static final String NBT_ARMOUR_PIECE_ABSORBTION_RATIO = NBT_ARMOUR_PIECE_ABSORBTION + ".RATIO";
    public static final String NBT_ARMOUR_PIECE_ABSORBTION_MAX = NBT_ARMOUR_PIECE_ABSORBTION + ".MAX";
}