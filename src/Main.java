import exceptions.UiException;
import ui.SystemTrayIcon;

public final class Main {

    public static void main(String[] args) {
        try {
            new SystemTrayIcon().create();
        } catch (UiException e) {
            System.err.println(e.getMessage());
        }
    }

}
