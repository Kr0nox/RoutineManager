package ui;

import exceptions.UiException;
import model.routines.Routine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SystemTrayIcon {

    private final SystemTray systemTray;
    private final TrayIcon trayIcon;
    private final PopupMenu popupMenu;
    private final Menu routineMenu;

    public SystemTrayIcon() throws UiException {
        if (!SystemTray.isSupported()) {
            throw new UiException("System tray not found");
        }
        systemTray = SystemTray.getSystemTray();
        // https://www.flaticon.com/premium-icon/routine_2277996
        trayIcon = new TrayIcon(new ImageIcon("../../resources/Icon.png").getImage());
        popupMenu = new PopupMenu("Routine Manager");
        routineMenu = new Menu("Routines");
    }

    public void create() throws UiException {
        routineMenu.add(createPopUpMenuButton("Add", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));

        popupMenu.add(routineMenu);
        popupMenu.addSeparator();
        popupMenu.add(createPopUpMenuButton("Quit", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));

        trayIcon.setPopupMenu(popupMenu);
        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            throw new UiException("AWT: " + e.getMessage());
        }
    }

    private MenuItem createPopUpMenuButton(String label, ActionListener action) {
        MenuItem item = new MenuItem(label);
        item.addActionListener(action);
        return item;
    }

    public void setRoutines(Routine[] routines) {
        for (int i = 0; i < routineMenu.getItemCount() - 1; i++) {
            routineMenu.remove(i);
        }

        for (int i = 0; i < routines.length; i++) {
            routineMenu.insert(new RoutineMenuItem(routines[i].getName(), routines[i]), i);
        }
    }

}
