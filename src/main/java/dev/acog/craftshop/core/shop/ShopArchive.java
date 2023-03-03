package dev.acog.craftshop.core.shop;

import lombok.Data;
import lombok.With;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

@With
@Data(staticConstructor = "of")
public class ShopArchive implements ConfigurationSerializable {

    public final String shopName;


    @NotNull
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("shopName", shopName);
        return result;
    }

    public static ShopItem deserialize(Map<String, Object> map) {
        return null;
    }
}
