import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Float.parseFloat;

public class Main {
    public static void main(String[] args) throws Exception {
        // Parsing the JSON file
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader("src/pokedex.json"));
        JSONArray pokemonArray = (JSONArray) jsonObject.get("pokemon");

        // Printing the name of the 58th Pokémon (Caninos)
        JSONObject pokemonAtIndex = (JSONObject) pokemonArray.get(57);
        String ChoosePokemon = (String) pokemonAtIndex.get("name");
        System.out.println("The 58th Pokémon is: " + ChoosePokemon);

        // Filtering Pokémon by weight
        List<JSONObject> heavyPokemon = filterPokemonByWeight(pokemonArray, 10.0f);
        System.out.println("Pokémon weighing more than 10 kg: " + heavyPokemon.size());

        // Sorting Pokémon by weight
        List<JSONObject> sortedPokemon = sortPokemonByWeight(pokemonArray);
        System.out.println("First Pokémon after sorting by weight: " + sortedPokemon.get(0).get("name"));
    }

    // Filters Pokémon that weigh more than the specified weight
    private static List<JSONObject> filterPokemonByWeight(JSONArray pokemonArray, float weightThreshold) {
        List<JSONObject> filteredList = new ArrayList<>();
        for (Object obj : pokemonArray) {
            JSONObject pokemon = (JSONObject) obj;
            float weight = extractWeight(pokemon);
            if (weight > weightThreshold) {
                filteredList.add(pokemon);
            }
        }
        return filteredList;
    }

    // Sorts Pokémon by weight in ascending order
    private static List<JSONObject> sortPokemonByWeight(JSONArray pokemonArray) {
        List<JSONObject> sortedList = new ArrayList<>();
        for (Object obj : pokemonArray) {
            sortedList.add((JSONObject) obj);
        }
        sortedList.sort(Comparator.comparing(Main::extractWeight));
        return sortedList;
    }

    // Extracts the weight of a Pokémon from its JSON object
    private static float extractWeight(JSONObject pokemon) {
        String weightStr = (String) pokemon.get("weight");
        String weightNumberStr = weightStr.split(" ")[0];
        return parseFloat(weightNumberStr);
    }
}
