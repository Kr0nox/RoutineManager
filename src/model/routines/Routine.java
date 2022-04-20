package model.routines;

public abstract class Routine {

    private final String name;

    protected Routine(String name) {
        this.name = name;
    }

    public abstract void execute();

    public String getName() {
        return name;
    }

}
