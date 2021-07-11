package battle.entity;

import java.util.Objects;

public class Coordinate {

    private int horizontal;

    private int vertical;

    public Coordinate(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return this.horizontal;
    }

    public int getVertical() {
        return this.vertical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return horizontal == that.horizontal && vertical == that.vertical;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontal, vertical);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "horizontal=" + horizontal +
                ", vertical=" + vertical +
                '}';
    }
}
