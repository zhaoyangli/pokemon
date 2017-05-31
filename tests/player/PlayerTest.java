package player;

import card.Card;
import card.Energy;
import card.Pokemon;
import cardcontainer.Bench;
import cardcontainer.Deck;
import cardcontainer.DiscardPile;
import cardcontainer.Hand;
import main.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by luckyfang0601 on 2017-05-23.
 */
public class PlayerTest {

   private static final int PRIZE_CARD_LIMIT = 6;
    private Player player;
    private ArrayList<Energy> energyArray;
    private Coin playerCoin;
    private Retreat retreat;
    private ArrayList<Attack> attacks;
    private Deck newDeck;
    private Hand newHand;



    @Before
    public void beforeEachTest(){

        player = new Player();
        energyArray= new ArrayList<Energy>(20);
        retreat = new Retreat("fighting",1);
        Ability ability = new Ability("Rain Splash","damage","put 20 damage points on opponent","opponent-active");
        Requirement requirement=new Requirement("general",2);
        ArrayList<Requirement> requirements = new ArrayList<Requirement>();
        requirements.add(requirement);

        Attack attack = new Attack(requirements,ability);
        ArrayList<Attack> attacks = new ArrayList<Attack>();
        attacks.add(attack);
    }
    @Test
    public void flipCoin() throws Exception {
        playerCoin = new Coin();
        playerCoin.flip();
        if(playerCoin.isHead()==true)
            assertTrue(playerCoin.isHead());

    }
    @Test
    public void putPokOnBench() throws Exception {


        Pokemon card1 = new Pokemon("Raichu", 27, "pokemon", 90,energyArray, "stage-one","pikachu",retreat,attacks);
        player.putPokOnBench(card1);
        assertEquals(1,player.getBench().getNoOfCards());
    }
    @Test
    public void shuffleDeck() throws Exception {
        newDeck = new Deck();
        newDeck.populateDeck("C:\\Users\\luckyfang0601\\Documents\\SCHOOL\\comp354\\project\\pokemon\\res\\deck\\deck1.txt");
        player.setDeck(newDeck);
       // player.shuffleDeck();
        assertEquals(60,player.getDeck().getNoOfCards());


    }

    @Test
    public void drawCard() throws Exception {
        newDeck = new Deck();
        newDeck.populateDeck("C:\\Users\\luckyfang0601\\Documents\\SCHOOL\\comp354\\project\\pokemon\\res\\deck\\deck1.txt");
        player.setDeck(newDeck);
        player.drawCard();
        assertEquals(59,player.getDeck().getNoOfCards());
        assertEquals(1,player.getHand().getNoOfCards());

    }
    @Test
    public void discardCard() throws Exception {
        newDeck = new Deck();
        newDeck.populateDeck("C:\\Users\\luckyfang0601\\Documents\\SCHOOL\\comp354\\project\\pokemon\\res\\deck\\deck1.txt");
        player.setDeck(newDeck);
        player.drawCard();
        assertEquals(1,player.getHand().getNoOfCards());
        String testString ="Jirachi:pokemon:cat:basic:cat:psychic:70:retreat:cat:colorless:1:attacks:cat:psychic:1:39,cat:colorless:2,cat:psychic:1:40";
        String[] item = new String[1];
        item[0]=testString;
        CardsFileParser cardsFile = new CardsFileParser(item);

       // assertEquals(0,player.getHand().getNoOfCards());


    }

    @Test
    public void hasActivePokemon() throws Exception {

        Pokemon card1 = new Pokemon("Raichu", 27, "pokemon", 90,energyArray, "stage-one","pikachu",retreat,attacks);
        player.setActivePokemon(card1);
        assertTrue(player.hasActivePokemon());
    }

    @Test
    public void getNoCardsDeck() throws Exception {
        newDeck = new Deck();
        newDeck.populateDeck("C:\\Users\\luckyfang0601\\Documents\\SCHOOL\\comp354\\project\\pokemon\\res\\deck\\deck1.txt");
        player.setDeck(newDeck);
        assertEquals(60,player.getNoCardsDeck());
        player.drawCard();
        assertEquals(59,player.getNoCardsDeck());

    }
    @Test
    public void distributeCards() throws Exception {
        newDeck = new Deck();
        newDeck.populateDeck("C:\\Users\\luckyfang0601\\Documents\\SCHOOL\\comp354\\project\\pokemon\\res\\deck\\deck1.txt");
        player.setDeck(newDeck);
       // player.distributeCards();


    }



}