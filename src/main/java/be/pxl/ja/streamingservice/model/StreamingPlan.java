package be.pxl.ja.streamingservice.model;

public enum StreamingPlan {
    BASIC(1,7.99),
    STANDARD(2,11.99),
    PREMIUM(4,15.99);

    ;
    private int numberOfProfiles;
    private double price;

    StreamingPlan(int numberOfProfiles, double price){
        this.numberOfProfiles=numberOfProfiles;
        this.price= price;
    }
}
