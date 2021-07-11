package battle.controller;

import battle.entity.BattleDesk;
import unit.entity.Ship;
import battle.service.BattleService;
import battle.service.SeaBattleService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var desk1 = new BattleDesk(5, 5);
        desk1.viewDesk();

        var ship1 = new Ship("Santa Maria", new int[2]);
        var ship2 = new Ship("The Flying Dutchman", new int[3]);
        var ship3 = new Ship("Titanic", new int[1]);

        BattleService service = new SeaBattleService();
        service.placeMilitaryUnit(desk1, ship1, List.of("A1", "A2"));
        service.placeMilitaryUnit(desk1, ship2, List.of("C3", "D3", "E3"));

        //exception cases: the cell is not free, the cell is a ship neighbor, wrong coordinates
//        service.placeMilitaryUnit(desk1, ship3, List.of("C3"));
//        service.placeMilitaryUnit(desk1, ship3, List.of("A3"));
//        service.placeMilitaryUnit(desk1, ship3, List.of("A-1"));

        desk1.viewDesk();

    }
}
