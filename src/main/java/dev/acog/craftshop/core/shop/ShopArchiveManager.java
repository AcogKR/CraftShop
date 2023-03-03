package dev.acog.craftshop.core.shop;

import dev.acog.craftshop.core.DataBaseUtils;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

public class ShopArchiveManager {

    public static ShopArchive getShopArchive(String shopName) {
        // 임시 코드
        return DataBaseUtils.shopArchiveMap.get(shopName);
    }

    public static List<String> getKeys() {
        return DataBaseUtils.shopArchiveMap.values().stream().map(a -> a.shopName).collect(Collectors.toList());
    }

}
