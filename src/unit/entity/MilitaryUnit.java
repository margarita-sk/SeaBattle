package unit.entity;

public class MilitaryUnit {

    private String name;

    private int[] сellState;

    public MilitaryUnit(String name, int[] сellState) {
        this.name = name;
       this.сellState = сellState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getСellState() {
        return сellState;
    }

    public void setСellState(int[] сellState) {
        this.сellState = сellState;
    }
}
