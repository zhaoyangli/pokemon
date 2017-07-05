package ability;

import main.AbilityLogic;

import java.util.List;

public class Redamage extends AbilityLogic {


    public Redamage(List<String> logic) {
        super("redamage");
        this.logic = logic;
        parse();
    }

    public void parse() {
        if (!logic.get(0).equals("source")) {
            throw new IllegalArgumentException("Expecting word 'source'");
        }
        logic.remove(0);

        parsePokemonSource();

        if (!logic.get(0).equals("destination")) {
            throw new IllegalArgumentException("Expecting word 'destination'");
        }
        logic.remove(0);

        parsePokemonDestination();

        parseAmount();

    }

}
