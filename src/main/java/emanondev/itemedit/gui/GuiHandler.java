package emanondev.itemedit.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class GuiHandler implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    private static void onOpen(InventoryOpenEvent event) {
        if (!(event.getView().getTopInventory().getHolder(false) instanceof Gui gui))
            return;
        if (!(event.getPlayer() instanceof Player))
            return;

        gui.onOpen(event);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    private static void onClose(InventoryCloseEvent event) {
        if (!(event.getView().getTopInventory().getHolder(false) instanceof Gui gui))
            return;
        if (!(event.getPlayer() instanceof Player))
            return;

        gui.onClose(event);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private static void onClick(InventoryClickEvent event) {
        if (!(event.getView().getTopInventory().getHolder(false) instanceof Gui gui))
            return;
        event.setCancelled(true);
        if (event.getClickedInventory() != null && event.getClickedInventory().equals(event.getView().getTopInventory()))
            if (event.getWhoClicked() instanceof Player)
                gui.onClick(event);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private static void onDrag(InventoryDragEvent event) {
        if (event.getView().getTopInventory().getHolder(false) instanceof Gui gui) {
            event.setCancelled(true);
            gui.onDrag(event);
        }
    }
}