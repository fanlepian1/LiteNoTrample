package cn.fancraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiteNoTrample implements ModInitializer {
    public static final String MOD_ID = "LiteNoTrample";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final GameRules.Key<GameRules.BooleanRule> Farm_Protect = GameRuleRegistry.register("FarmProtect", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
    @Override
    public void onInitialize() {
        LOGGER.info("Mod Enable!");
    }
}
