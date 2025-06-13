package com.baixue415.create_interactive_craft;

import com.baixue415.create_interactive_craft.Block.CreateInteractiveCraftModBlockEntities;
import com.baixue415.create_interactive_craft.Block.CreateInteractiveCraftModBlocks;
import com.baixue415.create_interactive_craft.Block.CreateInteractiveCraftModColorBlock;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CreateInteractiveCraftMod.MODID)
public class CreateInteractiveCraftMod
{
    public static final String MODID = "create_interactive_craft";
    private static final Logger LOGGER = LogUtils.getLogger();


    public CreateInteractiveCraftMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onClientSetup);

        CreateInteractiveCraftModBlocks.register(modEventBus); //注册方块
        CreateInteractiveCraftModBlockEntities.register(modEventBus); //注册方块实体
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        CreateInteractiveCraftModColorBlock.register(event);
    }
}
