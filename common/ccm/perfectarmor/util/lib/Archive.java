package ccm.perfectarmor.util.lib;

public final class Archive
{
    public static final String MOD_ID = "perfectarmor";
    public static final String MOD_NAME = "Perfect Armor";
    public static final String PROXY = "ccm." + MOD_ID + ".proxy.";
    public static final String SERVER_PROXY = PROXY + "CommonProxy";
    public static final String CLIENT_PROXY = PROXY + "ClientProxy";

    // NBT Black Magic
    public static final String NBT_ITEM_DAMAGE = "ITEM.DAMAGE";
    public static final String NBT_ARMOR_TYPE = "ARMOR.TYPE";
    public static final String NBT_ARMOR_TYPE_ID = NBT_ARMOR_TYPE + ".ID";
    public static final String NBT_ARMOR_TYPE_NAME = NBT_ARMOR_TYPE + ".NAME";
    public static final String NBT_ARMOR_TYPE_NAME_TEXTURE = NBT_ARMOR_TYPE_NAME + ".TEXTURE";
    public static final String NBT_ARMOR_TYPE_NAME_DISPLAY = NBT_ARMOR_TYPE_NAME + ".DISPLAY";
    public static final String NBT_ARMOR_TYPE_HAS_OVERLAY = NBT_ARMOR_TYPE + ".HAS_OVERLAY";
    public static final String NBT_ARMOR_PIECE = "ARMOR.PIECE";
    public static final String NBT_ARMOR_PIECE_NAME_DISPLAY = NBT_ARMOR_PIECE + ".NAME.DISPLAY";
    public static final String NBT_ARMOR_PIECE_DURABILITY = NBT_ARMOR_PIECE + ".DURABILITY";
    public static final String NBT_ARMOR_PIECE_RECIPE = NBT_ARMOR_PIECE + ".RECIPE";
    public static final String NBT_ARMOR_PIECE_ABSORBTION = NBT_ARMOR_PIECE + ".ABSORBTION";
    public static final String NBT_ARMOR_PIECE_ABSORBTION_RATIO = NBT_ARMOR_PIECE_ABSORBTION + ".RATIO";
    public static final String NBT_ARMOR_PIECE_ABSORBTION_MAX = NBT_ARMOR_PIECE_ABSORBTION + ".MAX";
}