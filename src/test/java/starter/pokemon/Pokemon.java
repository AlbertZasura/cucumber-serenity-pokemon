package starter.pokemon;

import java.util.List;

public class Pokemon {
    private String name;
    private String image;
    private String pokeId;
    private List<String> types;

    public Pokemon(String name, String image, String pokeId, List<String> types) {
        this.name = name;
        this.image = image;
        this.types = types;
        this.pokeId = pokeId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getPokeId() {
        return pokeId;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", pokeId='" + pokeId + '\'' +
                ", types=" + types +
                '}';
    }
}
