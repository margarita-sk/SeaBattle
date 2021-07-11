package battle.entity;

import unit.entity.MilitaryUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BattleDesk {

    private int horizontalSize;

    private int verticalSize;

    private Map<Coordinate, MilitaryUnit> cellStates;

    private ArrayList<MilitaryUnit> units;

    public BattleDesk(int horizontalSize, int verticalSize) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;

        cellStates = new HashMap<>();
        for (int vertical = 0; vertical < verticalSize - 1; vertical++) {
            for (int horizontal = 0; horizontal < horizontalSize - 1; horizontal++) {
                cellStates.put(new Coordinate(horizontal, vertical), null);
            }
        }
    }

    public boolean cellIsAvailable(Coordinate cellCoordinate) {
        if (cellStates.get(cellCoordinate) != null)
            return false;

        var cellAbove = new Coordinate(cellCoordinate.getHorizontal(), cellCoordinate.getVertical() - 1);
        var cellBelow = new Coordinate(cellCoordinate.getHorizontal(), cellCoordinate.getVertical() + 1);
        var cellLeft = new Coordinate(cellCoordinate.getHorizontal() - 1, cellCoordinate.getVertical());
        var cellRight = new Coordinate(cellCoordinate.getHorizontal() + 1, cellCoordinate.getVertical());

        if (cellStates.get(cellAbove) != null || cellStates.get(cellBelow) != null
                || cellStates.get(cellLeft) != null || cellStates.get(cellRight) != null) {
            return false;
        }
        return true;
    }

    public void changeCellStatus(Coordinate cellCoordintate, MilitaryUnit unit) {
        this.cellStates.put(cellCoordintate, unit);
    }

    public void viewDesk() {
        System.out.println("-----------------------");
        for (int vertical = 0; vertical < verticalSize; vertical++) {
            System.out.print(verticalSize - vertical + "|");
            for (int horizontal = 0; horizontal < horizontalSize; horizontal++) {
                var currentCoordinate = new Coordinate(horizontal, vertical);
                if (this.cellStates.get(currentCoordinate) == null)
                    System.out.print(" " + 0);
                else System.out.print(" " + 1);
            }
            System.out.println();
        }
        System.out.print("---");
        for (int i = 0; i < horizontalSize; i++) {
                int point = 'A' + i;
            System.out.print(Character.toString(point) + "-");
        }
        System.out.println();
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public int getVerticalSize() {
        return verticalSize;
    }
}
