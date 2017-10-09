package spring.boot;

import javax.persistence.*;
import java.util.List;

@Entity
public class State {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StateId")
    private Integer Id;

    @Version
    private Integer version;

    private String StateName;
    private String StateAbbreviation;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> gameList;

    public State() {}
    public State(String stateName, String stateAbbreviation) {
        this.StateName = stateName;
        this.StateAbbreviation = stateAbbreviation;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getStateAbbreviation() {
        return StateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        StateAbbreviation = stateAbbreviation;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
