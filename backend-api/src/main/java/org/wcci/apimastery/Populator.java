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
        Artist beatles = new Artist("The Beatles");

        Album electricLadyLand = new Album("Electric Ladyland", hendrix);
        Album axis = new Album("Axis Bold Is Love", hendrix);

        Song traffic = new Song("Crosstown Traffic", electricLadyLand);
        Song voodoo = new Song("Voodoo Chile",electricLadyLand);
        Song gypsy = new Song("Gypsy Eyes", electricLadyLand);

        artistRepo.save(hendrix);
        albumRepo.save(electricLadyLand);
        songRepo.save(traffic);
        songRepo.save(voodoo);
        songRepo.save(gypsy);
    }
}
