package ui;

import model.routines.Routine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoutineMenuItem extends MenuItem {

    private final String label;
    private final Routine routine;

    public RoutineMenuItem(String label, Routine routine) {
        this.label = label;
        this.routine = routine;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditRoutineWindow(routine);
            }
        });
    }

}
