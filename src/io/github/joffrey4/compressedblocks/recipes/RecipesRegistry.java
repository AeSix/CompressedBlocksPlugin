package io.github.joffrey4.compressedblocks.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import io.github.joffrey4.compressedblocks.blocks.BlockRegistry;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.material.MaterialData;

public class RecipesRegistry {

    // Wood Recipes declaration
    public static ShapedRecipe oakCompressing;
    public static ShapelessRecipe oakUncompressing;

    public static ShapedRecipe spruceCompressing;
    public static ShapelessRecipe spruceUncompressing;

    public static ShapedRecipe birchCompressing;
    public static ShapelessRecipe birchUncompressing;

    public static ShapedRecipe jungleCompressing;
    public static ShapelessRecipe jungleUncompressing;

    public static ShapedRecipe acaciaCompressing;
    public static ShapelessRecipe acaciaUncompressing;

    public static ShapedRecipe darkOakCompressing;
    public static ShapelessRecipe darkOakUncompressing;

    // Planks Recipes declaration
    public static ShapedRecipe oakPlankCompressing;
    public static ShapelessRecipe oakPlankUncompressing;

    public static ShapedRecipe sprucePlankCompressing;
    public static ShapelessRecipe sprucePlankUncompressing;

    public static ShapedRecipe birchPlankCompressing;
    public static ShapelessRecipe birchPlankUncompressing;

    public static ShapedRecipe junglePlankCompressing;
    public static ShapelessRecipe junglePlankUncompressing;

    public static ShapedRecipe acaciaPlankCompressing;
    public static ShapelessRecipe acaciaPlankUncompressing;

    public static ShapedRecipe darkOakPlankCompressing;
    public static ShapelessRecipe darkOakPlankUncompressing;

    // Gravel Recipes declaration
    public static ShapedRecipe gravelCompressing;
    public static ShapelessRecipe gravelUncompressing;

    // Sand Recipes declaration
    public static ShapedRecipe sandCompressing;
    public static ShapelessRecipe sandUncompressing;

    public static ShapedRecipe redSandCompressing;
    public static ShapelessRecipe redSandUncompressing;

    // Stone Recipes declaration
    public static ShapedRecipe stoneCompressing;
    public static ShapelessRecipe stoneUncompressing;

    // Granite Recipes declaration
    public static ShapedRecipe graniteCompressing;
    public static ShapelessRecipe graniteUncompressing;

    // Diorite Recipes declaration
    public static ShapedRecipe dioriteCompressing;
    public static ShapelessRecipe dioriteUncompressing;

    // Andesite Recipes declaration
    public static ShapedRecipe andesiteCompressing;
    public static ShapelessRecipe andesiteUncompressing;

    // Dirt Recipes declaration
    public static ShapedRecipe dirtCompressing;
    public static ShapelessRecipe dirtUncompressing;

    // Cobblestone Recipes declaration
    public static ShapedRecipe cobblestoneCompressing;
    public static ShapelessRecipe cobblestoneUncompressing;

    // Soul Sand Recipes declaration
    public static ShapedRecipe soulSandCompressing;
    public static ShapelessRecipe soulSandUncompressing;

    // Netherrack Recipes declaration
    public static ShapedRecipe netherrackCompressing;
    public static ShapelessRecipe netherrackUncompressing;

    public static void init(FileConfiguration config) {
        Server server = Bukkit.getServer();

        /*************************************************************************************************
         * Compressed WOODS - Recipes                                                                    *
         *************************************************************************************************/

        // Wood compressing
        if (config.getBoolean("Wood.Compressing")) {
            server.addRecipe(oakCompressing = Compressing(BlockRegistry.compressedOak, Material.LOG, 0));
            server.addRecipe(spruceCompressing = Compressing(BlockRegistry.compressedSpruce, Material.LOG, 1));
            server.addRecipe(birchCompressing = Compressing(BlockRegistry.compressedBirch, Material.LOG, 2));
            server.addRecipe(jungleCompressing = Compressing(BlockRegistry.compressedJungle, Material.LOG, 3));
            server.addRecipe(acaciaCompressing = Compressing(BlockRegistry.compressedAcacia, Material.LOG_2, 0));
            server.addRecipe(darkOakCompressing = Compressing(BlockRegistry.compressedDarkOak, Material.LOG_2, 1));
        }

        // Wood uncompressing
        if (config.getBoolean("Wood.Uncompressing")) {
            server.addRecipe(oakUncompressing = UnCompressing(new ItemStack(Material.LOG, 9, (short) 0), BlockRegistry.compressedOak.getData()));
            server.addRecipe(spruceUncompressing = UnCompressing(new ItemStack(Material.LOG, 9, (short) 1), BlockRegistry.compressedSpruce.getData()));
            server.addRecipe(birchUncompressing = UnCompressing(new ItemStack(Material.LOG, 9, (short) 2), BlockRegistry.compressedBirch.getData()));
            server.addRecipe(jungleUncompressing = UnCompressing(new ItemStack(Material.LOG, 9, (short) 3), BlockRegistry.compressedJungle.getData()));
            server.addRecipe(acaciaUncompressing = UnCompressing(new ItemStack(Material.LOG_2, 9, (short) 0), BlockRegistry.compressedAcacia.getData()));
            server.addRecipe(darkOakUncompressing = UnCompressing(new ItemStack(Material.LOG_2, 9, (short) 1), BlockRegistry.compressedDarkOak.getData()));
        }

        /*************************************************************************************************
         * Compressed PLANKS - Recipes                                                                   *
         *************************************************************************************************/

        // Planks compressing
        if (config.getBoolean("Planks.Compressing")) {
            server.addRecipe(oakPlankCompressing = Compressing(BlockRegistry.compressedOakPlank, Material.WOOD, 0));
            server.addRecipe(sprucePlankCompressing = Compressing(BlockRegistry.compressedSprucePlank, Material.WOOD, 1));
            server.addRecipe(birchPlankCompressing = Compressing(BlockRegistry.compressedBirchPlank, Material.WOOD, 2));
            server.addRecipe(junglePlankCompressing = Compressing(BlockRegistry.compressedJunglePlank, Material.WOOD, 3));
            server.addRecipe(acaciaPlankCompressing = Compressing(BlockRegistry.compressedAcaciaPlank, Material.WOOD, 4));
            server.addRecipe(darkOakPlankCompressing = Compressing(BlockRegistry.compressedDarkOakPlank, Material.WOOD, 5));
        }

        // Planks uncompressing
        if (config.getBoolean("Planks.Uncompressing")) {
            server.addRecipe(oakPlankUncompressing = UnCompressing(new ItemStack(Material.WOOD, 9, (short) 0), BlockRegistry.compressedOakPlank.getData()));
            server.addRecipe(sprucePlankUncompressing = UnCompressing(new ItemStack(Material.WOOD, 9, (short) 1), BlockRegistry.compressedSprucePlank.getData()));
            server.addRecipe(birchPlankUncompressing = UnCompressing(new ItemStack(Material.WOOD, 9, (short) 2), BlockRegistry.compressedBirchPlank.getData()));
            server.addRecipe(junglePlankUncompressing = UnCompressing(new ItemStack(Material.WOOD, 9, (short) 3), BlockRegistry.compressedJunglePlank.getData()));
            server.addRecipe(acaciaPlankUncompressing = UnCompressing(new ItemStack(Material.WOOD, 9, (short) 4), BlockRegistry.compressedAcaciaPlank.getData()));
            server.addRecipe(darkOakPlankUncompressing = UnCompressing(new ItemStack(Material.WOOD, 9, (short) 5), BlockRegistry.compressedDarkOakPlank.getData()));
        }

        /*************************************************************************************************
         * Compressed FALLING Blocks - Recipes                                                           *
         *************************************************************************************************/

        // Gravel compressing and uncompressing
        if (config.getBoolean("Gravel.Compressing")) {
            server.addRecipe(gravelCompressing = Compressing(BlockRegistry.compressedGravel, Material.GRAVEL, 0));
        }
        if (config.getBoolean("Gravel.Uncompressing")) {
            server.addRecipe(gravelUncompressing = UnCompressing(new ItemStack(Material.GRAVEL, 9), BlockRegistry.compressedGravel.getData()));
        }

        // Sands compressing and uncompressing
        if (config.getBoolean("Sand.Compressing")) {
            server.addRecipe(sandCompressing = Compressing(BlockRegistry.compressedSand, Material.SAND, 0));
            server.addRecipe(redSandCompressing = Compressing(BlockRegistry.compressedRedSand, Material.SAND, 1));
        }
        if (config.getBoolean("Sand.Uncompressing")) {
            server.addRecipe(sandUncompressing = UnCompressing(new ItemStack(Material.SAND, 9, (short) 0), BlockRegistry.compressedSand.getData()));
            server.addRecipe(redSandUncompressing = UnCompressing(new ItemStack(Material.SAND, 9, (short) 1), BlockRegistry.compressedRedSand.getData()));
        }

        /*************************************************************************************************
         * Compressed STONE Blocks - Recipes                                                             *
         *************************************************************************************************/

        // Stone compressing and uncompressing
        if (config.getBoolean("Stone.Compressing")) {
            server.addRecipe(stoneCompressing = Compressing(BlockRegistry.compressedStone, Material.STONE, 0));
        }
        if (config.getBoolean("Stone.Uncompressing")) {
            server.addRecipe(stoneUncompressing = UnCompressing(new ItemStack(Material.STONE, 9, (short) 0), BlockRegistry.compressedStone.getData()));
        }

        // Granite compressing and uncompressing
        if (config.getBoolean("Granite.Compressing")) {
            server.addRecipe(graniteCompressing = Compressing(BlockRegistry.compressedGranite, Material.STONE, 1));
        }
        if (config.getBoolean("Granite.Uncompressing")) {
            server.addRecipe(graniteUncompressing = UnCompressing(new ItemStack(Material.STONE, 9, (short) 1), BlockRegistry.compressedGranite.getData()));
        }

        // Diorite compressing and uncompressing
        if (config.getBoolean("Diorite.Compressing")) {
            server.addRecipe(dioriteCompressing = Compressing(BlockRegistry.compressedDiorite, Material.STONE, 3));
        }
        if (config.getBoolean("Diorite.Uncompressing")) {
            server.addRecipe(dioriteUncompressing = UnCompressing(new ItemStack(Material.STONE, 9, (short) 3), BlockRegistry.compressedDiorite.getData()));
        }

        // Andesite compressing and uncompressing
        if (config.getBoolean("Andesite.Compressing")) {
            server.addRecipe(andesiteCompressing = Compressing(BlockRegistry.compressedAndesite, Material.STONE, 5));
        }
        if (config.getBoolean("Andesite.Uncompressing")) {
            server.addRecipe(andesiteUncompressing = UnCompressing(new ItemStack(Material.STONE, 9, (short) 5), BlockRegistry.compressedAndesite.getData()));
        }

        /*************************************************************************************************
         * Compressed OTHER Blocks - Recipes                                                             *
         *************************************************************************************************/

        // Dirt compressing and uncompressing
        if (config.getBoolean("Dirt.Compressing")) {
            server.addRecipe(dirtCompressing = Compressing(BlockRegistry.compressedDirt, Material.DIRT, 0));
        }
        if (config.getBoolean("Dirt.Uncompressing")) {
            server.addRecipe(dirtUncompressing = UnCompressing(new ItemStack(Material.DIRT, 9), BlockRegistry.compressedDirt.getData()));
        }

        // Cobblestone compressing and uncompressing
        if (config.getBoolean("Cobblestone.Compressing")) {
            server.addRecipe(cobblestoneCompressing = Compressing(BlockRegistry.compressedCobblestone, Material.COBBLESTONE, 0));
        }
        if (config.getBoolean("Cobblestone.Uncompressing")) {
            server.addRecipe(cobblestoneUncompressing = UnCompressing(new ItemStack(Material.COBBLESTONE, 9), BlockRegistry.compressedCobblestone.getData()));
        }

        // Soul Sand compressing and uncompressing
        if (config.getBoolean("SoulSand.Compressing")) {
            server.addRecipe(soulSandCompressing = Compressing(BlockRegistry.compressedSoulSand, Material.SOUL_SAND, 0));
        }
        if (config.getBoolean("SoulSand.Uncompressing")) {
            server.addRecipe(soulSandUncompressing = UnCompressing(new ItemStack(Material.SOUL_SAND, 9), BlockRegistry.compressedSoulSand.getData()));
        }

        // Netherrack compressing and uncompressing
        if (config.getBoolean("Netherrack.Compressing")) {
            server.addRecipe(netherrackCompressing = Compressing(BlockRegistry.compressedNetherrack, Material.NETHERRACK, 0));
        }
        if (config.getBoolean("Netherrack.Uncompressing")) {
            server.addRecipe(netherrackUncompressing = UnCompressing(new ItemStack(Material.NETHERRACK, 9), BlockRegistry.compressedNetherrack.getData()));
        }

    }

    private static ShapedRecipe Compressing(ItemStack itemResult, Material ingredient, int meta) {
        ShapedRecipe shapedRecipe = new ShapedRecipe(itemResult);
        shapedRecipe.shape("III", "III", "III");
        shapedRecipe.setIngredient('I', ingredient, meta);
        return shapedRecipe;
    }

    private static ShapelessRecipe UnCompressing(ItemStack itemResult, MaterialData ingredient) {
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(itemResult);
        shapelessRecipe.addIngredient(ingredient);
        return shapelessRecipe;
    }
}
