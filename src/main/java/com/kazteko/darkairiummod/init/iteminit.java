package com.kazteko.darkairiummod.init;

import java.util.function.Supplier;

import com.kazteko.darkairiummod.DarkairiumMod;
import com.kazteko.darkairiummod.DarkairiumMod.DarkairiumItemGroup;
import com.kazteko.darkairiummod.objects.items.MelonItem;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = DarkairiumMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(DarkairiumMod.MOD_ID)
public class iteminit {
	public static final Item airiumingot_item = null;
	public static final Item diaingot_item = null;
	//Food + Drink
	public static final Item melonjuice_item = null;
	//Tools dia
	public static final Item dia_sword = null;
	public static final Item dia_pickaxe = null;
	public static final Item dia_shovel = null;
	public static final Item dia_axe = null;
	public static final Item dia_hoe = null;
	

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		
		//Ingots
		event.getRegistry().register(new Item(new Item.Properties().group(DarkairiumItemGroup.instance)).setRegistryName("airiumingot_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(DarkairiumItemGroup.instance)).setRegistryName("diaingot_item"));
		
		//Tools dia
		event.getRegistry().register(new SwordItem(ModItemTier.DiaTier, 7, 5.0F,new Item.Properties().group(DarkairiumItemGroup.instance)).setRegistryName("dia_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.DiaTier, 4, 5.0F,new Item.Properties().group(DarkairiumItemGroup.instance)).setRegistryName("dia_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.DiaTier, 4, 5.0F,new Item.Properties().group(DarkairiumItemGroup.instance)).setRegistryName("dia_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.DiaTier, 4, 5.0F,new Item.Properties().group(DarkairiumItemGroup.instance)).setRegistryName("dia_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.DiaTier, 5.0F,new Item.Properties().group(DarkairiumItemGroup.instance)).setRegistryName("dia_hoe"));
		
		//food + Drink
		event.getRegistry().register(new MelonItem(new Item.Properties().food(new Food.Builder().hunger(6).saturation(1.5F).build()).group(DarkairiumItemGroup.instance)).setRegistryName("melonjuice_item"));
	}
	
	public enum ModItemTier implements IItemTier
	{
		DiaTier(4, 1500, 15.0F, 7.0F, 250, () -> {
			return Ingredient.fromItems(iteminit.diaingot_item);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
					
		}


		@Override
		public int getMaxUses() 
		{
			return this.maxUses;
		}


		@Override
		public float getEfficiency()
		{
			return this.efficiency;
		}


		@Override
		public float getAttackDamage() 
		{
			return this.attackDamage;
		}


		@Override
		public int getHarvestLevel() 
		{
			return this.harvestLevel;
		}


		@Override
		public int getEnchantability() 
		{
			return this.enchantability;
		}


		@Override
		public Ingredient getRepairMaterial()
		{

			return this.repairMaterial.getValue();
		}
	}
	
}