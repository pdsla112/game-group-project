package comp2100.groupass;

import comp2100.groupass.entities.Player;
import comp2100.groupass.parser.Parser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class GameTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Test
    public void inputTestCase1() {
        Player player = new Player("a",1,"home");
        Game game = new Game(player);
        Parser parser = new Parser(player);
        String input = Parser.getInputString();


    }

    /*cottage have
    * */
    /*@Test
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
    }*/
}