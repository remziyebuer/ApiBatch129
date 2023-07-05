package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)

public class Country {
    private String name;
    private List<State> states;//burda ki states body deki key ile ayni olmali orda da states
     // olarak gecmez ise ben bu datayi orada ki nin iicine koyamam************


    public Country(String name, List<State> states) {
        this.name = name;
        this.states = states;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}
