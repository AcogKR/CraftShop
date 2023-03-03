package dev.acog.craftshop.core.shop;

import lombok.Data;
import lombok.With;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

@With
@Data(staticConstructor = "of")
public class ShopItem implements ConfigurationSerializable {

    public final Integer slot;
    public final String saleType;
    public final Long price;
    public final ItemStack item;

    @NotNull
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("slot", slot);
        result.put("price", price);
        result.put("item", item);
        return result;
    }

    public static ShopItem deserialize(Map<String, Object> map) {
        return null;
    }
}


/*

아이템 -> 돈에 맞는지 하고서 거래
아이템 ->
 */