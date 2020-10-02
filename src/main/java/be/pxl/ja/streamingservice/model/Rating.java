package be.pxl.ja.streamingservice.model;

public enum Rating {
    LittleKids(""),
    OlderKids("7"),
    Teens("12"),
    Mature("16");

    private String leeftijd;

    Rating(String leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getLeeftijd() {
        return leeftijd;
    }
}
