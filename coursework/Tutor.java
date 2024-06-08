package coursework;

public class Tutor extends Teacher{
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;
    //constructor that initializes the object's fields according to the parameters passed to it.
    public Tutor(int teacherId,String teacherName,String workingType,String address,String employmentStatus,int workingHours,double salary,String specialization,String academicQualification,int performanceIndex){
        super(teacherId,teacherName,address,workingType,employmentStatus);// This line calls the constructor of the 'Teacher' class and passes in the tutor's ID, name, working type, address, and employment status.
        super.setWorkingHours(workingHours);
        this.salary=salary;//.this represent the instance variable not the local one
        this.academicQualification=academicQualification;
        this.specialization=specialization;
        this.performanceIndex=performanceIndex;
        this.isCertified=false;
    }
    //Accessor methods
    public double getSalary(){
        return salary;
    }

    public String getSpecialization(){
        return specialization;
    }

    public String getAcademicQualification(){
        return academicQualification;
    }

    public int getPerformanceIndex(){
        return performanceIndex;
    }

    public boolean getIsCertified(){
        return isCertified;
    }
    //Mutator method to set the salary based on performance and working hours.

    public void setSalary(double newSalary,int newPerfomanceIndex){

        double appraisal = 0;
        // Checking if the performance index is greater than or equal to 5 and working hours exceed 20.

        if(performanceIndex>=5 && getWorkingHours()>20){
            if(performanceIndex>=5 &&performanceIndex<=7  ){
                appraisal=0.05;
            }else if(performanceIndex >=8 && performanceIndex<=9){
                appraisal=0.1;
            }  else if (performanceIndex == 10){
                appraisal=0.2;
            }


            this.isCertified=true;
            // Calculating the salary with the applied appraisal.

            this.salary=newSalary+(appraisal * newSalary);
            System.out.println("Salary is approved and apprisal applied");

        }else{
            System.out.println("Teacher is not certified and salary cannot be approved");
        }
    }
    // Method to remove the tutor if not certified.

    public void removeTutor(){
        if(isCertified==false){
            // Resetting attributes if the tutor is not certified.
            salary=0.0;
            specialization="";
            academicQualification="";
            performanceIndex=0;
            isCertified=false;
            System.out.println("tutor removed successfully");

        }else{
            System.out.println("As Tutor is certified i.e we cannot remove");
        }
    }
    // Overriding the displayInfo() method of the superclass to display additional information for the Tutor.

    @Override
    public void displayInfo(){//// Invoking the displayInfo() method of the superclass.
        if(isCertified){
            super.displayInfo();
            System.out.println("Salary is "+ salary);
            System.out.println("Academic Qualifications is "+ academicQualification);
            System.out.println("Perfomance Index "+ performanceIndex);

        }else{
            super.displayInfo();// Invoking the displayInfo() method of the superclass.

        }
    }
}
