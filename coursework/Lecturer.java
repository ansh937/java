package coursework;

public class Lecturer extends Teacher{
    private String department;
    private int yearsOfExperiance;
    private int gradedScore;
    private boolean hasGraded;
    //constructor that initializes the object's fields according to the parameters passed to it.
    public Lecturer(int teacherId, String teacherName,  String address,String workingType, String employmentStatus, String department, double gradedScore, int yearsOfExperiance){
        //  calling the constructor of the superclass "Teacher" using "super."
        super(teacherId,teacherName,address,workingType,employmentStatus);//
        this.department=department;//.this represent the instance variable not the local one
        this.yearsOfExperiance=yearsOfExperiance;
        this.gradedScore=0;
        this.hasGraded=false;
    }


    // Getter methods for retrieving specific information about the Lecturer
    public String getDepartment(){
        return department;
    }

    public int getYearsOfExperiance(){
        return yearsOfExperiance;
    }

    public int getGradedScore(){
        return gradedScore;
    }

    public boolean isHasGraded(){//boolean is is or isnot so we use is instead of getter
        return hasGraded;
    }
    // Setter method to update the graded score.
    public void setGradedScore(int newScore){
        this.gradedScore=newScore;
    }
    // Method to grade an assignment based on specified criteria.
    public void gradeAssignment(int gradedScore,String department,int yearsOfExperiance){
        // Checking if the years of experience are greater than or equal to 5 and the department matches.
        if(yearsOfExperiance>=5 && this.department.equals(department)){
            // Nested if-else statements to assign grades based on the provided score range.
            if(gradedScore <= 100 && gradedScore >= 70){
                this.gradedScore=gradedScore;
                System.out.println("You have got A in your assignment");
            }else if(gradedScore <= 69 && gradedScore >= 60){
                this.gradedScore=gradedScore;
                System.out.println(" You have got B in your assignment");
            }else if(gradedScore <= 59 && gradedScore >= 50){
                this.gradedScore=gradedScore;
                System.out.println("You have got C in your assignment");
            }else if(gradedScore <= 49 && gradedScore >= 40){
                this.gradedScore=gradedScore;
                System.out.println(" You have got D in your assignment");
            }else if(gradedScore <= 39 && gradedScore > 0){
                this.gradedScore=gradedScore;
                System.out.println("You have got E in your assignment");
            }else {
                System.out.println("Error...");
            }
            this.hasGraded=true;// Setting the flag to indicate that the assignment has been graded.

        }else{
            System.out.println("The lecturer is not experienced enough or the department is different");

        }

    }
    // Overriding the displayInfo() method of the superclass to display additional information for the Lecturer.
    @Override
    // calling  the displayInfo() method of the superclass.
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Department name "+ department) ;
        System.out.println("Years Of Experiance "+ yearsOfExperiance);
        if(hasGraded){
            System.out.println("You have got: "+ gradedScore + " in your Assignment.");
        }else{
            System.out.println("Your Assignment is not graded");
        }
    }
}
