package dev.acog.craftshop.core.shop;

import io.typecraft.command.Argument;
import io.vavr.control.Try;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ShopArgument {

    public static Argument<ShopArchive> shopArg =
            Argument.ofUnary(
                    "shopArchive",
                    s -> Try.of(() -> ShopArchiveManager.getShopArchive(s)).toJavaOptional(),
                    ShopArchiveManager::getKeys
            );

    public static Argument<ShopType> shopTypeArg =
            Argument.ofUnary(
                    "shopType",
                    s -> Try.of(() -> ShopType.valueOf(s)).toJavaOptional(),
                    () -> Arrays.stream(ShopType.values()).map(Enum::toString).collect(Collectors.toList())
            );

    public static Argument<ShopButtonType> buttonTypeArg =
            Argument.ofUnary(
                    "shopButton",
                    s -> Try.of(() -> ShopButtonType.valueOf(s)).toJavaOptional(),
                    () -> Arrays.stream(ShopButtonType.values()).map(Enum::toString).collect(Collectors.toList())
            );
}

