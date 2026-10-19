package com.example.mythickatana;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MythicKatanaMod implements ModInitializer {
    public static final String MOD_ID = "mythic_katana";
    public static final Item MYTHIC_KATANA = new MythicKatanaItem(new Item.Settings().maxCount(1));

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "mythic_katana"), MYTHIC_KATANA);
    }
}