package com.company;

import com.company.characters.Player;
import com.company.locations.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class GameTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);
    //private Player player;

    //@Test
    //public void setupGameMap() {
    //    Game game = new Game();
    //}

    /*cottage have
    * */
    @Test
    public void cangotoCottage(){
        Location currentlocation;
        GameMap gameMap = new GameMap();
        currentState = null;//from start, home
        currentState = successfullygoto("cottage");

    }

    @Test
    public void cangotoHospital() {
        CurrentState currentState;
        currentState = setCurrentNode();
        currentState = successfullygoto("hospital",null);
    }

    @Test
    public void cangotoForest(){

    }

    @Test
    public void cangotoRoad(){

    }
    @Test
    public void cangotoLab(){

    }
    @Test
    public void validmovefromhome(){
        //cottage,forest
    }
    @Test
    public void validmovefromcottage(){
        //forest,hospital
    }
    @Test
    public void validmovefromforest(){
        //hospital,road
    }
    @Test
    public void validmovefromhospital(){
        //road
    }

    @Test
    public void validmovefromroad(){
        //lab
    }

    @Test
    public void canonlycollectHuntingKitatCottage(){
        ResultOutput result;
        result = map.moveUserto("cottage");
        result = successfullygoto(null,result);
    } //other items too



    private Game successfullygoto(String location, Game currentstate){
        Assert.assertEquals(location, currentstate.player.getLocation());
        return currentstate;
    }
}