package darkbum.saltmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class StorageCrate extends Block {
    public static final String[] types = new String[] {"Carrot", "Potato", "PoiPotato", "Onion", "Beetroot"};

    @SideOnly(Side.CLIENT)
    private IIcon BOTTOM;

    @SideOnly(Side.CLIENT)
    private IIcon CARROTSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon CARROTTOP;

    @SideOnly(Side.CLIENT)
    private IIcon POTATOSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon POTATOTOP;

    @SideOnly(Side.CLIENT)
    private IIcon POIPOTATOSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon POIPOTATOTOP;

    @SideOnly(Side.CLIENT)
    private IIcon ONIONSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon ONIONTOP;

    @SideOnly(Side.CLIENT)
    private IIcon BEETROOTSIDE;

    @SideOnly(Side.CLIENT)
    private IIcon BEETROOTTOP;


    public StorageCrate(String name, CreativeTabs tab) {
        super(Material.wood);
        setBlockName(name);
        setCreativeTab(tab);
        setHardness(2.5F);
        setResistance(2.5F);
        setStepSound(soundTypeWood);
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < types.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta > 4)
            meta = 0;

        if (meta == 0) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.CARROTTOP;
            return this.CARROTSIDE;
        }
        if (meta == 1) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.POTATOTOP;
            return this.POTATOSIDE;
        }
        if (meta == 2) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.POIPOTATOTOP;
            return this.POIPOTATOSIDE;
        }
        if (meta == 3) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.ONIONTOP;
            return this.ONIONSIDE;
        }
        if (meta == 4) {
            if (side == 0)
                return this.BOTTOM;
            if (side == 1)
                return this.BEETROOTTOP;
            return this.BEETROOTSIDE;
        }
        return null; // ???
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        this.BOTTOM = icon.registerIcon("saltmod:StorageCrate_Bottom");
        this.CARROTSIDE = icon.registerIcon("saltmod:StorageCrate_Carrot_Side");
        this.CARROTTOP = icon.registerIcon("saltmod:StorageCrate_Carrot_Top");
        this.POTATOSIDE = icon.registerIcon("saltmod:StorageCrate_Potato_Side");
        this.POTATOTOP = icon.registerIcon("saltmod:StorageCrate_Potato_Top");
        this.POIPOTATOSIDE = icon.registerIcon("saltmod:StorageCrate_PoiPotato_Side");
        this.POIPOTATOTOP = icon.registerIcon("saltmod:StorageCrate_PoiPotato_Top");
        this.ONIONSIDE = icon.registerIcon("saltmod:StorageCrate_Onion_Side");
        this.ONIONTOP = icon.registerIcon("saltmod:StorageCrate_Onion_Top");
        this.BEETROOTSIDE = icon.registerIcon("saltmod:StorageCrate_Beetroot_Side");
        this.BEETROOTTOP = icon.registerIcon("saltmod:StorageCrate_Beetroot_Top");
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
