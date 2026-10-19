package com.enderdevelopment.mythickatana;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mythickatana")
public class MythicKatanaMod {
    public MythicKatanaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MythicKatana.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}