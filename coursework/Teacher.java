package coursework;

public class Teacher {
    //using private field to store teacher information for encapsulation
    private int teacherId ;
    private String teacherName;
    private String workingType;
    private String address;
    private String employmentStatus;
    private int workingHours;
    /*making parameterized constructor to initialize teacher information*/
    public Teacher(int teacherId, String teacherName,  String address,String workingType, String employmentStatus ){
        this.teacherId=teacherId;//.this represent the instance variable not the local one
        this.teacherName=teacherName;
        this.address=address;
        this.workingType=workingType;
        this.employmentStatus=employmentStatus;

    }



    //taking getter (accessor) to return the information
    public int getTeacherId(){
        return teacherId;
    }
    public String getTeacherName(){
        return teacherName;
    }

    public String getAddress(){
        return address;
    }
    public String getWorkingType(){
        return workingType;
    }

    public String getEmploymentStatus(){
        return employmentStatus;
    }
    public int getWorkingHours(){
        return workingHours;
    }
    //taking setter( mutator) method to update and set information
    public void setWorkingHours(int newWorkingHours){
        this.workingHours=newWorkingHours;
    }
    public void displayInfo(){//DisplayInfo method to display all the information of employee
        System.out.println("Teacher's Information:");//print heading of the information
        System.out.println("Teacher's Id number is "+teacherId);// Diplay's teacher's id
        System.out.println("Teacher's Name is "+teacherName);// Diplay's teacher's name
        System.out.println("Teacher's address is "+ address);// Diplays teacher's address
        System.out.println("Teacher's working type is "+ workingType);// Diplay's teacher's working type
        System.out.println("Teacher's employment status is "+ employmentStatus);// Diplay's teacher's employment status
        // showing the working hours is assigned or not  by using if else statement
        if(workingHours<=0){
            System.out.println("provide your genuine working hours according to Hours ");
        }else{
            System.out.println("Teacher's working hours are "+ workingHours);// Diplay's teacher's working hours.
        }
    }
}
