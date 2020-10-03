package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Profile {
    private String Name;
    private LocalDate dateOfBirth;



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(){
        int ageProfile;
        if(dateOfBirth == null){
            ageProfile=0;
        }else{
            ageProfile= ((LocalDate.now().getMonthValue() > dateOfBirth.getMonthValue()) && (LocalDate.now().getDayOfMonth() > dateOfBirth.getDayOfMonth())) ? (LocalDate.now().getYear() - dateOfBirth.getYear() -1) : (LocalDate.now().getYear() - dateOfBirth.getYear());
        }

        return ageProfile;
    }

    public Boolean allowedToWatch(Content content){
        int ageMovie = content.getMaturityRating().getminimumAge();
        int ageProfile = this.getAge();

        if(ageProfile == 0){
            return false;
        } else if (ageMovie > ageProfile ){
            return false;
        }else {
            return true;
        }
    }
}
