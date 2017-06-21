package cardcontainer;
import card.Card;

import card.Energy;
import card.Pokemon;
import main.Ability;
import main.Attack;
import main.Requirement;
import main.Retreat;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by luckyfang0601 on 2017-05-23.
 */
public class BenchTest {

    private Bench bench;
    private Retreat retreat;
    private ArrayList<Energy> energyArray;
    private ArrayList<Attack> attacks;

    @Before
    public void beforeEachTest()

    {
        bench = new Bench();
        energyArray= new ArrayList<Energy>(20);
        retreat = new Retreat("fighting",1);
        Ability ability = new Ability("Rain Splash","damage","put 20 damage points on opponent","opponent-active");
       Requirement requirement=new Requirement("general",2);
        ArrayList<Requirement>  requirements = new ArrayList<Requirement>();
        requirements.add(requirement);
        Attack attack = new Attack(requirements,ability);
        attacks = new ArrayList<Attack>();
        attacks.add(attack);
    }

    @Test
    public void addCard() throws Exception {

        Card card1 = new Pokemon("Raichu", 27, "pokemon", 90,energyArray, "stage-one","pikachu",retreat,attacks);
        int size = bench.getNoOfCards();
        if(bench.isFull()) {
            bench.addCard(card1);
            assertEquals(size,bench.getNoOfCards());
        }
        else{
            bench.addCard(card1);
            assertEquals(size+1,bench.getNoOfCards());
        }


    }

    @Test
    public void validate() throws Exception {

        if(bench.getNoOfCards()!=5) {
            assertFalse(bench.validate());
        }

    }


    @Test
    public void isFull() throws Exception {

        Card card1 = new Pokemon("Raichu", 27, "pokemon", 90,energyArray, "basic","",retreat,attacks);
        Card card2 = new Pokemon("Glameow", 22, "pokemon", 60, energyArray, "basic","",retreat,attacks);
        Card card3 = new Pokemon("Pikachu", 60, "pokemon", 60,energyArray, "basic","",retreat,attacks);
        Card card4 = new Pokemon("Shellder", 47, "pokemon", 60, energyArray, "basic","",retreat,attacks);
        Card card5 = new Pokemon("Goldeen", 20, "pokemon", 60, energyArray, "basic","",retreat,attacks);
        bench.addCard(card1);
        bench.addCard(card2);
        bench.addCard(card3);
        bench.addCard(card4);
        assertFalse(bench.isFull());
        bench.addCard(card5);
        assertTrue(bench.isFull());

    }

    @Test
    public void swapCards() throws Exception {

        Card card1 = new Pokemon("Shellder", 47, "pokemon", 60, energyArray, "basic","",retreat,attacks);
        Card card2 = new Pokemon("Glameow", 22, "pokemon", 60, energyArray, "basic","",retreat,attacks);
        Card card3 = new Pokemon("Pikachu", 60, "pokemon", 60, energyArray, "basic","",retreat,attacks);
        bench.addCard(card1);
        bench.addCard(card2);
        bench.swapCards(card3,1);
        assertEquals(1,bench.getCardIdx(card3));
    }

}