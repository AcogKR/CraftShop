package dev.acog.craftshop.bukkit.command;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import dev.acog.craftshop.CraftShop;
import dev.acog.craftshop.core.shop.ShopArchive;
import dev.acog.craftshop.core.shop.ShopButtonType;
import dev.acog.craftshop.core.shop.ShopType;
import io.typecraft.command.Command;
import lombok.Data;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

import static dev.acog.craftshop.core.shop.ShopArgument.*;
import static io.typecraft.command.Command.pair;
import static io.typecraft.command.StandardArguments.*;

public interface CraftShopCommand {

    CraftShop plugin = JavaPlugin.getPlugin(CraftShop.class);
    Command<CraftShopCommand> node =
            Command.mapping(
                    pair("create", Command.argument(ShopCreate::new, strArg, shopTypeArg, intArg)),
                    pair("delete", Command.argument(ShopDelete::new, shopArg)),
                    pair("edit", Command.mapping(
                            pair("title", Command.argument(ShopEditTitle::new, shopArg, strArg)),
                            pair("button", Command.argument(ShopEditButton::new, shopArg, buttonTypeArg))
                    )),
                    pair("item", Command.mapping(
                            pair("add", Command.mapping(
                                    pair("trade", Command.argument(ShopItemTradeAdd::new, shopArg, intArg)),
                                    pair("buy", Command.argument(ShopItemBuyAdd::new, shopArg, intArg, longArg))
                            )),
                            pair("edit", Command.mapping(
                                    pair("trade", Command.argument(ShopItemTradeEdit::new, shopArg, intArg)),
                                    pair("buy", Command.argument(ShopItemBuyEdit::new, shopArg, intArg, longArg))
                            )),
                            pair("remove", Command.argument(ShopItemRemove::new, shopArg, intArg))
                    ))
            );

    // /shop item add test [TRADE or BUY]
    @Data
    class ShopCreate implements CraftShopCommand {
        private final String shopName;
        private final ShopType type;
        private final Integer row;
    }

    @Data
    class ShopDelete implements CraftShopCommand {
        private final ShopArchive archive;
    }

    @Data
    class ShopEditTitle implements CraftShopCommand {
        private final ShopArchive archive;
        private final String title;
    }

    @Data
    class ShopEditButton implements CraftShopCommand {
        private final ShopArchive archive;
        private final ShopButtonType buttonType;
    }

    @Data
    class ShopItemTradeAdd implements CraftShopCommand {
        private final ShopArchive archive;
        private final Integer slot;
    }

    @Data
    class ShopItemBuyAdd implements CraftShopCommand {
        private final ShopArchive archive;
        private final Integer slot;
        private final Long price;
    }

    @Data
    class ShopItemRemove implements CraftShopCommand {
        private final ShopArchive archive;
        private final Integer slot;
    }

    @Data
    class ShopItemTradeEdit implements CraftShopCommand {
        private final ShopArchive archive;
        private final Integer slot;
    }

    @Data
    class ShopItemBuyEdit implements CraftShopCommand {
        private final ShopArchive archive;
        private final Integer slot;
        private final Long price;
    }


    static void execute(CommandSender sender, CraftShopCommand command) {
        Player player = sender instanceof Player ? (Player) sender : null;
        if (player == null) {
            return;
        }

        try {
            PacketContainer container = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.OPEN_WINDOW);
            container.getIntegers().write(0, 0);
            container.getStrings().write(0, "https://github.com/Acogkr");
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, container);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}


