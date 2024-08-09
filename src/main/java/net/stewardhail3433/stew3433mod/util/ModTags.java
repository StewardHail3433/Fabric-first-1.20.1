package net.stewardhail3433.stew3433mod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.stewardhail3433.stew3433mod.Stew3433Mod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_ZORIUM_TOOL = createTag("incorrect_for_zorium_tool");
        public static final TagKey<Block> TAWIN_LOGS = createTag("tawin_logs");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Stew3433Mod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> TAWIN_LOGS = createTag("tawin_logs");
        
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Stew3433Mod.MOD_ID, name));
        }
    }

}
