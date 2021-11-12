package dev.alexjf.vanilla_improvements_agriculture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VanillaImprovementsAgriculture implements ModInitializer {
	//variables
	static String modid = "vanilla_improvements_agriculture";
	//blocks
	public static final PostBlock POST = new PostBlock(FabricBlockSettings.of(Material.WOOD).hardness(2f));
	//items
	//nothing rn
	//item groups
	public static final ItemGroup BLOCK_GROUP = FabricItemGroupBuilder.build(
		new Identifier(modid, "blocks"),
		() -> new ItemStack(Blocks.HAY_BLOCK));
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier(modid, "items"),
		() -> new ItemStack(Items.WHEAT));
	//other stuff
	public static final Logger LOGGER = LogManager.getLogger(modid);

	@Override
	public void onInitialize() {
		//register blocks
		Registry.register(Registry.BLOCK, new Identifier(modid, "post"), POST);
		LOGGER.info("Finished block registry");
		//register block items
		Registry.register(Registry.ITEM, new Identifier(modid, "post"), new BlockItem(POST, new FabricItemSettings().group(VanillaImprovementsAgriculture.BLOCK_GROUP)));
		LOGGER.info("Finished block item registry");
		//register items
		LOGGER.info("Finished item registry");
		//other stuff
		LOGGER.info("Finished Initializing Vanilla Improvements Agriculture");
	}
}