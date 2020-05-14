package com.kazteko.darkairiummod.objects.items;

import java.util.List;

import com.kazteko.darkairiummod.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class MelonItem extends Item {
	   public MelonItem(Item.Properties p_i50054_1_) {
	      super(p_i50054_1_);
	   }
	   @Override
	   public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
	      ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
	      return entityLiving instanceof PlayerEntity && ((PlayerEntity)entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.GLASS_BOTTLE);
	   }

	@Override
	public boolean hasEffect(ItemStack stack)
	{
		return false;
	}
	
	 public ItemStack onItemUseFinish1(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		return null;
	 }
		 

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		if(KeyboardHelper.isHoldingShift())
		{
			tooltip.add(new StringTextComponent("Melon Juice Heals 3 Meat Peices"));
		} else {
			tooltip.add(new StringTextComponent("\u00A75" + "Hold Shift For More Information"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
