package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends be.pxl.ja.opdracht1.Content implements Playable {
    public static final int Long_PLAYING_TIME = 2 * 60 +15;

    private String director;
    private LocalDate releasDate;
    private int duration;
    private Genre genre;


    public Movie(String title, Rating maturityrating) {
        super(title,maturityrating);

    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleasDate() {
        return releasDate;
    }

    public void setReleasDate(LocalDate releasDate) {
        this.releasDate = releasDate;
    }

    public int getDuration() {
        return duration;
    }

    public String getPlayingTime(){
        String playingtime = String.valueOf(duration) + " min";
        int minutes;
        int hours;


            if( duration <= 0){
                playingtime = "?";
            }
            else if(duration % 60 == 0) {
                hours = duration / 60;
                playingtime = String.valueOf(hours) + " h";
            }
            else if (duration % 60 != 0 && duration > 60){
                hours = duration / 60;
                minutes = duration % 60;
                playingtime = String.valueOf(hours) +" h " + String.valueOf(minutes) + " min";
            }else{
                minutes = duration % 60;
                playingtime = String.valueOf(minutes) + " min";
            }
            return playingtime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;

    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isLongPlayingTIme(){
        return duration >= Long_PLAYING_TIME;
    }


    @Override
    public String toString() {
        return (this.releasDate==null) ? super.getTitle() : super.getTitle() + " " + Integer.toString(this.releasDate.getYear());
    }
    @Override
    public void play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }
}
