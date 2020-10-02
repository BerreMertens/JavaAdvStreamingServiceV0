package be.pxl.ja.streamingservice.model;

public class Documentary extends be.pxl.ja.opdracht1.Movie {
private String topic;

    public Documentary(String title, Rating maturityrating, String topic) {
        super(title, maturityrating);
        setGenre(Genre.DOCUMENTARY);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void play() {
        System.out.println("playing documentary about " + getTopic() );;
    }

    @Override
    public void pause() {
        System.out.println("Pausing documentary about " + getTopic());;
    }
}
