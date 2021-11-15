package com.silverleaf.mccourse.item;

import com.silverleaf.mccourse.MCCourseMod;
import com.silverleaf.mccourse.block.ModBlocks;
import com.silverleaf.mccourse.block.ModFluids;
import com.silverleaf.mccourse.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> COPPER_INGOT = Registration.ITEMS.register("copper_ingot",
            () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_WIRE = Registration.ITEMS.register("copper_wire",
            () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

    public static final RegistryObject<Item> COPPERED_APPLE = Registration.ITEMS.register("coppered_apple",
            () -> new CopperedApple());


    //==========================T O O L S==============================
    public static final RegistryObject<Item> COPPER_SHOVEL = Registration.ITEMS.register( "copper_shovel",
            () -> new ShovelItem(ModItemTier.COPPER, 0f, 0f,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.SHOVEL,2)
                            .group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> COPPER_SWORD = Registration.ITEMS.register( "copper_sword",
            () -> new SwordItem(ModItemTier.COPPER, 2, 0f,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> COPPER_PICKAXE = Registration.ITEMS.register( "copper_pickaxe",
            () -> new PickaxeItem(ModItemTier.COPPER, 0, 0f,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.PICKAXE,2)
                            .group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> COPPER_HOE = Registration.ITEMS.register( "copper_hoe",
            () -> new HoeItem(ModItemTier.COPPER, 0, 0,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.HOE,2)
                            .group(MCCourseMod.COURSE_TAB)));
    public static final RegistryObject<Item> COPPER_AXE = Registration.ITEMS.register( "copper_axe",
            () -> new AxeItem(ModItemTier.COPPER, 2.5f, -3f,
                    new Item.Properties()
                            .defaultMaxDamage(150)
                            .addToolType(ToolType.AXE,2)
                            .group(MCCourseMod.COURSE_TAB)));


    //==========================A R M O R S==============================
    public static final  RegistryObject<Item> COPPER_HELMET = Registration.ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD,
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final  RegistryObject<Item> COPPER_CHESTPLATE = Registration.ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST,
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final  RegistryObject<Item> COPPER_LEGGINGS = Registration.ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS,
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));
    public static final  RegistryObject<Item> COPPER_BOOTS = Registration.ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET,
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));


    //==========================C R O P S==============================
    public static final RegistryObject<Item> ZUCCINI_SEED = Registration.ITEMS.register("zuccini_seed",
            () -> new BlockItem(ModBlocks.ZUCCINI_CROP.get(),
                    new Item.Properties().group(MCCourseMod.COURSE_TAB)));


    //==========================F L U I D S==============================
    public static final RegistryObject<Item> OIL_BUCKET = Registration.ITEMS.register("oil_bucket",
            () -> new BucketItem(ModFluids.OIL_FLUID::get, new Item.Properties().group(MCCourseMod.COURSE_TAB).maxStackSize(1)));


    public static void register() {};

    public enum ModArmorMaterial implements IArmorMaterial {
        COPPER(50, new int[] {2, 7, 5, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())), MCCourseMod.MOD_ID + ":copper", 0, 0.1f);

        private  final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final  Ingredient repariMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        ModArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, Ingredient repariMaterial, String name, float toughness, float knockbackResistance) {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repariMaterial = repariMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repariMaterial;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() { //knockback resistance
            return knockbackResistance;
        }
    }

    public enum ModItemTier implements IItemTier {
        COPPER(2, 150, 2.5f, 0f, 15, Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())));

        private final int harvesLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDammage;
        private final int enchantability;
        private final Ingredient repariMaterial;

        ModItemTier(int harvesLevel, int maxUses, float efficiency, float attackDammage, int enchantability, Ingredient repariMaterial) {
            this.harvesLevel = harvesLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDammage = attackDammage;
            this.enchantability = enchantability;
            this.repariMaterial = repariMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDammage;
        }

        @Override
        public int getHarvestLevel() {
            return harvesLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repariMaterial;
        }
    }
}
