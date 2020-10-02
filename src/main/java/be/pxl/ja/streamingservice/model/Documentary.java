package be.pxl.ja.streamingservice.model;

public class Documentary extends Movie {
private String topic;

    public Documentary(String title, Rating maturityrating) {
        super(title, maturityrating);
        setGenre(Genre.DOCUMENTARY);
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
