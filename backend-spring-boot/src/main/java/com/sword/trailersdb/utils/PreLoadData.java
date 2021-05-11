package src.main.java.com.sword.trailersdb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(ActorRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Actor("Johnny Depp")));
            log.info("Preloading " + repository.save(new Actor("Robert Downey Jr")));
        };
        //Should add a Movie, but that class is not done yet
    }
}