package battle.service;

import battle.entity.Coordinate;
import battle.entity.BattleDesk;
import unit.entity.MilitaryUnit;
import unit.exception.UnitPlacementException;
import battle.exception.WrongCoordinateException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeaBattleService implements BattleService {

    @Override
    public void placeMilitaryUnit(BattleDesk desk, MilitaryUnit unit, List<String> textCoordinates) {
        var coordinates = mapTextIntoCoordinates(desk, textCoordinates);
        checkCoordinates(desk, coordinates);
        shipSizeMatchesCoordinates(unit, coordinates);

        var cellsAvailable = coordinates.stream().allMatch(coordinate -> desk.cellIsAvailable(coordinate));
        if (cellsAvailable) {
            coordinates.forEach(coordinate -> desk.changeCellStatus(coordinate, unit));
        } else {
            throw new UnitPlacementException(unit.getName());
        }
    }

    @Override
    public void autoPlaceMilitaryUnit(BattleDesk desk, ArrayList<MilitaryUnit> units) {
        // TODO
    }

    @Override
    public void fire(BattleDesk desk, Coordinate coordinate) {
        // TODO
    }

    private void shipSizeMatchesCoordinates(MilitaryUnit unit, List<Coordinate> unitCoordinates) {
        var shipSize = unit.getСellState().length;
        if (unitCoordinates.size() != shipSize) {
            throw new UnitPlacementException(unit.getName());
        }
    }

    private void checkCoordinates(BattleDesk desk, List<Coordinate> coordinates) {
        var hasWrongCoordinates = coordinates.stream().anyMatch(coordinate -> (coordinate.getHorizontal() >= desk.getHorizontalSize()
                || coordinate.getVertical() >= desk.getVerticalSize()));
        if (hasWrongCoordinates) {
            throw new WrongCoordinateException(coordinates.toString());
        }
    }

    private List<Coordinate> mapTextIntoCoordinates(BattleDesk desk, List<String> textCoordinates) {
        int charStartNumber = 'A';
        return textCoordinates.stream().map(textCoordinate -> {
                    var horizontal = textCoordinate.toUpperCase().toCharArray()[0] - charStartNumber;
                    var vertical = desk.getVerticalSize() - Integer.parseInt(textCoordinate.substring(1));
                    return new Coordinate(horizontal, vertical);
                }
        ).collect(Collectors.toList());
    }

}
