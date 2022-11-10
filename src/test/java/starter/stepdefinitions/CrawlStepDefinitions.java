package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pokemon.Pokemon;
import starter.pokemon.PokemonHomePage;

import java.util.List;

public class CrawlStepDefinitions {

    PokemonHomePage pokemonHomePage;
    List<Pokemon> pokemons;
    @Given("system visit pokemon website page")
    public void userVisitPokemonWebsitePage() {
        pokemonHomePage.open();
    }

    @When("system start crawl data")
    public void userStartCrawlData() {
        pokemons = pokemonHomePage.getPokemonsData();
    }

    @Then("system convert data to json")
    public void userConvertDataToJson() {
        pokemonHomePage.exportToJson(pokemons);
    }
}
