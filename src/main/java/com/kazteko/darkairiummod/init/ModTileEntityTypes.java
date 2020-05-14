package com.kazteko.darkairiummod.init;

import com.kazteko.darkairiummod.DarkairiumMod;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.kazteko.darkairiummod.tileentity.DarkChestTileEntity;
import com.kazteko.darkairiummod.tileentity.QuarryTileEntity;

public class ModTileEntityTypes 
{
public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, DarkairiumMod.MOD_ID);

public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry", () -> TileEntityType.Builder.create(QuarryTileEntity::new, blockinit.quarry).build(null));
public static final RegistryObject<TileEntityType<DarkChestTileEntity>> DARK_CHEST = TILE_ENTITY_TYPES.register("dark_chest", () -> TileEntityType.Builder.create(DarkChestTileEntity::new, blockinit.dark_chest).build(null));
}