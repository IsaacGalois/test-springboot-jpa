package spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(PrizeRepository prizeRepository, GameRepository gameRepository, StateRepository stateRepository) {
        return (args) -> {
            JPALab(prizeRepository,gameRepository,stateRepository);
        };
    }

    private static void JPALab(PrizeRepository prizeRepository, GameRepository gameRepository, StateRepository stateRepository) {

        List<Prize> pList = new ArrayList<>();
        pList.add(new Prize("1 2 3 4 5","5000","1:2000"));
        pList.add(new Prize("4 9 7 8 0","100000","1:500000"));
        pList.add(new Prize("6 0 5 3 1","1000","1:100"));

        Game powerball = new Game("PowerBall");
        powerball.setPrizeList(pList);
        gameRepository.save(powerball);

        List<Prize> pList2 = new ArrayList<>();
        pList2.add(new Prize("3 2 9 1 3","100000","1:700000"));
        pList2.add(new Prize("2 1 8 0 4","8000","1:1000"));
        pList2.add(new Prize("1 0 7 9 5","2000","1:600"));

        Game northstarCash = new Game("Northstar Cash");
        northstarCash.setPrizeList(pList2);

        gameRepository.save(northstarCash);

        stateRepository.save(new State("Minnesota","MN"));
        stateRepository.save(new State("Colorado","CO"));
        stateRepository.save(new State("Virginia","VA"));

        List<State> stateList = new ArrayList<>();
        stateList.add(stateRepository.findOne(1));
        stateList.add(stateRepository.findOne(2));
        stateList.add(stateRepository.findOne(3));
        powerball.setStateList(stateList);

        gameRepository.save(powerball);

        State mn = stateRepository.findOne(1);
        mn.getGameList().add(northstarCash);
        mn.getGameList().add(powerball);

        stateRepository.save(mn);

        log.info("Powerball Prizes");
        for(Prize p : powerball.getPrizeList()) {
            log.info(p.toString());
        }

        log.info("Northstar Cash Prizes");
        for(Prize p : northstarCash.getPrizeList()) {
            log.info(p.toString());
        }

        log.info("States Powerball is in");
        for(State s : powerball.getStateList()) {
            log.info(s.getStateName());
        }

        log.info("Games played in Minnesota");
        for(Game g : mn.getGameList()) {
            log.info(g.getGameName());
        }

    }

    private static void LessonJPAIntro3(MovieRepository movieRepository, ProductionCompanyRepository productionCompanyRepository) {
        movieRepository.save(new Movie("Batman"));
        movieRepository.save(new Movie("The Shining"));
        movieRepository.save(new Movie("The 2 Jakes"));

        productionCompanyRepository.save(new ProductionCompany("Warner Bros."));
        productionCompanyRepository.save(new ProductionCompany("Paramount"));
        productionCompanyRepository.save(new ProductionCompany("20th Century Fox"));

        Movie m1 = movieRepository.findOne(1);

        List<ProductionCompany> pcList = new ArrayList<>();
        pcList.add(productionCompanyRepository.findOne(1));
        pcList.add(productionCompanyRepository.findOne(2));

        m1.setProductionCompanyList(pcList);
        movieRepository.save(m1);

        //notes: retrieve a movie and all associated production companies
        Movie movieRetrieve = movieRepository.findOne(1);
        log.info("Movie Title: "+movieRetrieve.getMovieTitle());
        for(ProductionCompany pc: movieRetrieve.getProductionCompanyList()) {
            log.info("Prod Company: "+pc.getProductionCompanyName());
        }

        ProductionCompany pc1 = productionCompanyRepository.findOne(1);

        List<Movie> mList = new ArrayList<>();
        mList.addAll((Collection<? extends Movie>) movieRepository.findAll());

        pc1.setMovieList(mList);

        productionCompanyRepository.save(pc1);
    }

    private static void LessonJPAIntro2(PersonRepository personRepository, EmailRepository emailRepository) {
        Person bipinPerson = new Person("Bipin");

//            Email email = new Email("bipin@bipin.com");
//            email.setPerson(bipinPerson);
//            emailRepository.save(email);

        List<Email> emailList = new ArrayList<>();
        emailList.add(new Email("bipin@gmail.com"));
        emailList.add(new Email("bipin@yahoo.com"));
        emailList.add(new Email("bipin@hotmail.com"));

//            emailRepository.save(emailList);

        bipinPerson.setEmailList(emailList);

        personRepository.save(bipinPerson);
    }

    private static void LessonJPAIntro(PersonRepository personRepository) {
        log.info("---------its working--------");
        personRepository.save(new Person("Bipin"));
        personRepository.save(new Person("Dan"));
        personRepository.save(new Person("Sean"));

        Person person = new Person();
        person.setFirstName("Java");
        person.setLastName("Persistence API is Awesome!!");
        person.setGender("F");

        personRepository.save(person);

        for(int x=0;x<10;x++) {
            Person pers = new Person("Person "+x);
            pers.setLastName("LastName "+x);
            pers.setGender("M");
            //notes: individual save
            personRepository.save(pers);
        }

        List<Person> personListToSave = new ArrayList<Person>();
        for(int x=0;x<10;x++) {
            Person pers = new Person("PersonL "+x);
            pers.setLastName("LastNameL "+x);
            pers.setGender("L");

            personListToSave.add(pers);
        }
//            notes: save a group of objects at once
        personRepository.save(personListToSave);

        //notes: find an object by id
        Person foundPerson = personRepository.findOne(6);
        log.info("PersonFound: "+foundPerson.getFirstName()+" "+foundPerson.getLastName());

        //notes: iterate through all the records in the database
        for(Person p : personRepository.findAll()) {
            log.info(p.getId()+" "+p.getFirstName());
        }

        if(personRepository.exists(4))
            personRepository.delete(4);
        log.info("Person w ID = 4 exists: "+personRepository.exists(4));
        log.info("Person w ID = 90 exists: "+personRepository.exists(90));
        log.info("Total Person records: "+personRepository.count());

//            personRepository.deleteAll();
    }
}
