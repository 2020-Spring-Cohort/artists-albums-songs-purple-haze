package org.wcci.apimastery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Artist;
import org.wcci.apimastery.models.Comment;
import org.wcci.apimastery.models.Song;
import org.wcci.apimastery.repos.*;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    ArtistRepository artistRepo;
    @Autowired
    AlbumRepository albumRepo;
    @Autowired
    SongRepository songRepo;
    @Autowired
    CommentRepository comRepo;
    @Autowired
    RatingsRepository ratingRepo;


    @Override
    public void run(String... args) throws Exception {
        Artist hendrix = new Artist("Jimmy Hendrix");
        artistRepo.save(hendrix);

        Artist Fleetwood = new Artist ("Fleetwood Mac");
        artistRepo.save(Fleetwood);

        Artist Jon = new Artist ("Jon Longston");
        artistRepo.save(Jon);

        Artist Luke = new Artist ("Luke Bryan");
        artistRepo.save(Luke);

        Artist Bebe = new Artist ("Bebe Rexha");
        artistRepo.save(Bebe);

        Artist beatles = new Artist("The Beatles");
        artistRepo.save(beatles);

        Album Expectations = new Album("Expectations",Bebe);
        albumRepo.save(Expectations);

        Album DoinMyThing = new Album("Doin' My Thing",Luke);
        albumRepo.save(DoinMyThing);

        Album electricLadyLand = new Album("Electric Ladyland", hendrix);
        albumRepo.save(electricLadyLand);

        Album axis = new Album("Axis Bold Is Love", hendrix);
        albumRepo.save(axis);

        Album RightGirlWrongTime = new Album("Right Girl, Wrong Time",Jon);
         albumRepo.save(RightGirlWrongTime);

        Album abbey = new Album("Abbey Road", beatles);
        albumRepo.save(abbey);
        Album submarine = new Album("Yellow Submarine", beatles);
        albumRepo.save(submarine);

        Album Rumours = new Album("Rumours",Fleetwood);
        albumRepo.save(Rumours);

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
        albumRepo.save(axis);
        albumRepo.save(submarine);
        albumRepo.save(abbey);
        albumRepo.save(electricLadyLand);


        Comment jimiComment = new Comment("Hello World","This is a comment");
        comRepo.save(jimiComment);

        hendrix.addCommentToArtist(jimiComment);
        artistRepo.save(hendrix);





    }
}
