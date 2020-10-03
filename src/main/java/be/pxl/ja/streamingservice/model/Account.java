package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.List;

public class Account{
    private String email;
    private String password;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles;
    private PaymentInfo paymentInfo;


    public Account(String email,String password) {
        profiles = new ArrayList<>();
        Profile startProfile = new Profile();
        startProfile.setName("profile1");
        profiles.add(startProfile);
        this.password= password;
        this.email=email;
    }

    public void addProfile(Profile profile){
        profiles.add(profile);
    }

    public boolean verifyPassword(String password){
        return this.password.equals(password) ;
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getFirstProfile(){
         return  profiles.get(0);
    }
}
