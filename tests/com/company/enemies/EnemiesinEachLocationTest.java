package com.company.enemies;

import com.company.Game;
import com.company.characters.Player;
import com.company.locations.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;


public class EnemiesinEachLocationTest {
    private Location location;
    private Enemy enemies;

    @Before
    public void setUp(){
        Player p = new Player("name",1,"home");
        Location location = Game.map.getLocationFromName(p.getLocationName());
        String title = "At the edge of a forest";
        String description = "The are many big trees and some tick busses, " +
                "looks difficult to go through.";
        LocationType locationType = LocationType.FOREST;
        location = new Location(coordinate, title, description, locationType);
        location.setDangerRating(5);

        factory = new MonsterFactory();
    }
    @Test
    public void enemiesinForestTest() {
        locations.setLocationType(LocationType.FOREST);
        player.setLocation(location);
        Monster forestMonster = factory.generateMonster(player);
        assertTrue(forestMonster instanceof Troll ||
                forestMonster instanceof Bugbear ||
                forestMonster instanceof Goblin);
    }

}
