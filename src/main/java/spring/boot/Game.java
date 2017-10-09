package spring.boot;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GameId")
    private Integer Id;

    @Version
    private Integer version;

    private String GameName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Prize> prizeList;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<State> stateList;

    public Game() {}
    public Game(String gameName) {
        this.GameName = gameName;
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

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public List<Prize> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
}
