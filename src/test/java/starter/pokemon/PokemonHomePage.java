package starter.pokemon;

import com.google.gson.Gson;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://pokemondb.net/pokedex/national")
public class PokemonHomePage extends PageObject {
    public List<Pokemon> getPokemonsData() {
        List<Pokemon> pokemonsList = new ArrayList<>();
        List<WebElementFacade> pokemonGenerations = findAll(By.cssSelector(".infocard-list"));

        for (WebElementFacade cardList: pokemonGenerations) {
            for (WebElement pokemons: cardList.findElements(By.cssSelector(".infocard"))) {
                String name = pokemons.findElement(By.cssSelector(".ent-name")).getText();
                String pokeId = pokemons.findElement(By.cssSelector("small:nth-of-type(1)")).getText();
                String image = pokemons.findElement(By.cssSelector(".img-sprite")).getAttribute("src");
                if (image == null) {
                    image = pokemons.findElement(By.cssSelector(".img-sprite")).getAttribute("data-src");
                }
                List<WebElement> typeElements = pokemons.findElements(By.cssSelector(".itype"));
                List<String> types = new ArrayList<>();
                for (WebElement type: typeElements) {
                    types.add(type.getText());
                }

                pokemonsList.add(new Pokemon(name,image,pokeId,types));
            }
        }
        return pokemonsList;
    }


    public void exportToJson(List<Pokemon> pokemons) {
        String json = new Gson().toJson(pokemons);
        FileWriter file = null;
        try {
            file = new FileWriter("./src/test/resources/pokemons.json");
            file.write(json);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
