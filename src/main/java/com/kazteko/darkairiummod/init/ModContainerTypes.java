package com.kazteko.darkairiummod.init;

import com.kazteko.darkairiummod.DarkairiumMod;
import com.kazteko.darkairiummod.container.DarkChestContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes 
{
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, DarkairiumMod.MOD_ID);
	
	public static final RegistryObject<ContainerType<DarkChestContainer>> DARK_CHEST = CONTAINER_TYPES.register("dark_chest", () -> IForgeContainerType.create(DarkChestContainer::new));
}
