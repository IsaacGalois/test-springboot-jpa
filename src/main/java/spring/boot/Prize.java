package spring.boot;

import javax.persistence.*;

@Entity
public class Prize {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PrizeId")
    private Integer Id;

    @Version
    private Integer version;

    private String Match;
    private String Win;
    private String Odds;

    @ManyToOne
    @JoinColumn(name = "GameId")
    private Game game;

    public Prize() {}

    public Prize(String match, String win, String odds) {
        this.Match = match;
        this.Win = win;
        this.Odds = odds;
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

    public String getMatch() {
        return Match;
    }

    public void setMatch(String match) {
        Match = match;
    }

    public String getWin() {
        return Win;
    }

    public void setWin(String win) {
        Win = win;
    }

    public String getOdds() {
        return Odds;
    }

    public void setOdds(String odds) {
        Odds = odds;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String toString() {
        return new String("Match: "+this.Match+", Win:"+this.Win+", Odds:"+this.Odds);
    }
}
