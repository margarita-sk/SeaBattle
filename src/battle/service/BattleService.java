package battle.service;

import battle.entity.BattleDesk;
import battle.entity.Coordinate;
import unit.entity.MilitaryUnit;

import java.util.ArrayList;
import java.util.List;

public interface BattleService {

    public void placeMilitaryUnit(BattleDesk desk, MilitaryUnit unit, List<String> coordinates);

    public void autoPlaceMilitaryUnit(BattleDesk desk, ArrayList<MilitaryUnit> units);

    public void fire(BattleDesk desk, Coordinate coordinate);

}
