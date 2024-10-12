package net.stewardhail3433.stew3433mod.recipe.staff_builder;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffBuildingRecipe implements Recipe<RecipeInput> {

    private final ItemStack output;
    private final List<String> pattern;
    private final Map<Character, Ingredient> keyMap;
    private final String group;
    private final int width;
    private final int height;

    public StaffBuildingRecipe(String group, int width, int height, List<String> pattern, Map<Character, Ingredient> keyMap, ItemStack output) {
        this.output = output;
        this.pattern = pattern;
        this.keyMap = keyMap;
        this.group = group;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean matches(RecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        for (int patternY = 0; patternY < height; patternY++) {
            for (int patternX = 0; patternX < width; patternX++) {
                int gridIndex = patternY * 5 + patternX;
                char keyChar = pattern.get(patternY).charAt(patternX);

                if (keyChar == ' ') {
                    continue; // Skip empty slots
                }

                Ingredient ingredient = keyMap.get(keyChar);
                if (!ingredient.test(input.getStackInSlot(gridIndex))) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public ItemStack craft(RecipeInput input, WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width <= 5 && height <= 3;
    }

    @Override
    public ItemStack getResult(WrapperLookup registriesLookup) {
        return output.copy();
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(width * height, Ingredient.EMPTY);

        for (int patternY = 0; patternY < height; patternY++) {
            String row = pattern.get(patternY);

            for (int patternX = 0; patternX < width; patternX++) {
                char keyChar = row.charAt(patternX);
                int index = patternY * width + patternX;
                list.set(index, keyChar == ' ' ? Ingredient.EMPTY : keyMap.get(keyChar));
            }
        }
        return list;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<StaffBuildingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "staff_building";
    }

    public static class Serializer implements RecipeSerializer<StaffBuildingRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "staff_building";

        public static final MapCodec<StaffBuildingRecipe> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
                    Codec.INT.fieldOf("width").forGetter(recipe -> recipe.width),
                    Codec.INT.fieldOf("height").forGetter(recipe -> recipe.height),
                    Codec.STRING.listOf().fieldOf("pattern").forGetter(recipe -> recipe.pattern),
                    Codec.unboundedMap(Codec.STRING.xmap(s -> s.charAt(0), c -> String.valueOf(c)), Ingredient.ALLOW_EMPTY_CODEC).fieldOf("key").forGetter(recipe -> recipe.keyMap),
                    ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(recipe -> recipe.output)
            ).apply(instance, StaffBuildingRecipe::new));

        public static final PacketCodec<RegistryByteBuf, StaffBuildingRecipe> PACKET_CODEC = 
        PacketCodec.ofStatic(Serializer::write, Serializer::read);

        @Override
        public MapCodec<StaffBuildingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, StaffBuildingRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        private static StaffBuildingRecipe read(RegistryByteBuf buf) {
            String group = buf.readString();
            int width = buf.readInt();
            int height = buf.readInt();
            List<String> pattern = buf.readList(PacketByteBuf::readString);
            int mapSize = buf.readVarInt();
            Map<Character, Ingredient> keyMap = new HashMap<>();
            for (int i = 0; i < mapSize; i++) {
                char keyChar = buf.readChar();
                Ingredient ingredient = Ingredient.PACKET_CODEC.decode((RegistryByteBuf) buf);
                keyMap.put(keyChar, ingredient);
            }
            ItemStack output = ItemStack.PACKET_CODEC.decode((RegistryByteBuf) buf);
            return new StaffBuildingRecipe(group, width, height, pattern, keyMap, output);
        }

        private static void write(RegistryByteBuf buf, StaffBuildingRecipe recipe) {
            buf.writeString(recipe.group);
            buf.writeInt(recipe.width);
            buf.writeInt(recipe.height);
            buf.writeVarInt(recipe.pattern.size());
            for (String line : recipe.pattern) {
                buf.writeString(line);
            }

            buf.writeVarInt(recipe.keyMap.size());
            for (Map.Entry<Character, Ingredient> entry : recipe.keyMap.entrySet()) {
                buf.writeChar(entry.getKey());
                Ingredient.PACKET_CODEC.encode(buf, entry.getValue());;
            }
            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
        }
    }
}
