package com.kazteko.darkairiummod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kazteko.darkairiummod.init.ModContainerTypes;
import com.kazteko.darkairiummod.init.ModTileEntityTypes;
import com.kazteko.darkairiummod.init.iteminit;
import com.kazteko.darkairiummod.world.gen.ModOreGen;

import java.util.stream.Collectors;

@Mod("darkairiummod")
@Mod.EventBusSubscriber(modid = DarkairiumMod.MOD_ID, bus = Bus.MOD)


public class DarkairiumMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "darkairiummod";
	public static DarkairiumMod instance;
	
	
	public DarkairiumMod() 
	{
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::enqueueIMC);
		modEventBus.addListener(this::processIMC);
		modEventBus.addListener(this::doClientStuff);
		
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
		
		instance = this;

		MinecraftForge.EVENT_BUS.register(this);
		
	}

	private void setup(final FMLCommonSetupEvent event) 
	{

	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
		
		
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		InterModComms.sendTo("examplemod", "helloworld", () -> {
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	private void processIMC(final InterModProcessEvent event) {
		LOGGER.info("Got IMC {}",
				event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) 
	{
		// do something when the server starts
		LOGGER.info("HELLO from server starting");
	}
	
	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event)
	{
		ModOreGen.generateOre();
	}
	
	

	

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			// register a new block here
			LOGGER.info("HELLO from Register Block");
		}
		
	}
	
	public static class DarkairiumItemGroup extends ItemGroup
	{
		public static final DarkairiumItemGroup instance = new DarkairiumItemGroup(ItemGroup.GROUPS.length, "darkairiumtab");
		private DarkairiumItemGroup(int index, String label)
		{
			super(index, label);
		}
		
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(iteminit.airiumingot_item);
		}
	}
	
	}
	
