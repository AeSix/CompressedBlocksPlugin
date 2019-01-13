package io.github.joffrey4.compressedblocks.block;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import io.github.joffrey4.compressedblocks.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.UUID;

public class BlockCompressed {

    private static Material material;
    private static String displayname;
    private static String name;
    private static String typeName;
    private static FileConfiguration config;

    public BlockCompressed(Material material, String typeName, Main plugin) {
        BlockCompressed.config = plugin.getConfig();
        BlockCompressed.material = material;

        // Internal name of the compressed block (ex: oakwood)
        BlockCompressed.name = setName(typeName);

        // Name of the compressed block item (ex: Compressed Oak Wood)
        BlockCompressed.displayname = setDisplayName(typeName);

        // Name of the type of the block (ex: Oak Wood)
        BlockCompressed.typeName = typeName;
    }

    private String setName(String name) {
        return name.replaceAll("\\s+","").toLowerCase();
    }

    private String setDisplayName(String typeName) {
        String displayName;

        if (Objects.equals(config.getString(name + ".name"), "default")) {
            displayName = config.getString("default.name");
        } else {
            displayName = config.getString(name + ".name");
        }

        if (displayName.contains("&type")) {
            displayName = displayName.replace("&type", typeName);
        }

        return ChatColor.translateAlternateColorCodes('&', displayName);
    }

    public ItemStack getItemStack() {

        // Get the skin image and initialize an itemStack (skull)
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);

        String skinURL = "http://textures.minecraft.net/texture/";
        if (config.getString(name + ".texture").isEmpty()) {
            return skull;
        } else {
            skinURL += config.getString(name + ".texture");
        }

        // Get the skull metadata and initialize a texture profile
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.fromString("069a79f4-44e9-4726-a5be-fca90e38aaf5"), null);
        profile.getProperties().put("textures", new Property("textures", Base64Coder.encodeString("{textures:{SKIN:{url:\"" + skinURL + "\"}}}")));
        profile.getProperties().put("compBlocksName", new Property("compBlocksName", name));

        // Set the texture profile to the skull metadata
        Field profileField;
        try {
            profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Save the metadata on the skull and return it
        skull.setItemMeta(skullMeta);
        return skull;
    }

    public String getDisplayName() {
        return displayname;
    }

    public List<String> getLore() {
        List<String> lore;

        if (Objects.equals(config.getString(name + ".lore"), "default")) {
            lore = config.getStringList("default.lore");
        } else {
            lore = config.getStringList(name + ".lore");
        }

        for (final ListIterator<String> i = lore.listIterator(); i.hasNext();) {
            String line = i.next();

            if (line.contains("&type")) {
                line = line.replace("&type", typeName);
            }
            i.set(ChatColor.translateAlternateColorCodes('&', line));
        }
        return lore;
    }
}
