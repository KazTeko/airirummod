package com.kazteko.darkairiummod.init;

import com.kazteko.darkairiummod.DarkairiumMod;
import com.kazteko.darkairiummod.DarkairiumMod.DarkairiumItemGroup;
import com.kazteko.darkairiummod.objects.blocks.BlockQuarry;
import com.kazteko.darkairiummod.objects.blocks.DarkChestBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(DarkairiumMod.MOD_ID)
@Mod.EventBusSubscriber(modid = DarkairiumMod.MOD_ID, bus = Bus.MOD)

public class blockinit 
{
	public static final Block airiumblock_block = null;
	public static final Block diablock_block = null;
	public static final Block diaore_block = null;
	public static final Block quarry = null;
	public static final Block dark_chest = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 10.0F).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)).setRegistryName("airiumblock_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 10.0F).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)).setRegistryName("diablock_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(7.0F, 6.0F).sound(SoundType.STONE).harvestLevel(4).harvestTool(ToolType.PICKAXE)).setRegistryName("diaore_block"));
		event.getRegistry().register(new BlockQuarry(Block.Properties.create(Material.IRON).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName("quarry"));
		event.getRegistry().register(new DarkChestBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(0.3F, 6.0F).sound(SoundType.METAL).harvestLevel(1).harvestTool(ToolType.PICKAXE)).setRegistryName("dark_chest"));
	
	}
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(airiumblock_block, new Item.Properties().maxStackSize(32).group(DarkairiumItemGroup.instance)).setRegistryName("airiumblock_block"));
		event.getRegistry().register(new BlockItem(diablock_block, new Item.Properties().maxStackSize(32).group(DarkairiumItemGroup.instance)).setRegistryName("diablock_block"));
		event.getRegistry().register(new BlockItem(diaore_block, new Item.Properties().maxStackSize(64).group(DarkairiumItemGroup.instance)).setRegistryName("diaore_block"));
		event.getRegistry().register(new BlockItem(quarry, new Item.Properties().maxStackSize(1).group(DarkairiumItemGroup.instance)).setRegistryName("quarry"));
		event.getRegistry().register(new BlockItem(dark_chest, new Item.Properties().maxStackSize(32).group(DarkairiumItemGroup.instance)).setRegistryName("dark_chest"));
	
	
	
	}
}