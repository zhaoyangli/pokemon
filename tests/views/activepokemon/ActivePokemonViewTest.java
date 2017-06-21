package views.activepokemon;

import card.Energy;
import main.Ability;
import main.Attack;
import main.Requirement;
import org.junit.Test;
import views.card.PokemonView;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by luckyfang0601 on 2017-06-01.
 */
public class ActivePokemonViewTest {
    private PokemonView pokemonView;
    private ActivePokemonView activePokemonView;
    @Test
    public void removePokemonView() throws Exception {
        ArrayList<Energy> energyArray= new ArrayList<Energy>(20);
        Ability ability = new Ability("Rain Splash","damage","put 20 damage points on opponent","opponent-active");
        Requirement requirement=new Requirement("general",2);
        ArrayList<Requirement> requirements = new ArrayList<Requirement>();
        requirements.add(requirement);
        Attack attack = new Attack(requirements,ability);
        ArrayList<Attack> attacks = new ArrayList<Attack>();
        attacks.add(attack);
        pokemonView = new PokemonView(energyArray,attacks,0,90,"basic");
        activePokemonView = new ActivePokemonView(pokemonView);
        activePokemonView.removePokemonView();
        assertNull(activePokemonView.getPokemonView());
    }

//    @Test
//    public void zoomPokemon() throws Exception {
//    }

}