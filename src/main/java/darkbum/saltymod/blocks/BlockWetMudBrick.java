package darkbum.saltymod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.init.ModSounds;
import darkbum.saltymod.init.SaltConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class BlockWetMudBrick extends Block {

	@SideOnly(Side.CLIENT)
    private IIcon MAIN0;

	@SideOnly(Side.CLIENT)
    private IIcon MAIN1;

    @SideOnly(Side.CLIENT)
    private IIcon MAIN2;

	public BlockWetMudBrick(String name, CreativeTabs tab) {
		super (Material.clay);
		setStepSound(ModSounds.soundTypeWetMudBrick);
		setBlockName(name);
		setCreativeTab(tab);
		setHardness(1.0F);
		setResistance(3.0F);
		setHarvestLevel("shovel", 0);
		if(SaltConfig.mudBrickComplex) {
		setTickRandomly(true);
		} else {
		setTickRandomly(false);
		}
	}

	@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return (meta == 1) ? this.MAIN1 : ((meta == 2) ? this.MAIN2 : this.MAIN0);
	}

	@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister par1) {
			this.MAIN0 = par1.registerIcon("saltymod:wet_mud_bricks_0");
			this.MAIN1 = par1.registerIcon("saltymod:wet_mud_bricks_1");
			this.MAIN2 = par1.registerIcon("saltymod:wet_mud_bricks_2");
	}
}
