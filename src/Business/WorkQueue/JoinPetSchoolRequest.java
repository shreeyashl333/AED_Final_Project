/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.EcoSystem;
import Business.POJO.Pet;
import Business.POJO.Users;
import Business.UserAccount.UserAccount;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author chaitanya
 */
public class JoinPetSchoolRequest extends WorkRequest  {
    private String reportId;
    private String animalType;
    private String CourseType;
    private String username;
    private Pet pet;
    private Map <String, String> comments1;

    public Map<String, String> getComments1() {
        return comments1;
    }

    public void setComments1(Map<String, String> comments1) {
        this.comments1 = comments1;
    }

  

      private String comments;

    

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

   

    public String getCourseType() {
        return CourseType;
    }

    public void setCourseType(String CourseType) {
        this.CourseType = CourseType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    
    @Override
    public String toString() {
        return this.reportId;
    }
    
    public enum CourseType {
        BasicTraining("Basic Training"), AgilityTraining("Agility Training");
        private String CourseType;

        private CourseType(String urgency) {
            this.CourseType = urgency;
        }

        public String getValue() {
            return CourseType;
        }
    }
     public enum animalType {
        Cat("Cat"), Dog("Dog");
        private String animalType;

        private animalType(String animalType) {
            this.animalType = animalType;
        }

        public String getValue() {
            return animalType;
        }
    }
    
    
    
    
    
}
