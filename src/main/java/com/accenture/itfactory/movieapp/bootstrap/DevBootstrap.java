package com.accenture.itfactory.movieapp.bootstrap;

import com.accenture.itfactory.movieapp.model.*;
import com.accenture.itfactory.movieapp.service.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

   private UserService userService;
   private MovieService movieService;
   private ReviewService reviewService;
   private GenreService genreService;
   private TitleTypeService titleTypeService;




    public DevBootstrap(UserService userService, MovieService movieService, GenreService genreService,
                        ReviewService reviewService, TitleTypeService titleTypeService) {
        this.userService = userService;
        this.movieService = movieService;
        this.genreService = genreService;
        this.reviewService = reviewService;
        this.titleTypeService = titleTypeService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        intiData();
    }

    private void intiData() {

        //USERS:  -- populating database with test data
        User user = new User("steve", "steve12", "Steve12345", UserType.ADMINISTRATOR);
        User user1 = new User("jon", "jon12", "jon12345", UserType.USER);
        User user2 = new User("peter", "peter12", "peter12345", UserType.USER);
        User user3 = new User("maxim", "maxim12", "maxim12345", UserType.USER);
        User user4 = new User("sergei", "sergei12", "sergei12345", UserType.USER);

        //saving test users
        userService.save(user);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);


        //MOVIES: --populationg movies genres and reviews with test data
        Review review = new Review(LocalDate.of(2018, 10, 12), "Stephen",
                "The film could have easily alleviated all of these issues with a quick scene or a line about fake passports for Emily and Nicky.", 7.9);
        Review review1 = new Review(LocalDate.of(1979, 8, 15), "Allan",
                "All in all, A Simple Favor is a fun romp filled with crazy twists and turns, humor, and great acting. " +
                        "Don't think too much about the film itself, and just go have some fun. It's definitely worth a getaway matinee.", 8.0);

        Movie movie1 = new Movie("The Departed", "Movie",
                LocalDate.of(2012, 11, 29), 9.6,
                " To take down South Boston's Irish Mafia, the police send" +
                        " in one of their own to infiltrate the underworld, not realizing the syndicate has done likewise. ", true);

        Genre genre = new Genre("Crime", "The generated Lorem Ipsum is therefore always free from repetition," +
                " injected humour, or non-characteristic words etc.");



        //Add reviews to a movie and save it
        movie1.getReviews().add(review);
        movie1.getReviews().add(review1);
        review.setMovie(movie1);
        review1.setMovie(movie1);
        movie1.setGenre(genre);
        genre.getMovie().add(movie1);
        genreService.save(genre);
        movieService.save(movie1);



        //Movie2 with Its Reviews
         Review review2 = new Review(LocalDate.of(2012, 3, 24), "Maxim",
                "Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32", 8.9);
        Review review3 = new Review(LocalDate.of(2002, 12, 12), "Gideon",
                "Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32", 9.9);
        Movie movie2 = new Movie("Venom", "Series",
                LocalDate.of(2018, 10, 5), 6.6,
                " Eddie Brock is a reporter—investigating people who want to go unnoticed. " +
                        "But after he makes a terrible discovery at the Life Foundation," +
                        " he begins to transform into ‘Venom’. ", false);

        Genre genre1 = new Genre("Drama", "The generated Lorem Ipsum is therefore always free from repetition," +
                " injected humour, or non-characteristic words etc.");

        //Add reviews to a movie and save it
        movie2.getReviews().add(review2);
        movie2.getReviews().add(review3);
        review2.setMovie(movie2);
        review3.setMovie(movie2);
        movie2.setGenre(genre1);
        genre1.getMovie().add(movie2);
        genreService.save(genre1);
        movieService.save(movie2);


        //Movie3 with Its Reviews
        Review review4 = new Review(LocalDate.of(2012, 3, 24), "Maxim",
                "The devoted son spends the night with the dead woman...\n" +
                        "\n" +
                        "Featured Crew", 8.9);
        Movie movie3 = new Movie("The Legend of Departed Soul ", "Series",
                LocalDate.of(1970, 1, 1), 7.6,
                "A devoted son hears that, he must pay one thousand 'nyang'" +
                        " (old Korean currency) to save his father who is in jail for unknown reason. ", true);

        Genre genre2 = new Genre("Horror", "The generated Lorem Ipsum is therefore always free from repetition," +
                " injected humour, or non-characteristic words etc.");

        //Add reviews to a movie and save it
        movie3.getReviews().add(review4);
        review4.setMovie(movie3);
        movie3.setGenre(genre2);
        genre2.getMovie().add(movie3);
        genreService.save(genre2);
        movieService.save(movie3);

        //Movie4 with Its Reviews
        Review review5 = new Review(LocalDate.of(2012, 3, 24), "Maxim",
                " terrible discovery at the Life Foundation, he begins to transform into ‘Venom’. The Foundation has discovered creatures…", 8.9);
        Movie movie4 = new Movie("Aquaman ", "Series",
                LocalDate.of(2018, 12, 21), 9.6,
                " The film reveals the origin story of half-human, half-Atlantean Arthur Curry and takes" +
                        " him on the journey of his lifetime—one" +
                        " that will not only force him to face who he really is, but to discover if he is " +
                        "worthy of who he was born to be… a king. ", false);

        Genre genre3 = new Genre("Action", "The generated Lorem Ipsum is therefore always free from repetition," +
                " injected humour, or non-characteristic words etc.");

        //Add reviews to a movie and save it
        movie4.getReviews().add(review5);
        review5.setMovie(movie4);
        movie4.setGenre(genre3);
        genre3.getMovie().add(movie4);
        genreService.save(genre3);
        movieService.save(movie4);

        //Movie5 with Its Reviews
        Review review6 = new Review(LocalDate.of(2012, 3, 24), "Dmitry",
                "First and foremost, this film feels like someone went to their local grocery store, grabbed a random three-dollar " +
                        "mystery novel off the checkout shelf, and decided to make it a movie with some extremely popular and attractive people.", 8.9);
        Movie movie5 = new Movie("A Simple Favor", "Movie",
                LocalDate.of(2018, 10, 4), 8.6,
                "Mommy vlogger Stephanie joins her best friend Emily’s husband, " +
                        "Sean, to investigate her sudden disappearance from their small town.", false);

        Genre genre4 = new Genre("Romance", "The humor in the movie is peppered in " +
                "during great moments. Some of it is cheesy, but if you're going to this film for a deep, thought-provoking film, don't.");

        //Add reviews to a movie and save it
        movie5.getReviews().add(review6);
        review6.setMovie(movie5);
        movie5.setGenre(genre4);
        genre4.getMovie().add(movie5);
        genreService.save(genre4);
        movieService.save(movie5);


/*


        //TITLETYPE: --populationg titletpe with test data
        TitleType titletype =new TitleType("Example Title 1", "omes from a line in section");
        TitleType titletype1 =new TitleType("Example Title 2", "omes from a line in section");

        titleTypeService.save(titletype);
        titleTypeService.save(titletype1);
        */

    }
}
