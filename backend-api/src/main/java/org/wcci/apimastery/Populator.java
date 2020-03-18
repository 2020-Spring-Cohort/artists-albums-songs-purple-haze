package org.wcci.apimastery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Song;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    ArtistRepository artistRepo;
    @Autowired
    AlbumRepository albumRepo;
    @Autowired
    SongRepository songRepo;


    @Override
    public void run(String... args) throws Exception {
        Artist hendrix = new Artist("Jimmy Hendrix");
        artistRepo.save(hendrix);

        Artist beatles = new Artist("The Beatles");
        artistRepo.save(beatles);

        Album electricLadyLand = new Album("Electric Ladyland", hendrix);
        albumRepo.save(electricLadyLand);
        Album axis = new Album("Axis Bold Is Love", hendrix);
        albumRepo.save(axis);

        Album abbey = new Album("Abbey Road", beatles);
        albumRepo.save(abbey);
        Album submarine = new Album("Yellow Submarine", beatles);
        albumRepo.save(submarine);

        Song traffic = new Song("Crosstown Traffic", electricLadyLand);
        songRepo.save(traffic);
        Song voodoo = new Song("Voodoo Chile",electricLadyLand);
        songRepo.save(voodoo);
        Song gypsy = new Song("Gypsy Eyes", electricLadyLand);
        songRepo.save(gypsy);

        Song exp = new Song("Exp", axis);
        songRepo.save(exp);
        Song skies = new Song("Up From The Skies", axis);
        songRepo.save(skies);
        Song spanish = new Song("Spanish Castle Magic", axis);
        songRepo.save(spanish);

        Song together = new Song("Come Together", abbey);
        songRepo.save(together);
        Song darling = new Song("Oh! Darling", abbey);
        songRepo.save(darling);
        Song something = new Song("Something",abbey);
        songRepo.save(something);

        Song yellow = new Song("Yellow Submarine", submarine);
        songRepo.save(yellow);
        Song bulldog = new Song("Hey Bulldog", submarine);
        songRepo.save(bulldog);
        Song rigby = new Song("Eleanor Rigby", submarine);
        songRepo.save(rigby);
    }
}
