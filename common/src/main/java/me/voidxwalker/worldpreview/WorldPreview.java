package me.voidxwalker.worldpreview;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class WorldPreview {
   public static World world;
   public static ClientPlayerEntity player;
   public static ClientWorld clientWord;
   public static boolean inPreview;
   public static BlockPos spawnPos;
   public static int kill=0;
   public static int playerSpawn;
   public static Camera camera;
   public static WorldRenderer worldRenderer;
   public static boolean existingWorld;
   public static boolean showMenu;
   public static boolean calculatedSpawn;
   public static KeyBinding resetKey;
   public static KeyBinding freezeKey;
   public static KeyBinding cycleChunkMapKey;
   public static int chunkMapPos;
   public static boolean freezePreview;
   public static final Object lock= new Object();
   public static Logger LOGGER = LogManager.getLogger();
   public static final String MOD_ID = "worldpreview";

   public static void log(Level level, String message) {
      LOGGER.log(level, message);
   }

   public static void init() {
      resetKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
              translate("key.world_preview.reset","Leave Preview").getString(),
              InputUtil.Type.KEYSYM,
              GLFW.GLFW_KEY_H,
              translate("key.categories.world_preview","World Preview").getString()
      ));

      freezeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
              translate("key.world_preview.freeze","Freeze Preview").getString(),
              InputUtil.Type.KEYSYM,
              GLFW.GLFW_KEY_J,
              translate("key.categories.world_preview","World Preview").getString()
      ));
      cycleChunkMapKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
              translate("key.world_preview.cycle_chunkmap","Cycle ChunkMap Positions").getString(),
              InputUtil.Type.KEYSYM,
              GLFW.GLFW_KEY_K,
              translate("key.categories.world_preview","World Preview").getString()

      ));
   }
   private static Text translate(String key, String replacement ){
      Text t = Text.translatable(key);
      if(t.getString().equals(key)){
         return Text.of(replacement);
      }
      return t;
   }

}
