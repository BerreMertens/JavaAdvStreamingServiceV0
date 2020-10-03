package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Account;
import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Profile;
import be.pxl.ja.streamingservice.model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProfileAllowedToWatchTest {

    private Account account;
    private Profile profile;
    private Movie movie1;
    private Movie movie2;
    private Movie movie3;
    private Movie movie4;
    private LocalDate dateOfBirth;

    @BeforeEach
    public void init(){
        movie1 = new Movie("Shrek", Rating.LITTLE_KIDS);
        movie2 = new Movie("The Incredibils", Rating.OLDER_KIDS);
        movie3 = new Movie("Titanic", Rating.TEENS);
        movie4 = new Movie("Silent Hill", Rating.MATURE);
        account = new Account("test@gmail.com","azertyui");
        profile= new Profile();
        profile.setName("testProfile1");
        account.addProfile(profile);
    }

    @Test
    public void ProfileAllowedToWatchWithoutDateOfBirth(){

        assertEquals(false,account.getFirstProfile().allowedToWatch(movie1));
        assertEquals(false,account.getFirstProfile().allowedToWatch(movie2));
        assertEquals(false,account.getFirstProfile().allowedToWatch(movie3));
        assertEquals(false,account.getFirstProfile().allowedToWatch(movie4));
    }

    @Test
    public void ProfileAllowedToWatchLittleKids(){
        dateOfBirth = LocalDate.of(2014,10,4);
        account.getFirstProfile().setDateOfBirth(dateOfBirth);
        assertEquals(true,account.getFirstProfile().allowedToWatch(movie1));
        assertEquals(false,account.getFirstProfile().allowedToWatch(movie2));
        assertEquals(false,account.getFirstProfile().allowedToWatch(movie3));
        assertEquals(false,account.getFirstProfile().allowedToWatch(movie4));
    }

   @Test
    public void ProfileAllowedToWatchLittleKidsAndTeens(){
       dateOfBirth = LocalDate.of(2012,10,2);
       account.getFirstProfile().setDateOfBirth(dateOfBirth);

       assertEquals(true,account.getFirstProfile().allowedToWatch(movie1));
       assertEquals(true,account.getFirstProfile().allowedToWatch(movie2));
       assertEquals(false,account.getFirstProfile().allowedToWatch(movie3));
       assertEquals(false,account.getFirstProfile().allowedToWatch(movie4));

   }

    @Test
    public void ProfileAllowedToWatchLittleKidsAndTeensAndOlderKids(){
        dateOfBirth = LocalDate.of(2008,10,2);
        account.getFirstProfile().setDateOfBirth(dateOfBirth);

        assertEquals(true,account.getFirstProfile().allowedToWatch(movie1));
        assertEquals(true,account.getFirstProfile().allowedToWatch(movie2));
        assertEquals(true,account.getFirstProfile().allowedToWatch(movie3));
        assertEquals(false,account.getFirstProfile().allowedToWatch(movie4));

    }

    @Test
    public void ProfileAllowedToWatchAll(){
        dateOfBirth = LocalDate.of(1998,3,2);
        account.getFirstProfile().setDateOfBirth(dateOfBirth);

        assertEquals(true,account.getFirstProfile().allowedToWatch(movie1));
        assertEquals(true,account.getFirstProfile().allowedToWatch(movie2));
        assertEquals(true,account.getFirstProfile().allowedToWatch(movie3));
        assertEquals(true,account.getFirstProfile().allowedToWatch(movie4));

    }


}
