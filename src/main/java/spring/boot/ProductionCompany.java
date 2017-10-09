package spring.boot;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductionCompany {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productionCompany_id")
    private Integer Id;

    @Version
    private Integer version;

    private String productionCompanyName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Movie> movieList;

    public ProductionCompany() {};

    public ProductionCompany(String name) {
        this.productionCompanyName = name;
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

    public String getProductionCompanyName() {
        return productionCompanyName;
    }

    public void setProductionCompanyName(String productionCompanyName) {
        this.productionCompanyName = productionCompanyName;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
