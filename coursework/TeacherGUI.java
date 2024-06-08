package coursework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/* This class represent graphical user interface of the teacher and the class extends the
JFrame to create the main window
*/
public class TeacherGUI extends JFrame {

    //Create a custom JLabel which font  implemented in all  JLabel  below
    public JLabel customLabel(String text){
        JLabel customLabel1=new JLabel(text);
        customLabel1.setFont(new Font("Sans Serif Fonts", Font.PLAIN,17));
        return  customLabel1;
    }
    // custom JField which font colour and border is   implemented in all  textField we make
    public JTextField customTextField(int rows,Insets insets){
        JTextField customTextField1=new JTextField(rows);
        customTextField1.setForeground(Color.darkGray);
        customTextField1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));//1px rounded border
        return customTextField1;
    }

    // custom JButton  which font,background,margin is implemented in all  JButton we make
    public JButton customButton(String text,Insets insets1){
        JButton button=new JButton(text);
        button.setFont(new Font("Calisto Mt", Font.PLAIN,17));
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBackground(new Color(211,211,211));
        button.setFocusPainted(false);
        button.setRolloverEnabled(false);//By default, buttons in Java Swing often change appearance slightly (like changing color or background) to indicate that they are interactive when hovered over. so I disabled it
        button.setMargin(new Insets(2,2,2,2));


        return button;

    }


    // Labels for displaying lecturer, tutor,display Assignment and remove  tutor information
    JLabel lecturerIdLabel, lecturerNameLabel, lecturerWorkingTypeLabel, lecturerAddressLabel,lecturerEmploymentStatusLabel,lecturerDepartmentLabel,
            lecturerYearsOfExperianceLabel,  lecturerGradedScoreLabel, lecturerWorkingHour,
            tutorIdLabel, tutorNameLabel,tutorSalaryLabel, tutorSpecializationLabel,tutorAddressLabel,tutorWorkingTypeLabel,tutorEmploymentStatusLabel,
            tutorWorkingHoursLabel, tutorAcademicQualificationLabel,tutorPerformanceIndexLabel,
            assignmentTeacherIdLabel, assignmentGradedScoreLabel, assignmentDepartmentLabel,
            assignmentYears0fExperienceLabel, salaryTutorIdLabel, salaryTutorNewSalaryLabel, salaryTutorNewPerformanceIndexLabel,removeTutorLabel;


    //JTextField for user input of  lecturer, tutor,display Assignment and remove  tutor information
    JTextField lecturerIdTextField, lecturerNameTextField, lecturerWorkingTypeTextField, lecturerAddressTextField,lecturerEmploymentStatusTextField,lecturerDepartmentTextField
               ,lecturerYearsOfExperianceTextField,lecturerWorkingHoursTextField,
            tutorIdTextField, tutorNameTextField,tutorSalaryTextField, tutorSpecializationTextField,tutorAddressTextField,tutorWorkingTypeTextField,tutorEmploymentStatusTextField,
            tutorWorkingHoursTextField, tutorAcademicQualificationTextField,tutorPerformanceIndexTextField,lecturerGradedScoreTextField,
            assignmentTeacherIdTextField, assignmentGradedScoreTextField, assignmentDepartmentTextField, assignmentYears0fExperienceTextField,
            salaryTutorIdTextField, salaryTutorNewSalaryTextField, salaryTutorNewPerformanceIndexTextField, removeTutorTextField;

    //JButton for various actions
    JButton addLecturerBtn, addTutorBtn, gradeAssignmentBtn, setSalaryOfTutorBtn, removeTutorBtn, clearLecturerBtn,clearTutorBtn,clearAssignmentBtn,
            clearSetSalaryBtn,clearRemoveTutorBtn, displayLecturerBtn,displayTutorBtn,displaySalaryBtn, displayGradedAssignmentBtn,displayRemoveTutorBtn,
            mainMenuLecturerBtn,mainMenuTutorBtn,mainMenuAssignmentBtn,mainMenuSetSalaryBtn, mainMenuRemoveTutorBtn,displayAllBtn;

    // variable card layout for the layout of the panel
    CardLayout cardLayout;

    // variable main panel of Panel
    JPanel mainPanel;

    //Arraylist of teacher
    ArrayList<Teacher> arraylist =new ArrayList<>();

    //TeacherGUI constructor which initialize the Teacher GUI object and  displays main page GUI
    public TeacherGUI() {

        createAndShowGUI();
    }

     //method which show main frame where panel are added
    public void createAndShowGUI() {
        setSize(600, 640);
        setTitle("Teacher Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        mainPanel = new JPanel();//main panel where other panels are added
        /*
        card layout for the panels which allows you to display  only one panel (card) at a time from a collection of panels added to a container
         . It's like a stack of cards where you can only see the top card at once.
        */
        cardLayout = new CardLayout();//setting the layout for  the main Panel
        mainPanel.setLayout(cardLayout);
        add(mainPanel);

        // Adding panels to the mainPanel with unique string constraints
        mainPanel.add(createButtonPanel(), "ButtonPanel");
        mainPanel.add(createLecturerPanel(), "LecturerPanel");
        mainPanel.add(createTutorPanel(), "TutorPanel");
        mainPanel.add(createGradeAssignmentsPanel(), "GradeAssignmentsPanel");
        mainPanel.add(createSetSalaryPanel(), "SetSalaryPanel");
        mainPanel.add(createRemoveTutorPanel(),"removeTutorPanel");

        cardLayout.show(mainPanel, "ButtonPanel"); // Show the button panel initially

        setVisible(true);


    }
    //method which shows first page panel  which gives user option to go to different pages through the help of buttons
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        buttonPanel.setBackground(new Color(230, 230, 250));  //panel background is set to light purple color

        JLabel addButtonLabel = new JLabel("Main Menu");
        addButtonLabel.setFont(new Font("KRICO", Font.BOLD, 33));//setting font for the label
        buttonPanel.add(addButtonLabel);

         //    Displaying the buttons in the landing page
        Insets insets1 = new Insets(10, 10, 10, 10);
        addLecturerBtn=customButton("Add Lecturer",insets1);
        addTutorBtn=customButton("Add Tutor",insets1);
        gradeAssignmentBtn=customButton("Grade Assignment",insets1);
        setSalaryOfTutorBtn=customButton("Set Salary",insets1);
        removeTutorBtn=customButton("Remove Tutor",insets1);
        displayAllBtn=customButton("Display Info",insets1);

        //function for addLecturer button
        addLecturerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "LecturerPanel");

            }
        });
        //function for addTutor button
        addTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "TutorPanel");

            }
        });
        //function for grade assignment  button
        gradeAssignmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "GradeAssignmentsPanel");

            }
        });

        //function for setSalary  button
        setSalaryOfTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(mainPanel, "SetSalaryPanel");
            }
        });
        //function for removeTutor button
        removeTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel,"removeTutorPanel");
            }
        });
        //function for display all button which display all the information about tutor,lecturer and grade assignment
        displayAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arraylist.isEmpty()) {// Check if the arraylist of teachers is empty
                    JOptionPane.showMessageDialog(null, "Please add Lecturer and Tutor to display their information"); // If empty, display a message to add lecturers and tutors
                } else {
                    //If not empty, create a StringBuilder to store the information
                    StringBuilder displayInfo = new StringBuilder();
                    for (Teacher teacher : arraylist) {
                        /// Check if the teacher is an instance of Lecturer
                        if (teacher instanceof Lecturer) {
                            Lecturer lecturer = (Lecturer) teacher;
                            int id = lecturer.getTeacherId();
                            String name = lecturer.getTeacherName();
                            String workingType = lecturer.getWorkingType();
                            String address = lecturer.getAddress();
                            String employmentStatus = lecturer.getEmploymentStatus();
                            String department = lecturer.getDepartment();
                            int yearsOfExperience = lecturer.getYearsOfExperiance();
                            double gradedScore = lecturer.getGradedScore();
                            double workingHours=lecturer.getWorkingHours();

                            String lecturerInfo = "Lecturer Information:\n" + // taking lecturer information
                                    "Lecturer ID: " + id + "\n" +
                                    "Name: " + name + "\n" +
                                    "Address: " + address + "\n" +
                                    "Working Type: " + workingType + "\n" +
                                    "Employment Status: " + employmentStatus + "\n" +
                                    "Department: " + department + "\n" +
                                    "Years of Experience: " + yearsOfExperience + "\n" +
                                    "Working hours: "+ workingHours+ "\n" +
                                    "Graded Score: " + gradedScore + "\n\n";  // One newline for spacing
                            displayInfo.append(lecturerInfo);
                            //if its tutor cast to tutor and retrieve information
                        } else if (teacher instanceof Tutor) {
                            Tutor tutor = (Tutor) teacher;
                            int id = tutor.getTeacherId();
                            String name = tutor.getTeacherName();
                            String workingType = tutor.getWorkingType();
                            String address = tutor.getAddress();
                            String employmentStatus = tutor.getEmploymentStatus();
                            int workingHours = tutor.getWorkingHours();
                            double salary = tutor.getSalary();
                            String academicQualification = tutor.getAcademicQualification();
                            double performanceIndex = tutor.getPerformanceIndex();

                            String tutorInfo = "Tutor Information:\n" +  //displaying the tutor information
                                    "Lecturer ID: " + id + "\n" +
                                    "Name: " + name + "\n" +
                                    "Address: " + address + "\n" +
                                    "Working Type: " + workingType + "\n" +
                                    "Employment Status: " + employmentStatus + "\n" +
                                    "Working Hours: " + workingHours + "\n" +
                                    "Salary: " + salary + "\n" +
                                    "Academic Qualification: " + academicQualification + "\n" +
                                    "Performance Index: " + performanceIndex + "\n\n";
                            displayInfo.append(tutorInfo);
                        }
                    }
                    JOptionPane.showMessageDialog(null, displayInfo.toString());//displaying all the information
                }
            }
        });



        // GridBagLayout  for Button Panel
        GridBagLayout mainMenuGridBagLayout = new GridBagLayout();
        GridBagConstraints mainMenuGridBagConstraint = new GridBagConstraints();
        mainMenuGridBagConstraint.insets = new Insets(10, 10, 10, 10);
        mainMenuGridBagConstraint.fill = GridBagConstraints.BOTH;
        mainMenuGridBagConstraint.anchor = GridBagConstraints.CENTER;
        buttonPanel.setLayout(mainMenuGridBagLayout);


        mainMenuGridBagConstraint.gridx = 1;
        mainMenuGridBagConstraint.gridy = 0;
        buttonPanel.add(addButtonLabel, mainMenuGridBagConstraint);

        mainMenuGridBagConstraint.gridx = 1;
        mainMenuGridBagConstraint.gridy = 1;
        buttonPanel.add(addLecturerBtn, mainMenuGridBagConstraint);


        mainMenuGridBagConstraint.gridx = 1;
        mainMenuGridBagConstraint.gridy = 2;
        buttonPanel.add( addTutorBtn,mainMenuGridBagConstraint);

        mainMenuGridBagConstraint.gridx = 1;
        mainMenuGridBagConstraint.gridy = 3;
        buttonPanel.add(gradeAssignmentBtn, mainMenuGridBagConstraint);

        mainMenuGridBagConstraint.gridx = 1;
        mainMenuGridBagConstraint.gridy = 4;
        buttonPanel.add(setSalaryOfTutorBtn, mainMenuGridBagConstraint);

        mainMenuGridBagConstraint.gridx=1;
        mainMenuGridBagConstraint.gridy=5;
        buttonPanel.add(removeTutorBtn,mainMenuGridBagConstraint);

        mainMenuGridBagConstraint.gridx=1;
        mainMenuGridBagConstraint.gridy=6;
        buttonPanel.add(displayAllBtn,mainMenuGridBagConstraint);



        return buttonPanel;
    }

    //method to add lecturer and display
    private JPanel createLecturerPanel() {
        JPanel lecturerPanel = new JPanel();//creating lecturer panel

        lecturerPanel.setBackground(new Color(230, 230, 250));  //panel background is set to light purple

        JLabel addLecturerlabel = new JLabel("Add Lecturer");//label for lecturer panel
        addLecturerlabel.setFont(new Font("KRICO", Font.BOLD, 26));
        lecturerPanel.add(addLecturerlabel);

        //brings the label to the center
        addLecturerlabel.setHorizontalAlignment(JLabel.CENTER);
//

        //Label for lecturer panel
        lecturerIdLabel = customLabel("Teacher ID:");
        lecturerNameLabel = customLabel("Teacher Name:");
        lecturerAddressLabel = customLabel("Address:");
        lecturerWorkingTypeLabel = customLabel("Working Type:");
        lecturerEmploymentStatusLabel = customLabel("Employment Status:");
        lecturerDepartmentLabel = customLabel("Department:");
        lecturerGradedScoreLabel = customLabel("Graded Score:");
        lecturerYearsOfExperianceLabel = customLabel("Years of Experiance:");
        lecturerWorkingHour=  customLabel("Working Hour");


        //margin for text field
        Insets insets = new Insets(5, 10, 5, 10);
        //text field for lecturer panel
        lecturerIdTextField = customTextField(30, insets);
        lecturerNameTextField = customTextField(30, insets);
        lecturerAddressTextField = customTextField(30, insets);
        lecturerWorkingTypeTextField = customTextField(30, insets);
        lecturerEmploymentStatusTextField = customTextField(30, insets);
        lecturerDepartmentTextField = customTextField(30, insets);
        lecturerGradedScoreTextField = customTextField(30, insets);
        lecturerYearsOfExperianceTextField = customTextField(30, insets);
        lecturerWorkingHoursTextField= customTextField(30, insets);


        //margin for button
        Insets insets1 = new Insets(10, 10, 10, 10);
        addLecturerBtn = customButton("Add", insets1);
        clearLecturerBtn = customButton("Clear", insets1);
        displayLecturerBtn = customButton("Display", insets1);
        mainMenuLecturerBtn = customButton("Main Menu", insets1);

        addLecturerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Extract input from text fields
                String lecturerId = lecturerIdTextField.getText().trim();
                String lecturerName = lecturerNameTextField.getText().trim();
                String lecturerAddress = lecturerAddressTextField.getText().trim();
                String lecturerWorkingType = lecturerWorkingTypeTextField.getText().trim();
                String lecturerEmploymentStatus = lecturerEmploymentStatusTextField.getText().trim();
                String lecturerDepartment = lecturerDepartmentTextField.getText().trim();
                String lecturerGradedScore = lecturerGradedScoreTextField.getText().trim();
                String lecturerYearsOfExperience = lecturerYearsOfExperianceTextField.getText().trim();
                String lecturerWorkingHour=lecturerWorkingHoursTextField.getText().trim();

                // If any field is empty, show an alert message
                try {
                    if (lecturerId.isEmpty() || lecturerName.isEmpty() || lecturerAddress.isEmpty() || lecturerWorkingType.isEmpty() || lecturerEmploymentStatus.isEmpty() || lecturerDepartment.isEmpty() || lecturerGradedScore.isEmpty() || lecturerYearsOfExperience.isEmpty()||lecturerWorkingHour.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                    } else {
                        // Convert values to required types
                        int id = Integer.parseInt(lecturerId);
                        double gradedScore = Double.parseDouble(lecturerGradedScore);
                        int yearsOfExperience = Integer.parseInt(lecturerYearsOfExperience);
                        double workingHours=Double.parseDouble(lecturerWorkingHour);

                        // Check if a lecturer with the same ID already exists
                        boolean lecturerExists = false;
                        for (Teacher lecturer : arraylist) {
                            if (lecturer.getTeacherId() == id) {
                                lecturerExists = true;
                                break;
                            }
                        }

                        if (!lecturerExists) {
                            // Create a new lecturer object and add it to the list of lecturers
                            Lecturer newLecturer = new Lecturer(id, lecturerName, lecturerAddress, lecturerWorkingType, lecturerEmploymentStatus, lecturerDepartment, gradedScore, yearsOfExperience);
                            arraylist.add(newLecturer);
                            JOptionPane.showMessageDialog(null, "Lecturer added successfully.");

                        } else {
                            JOptionPane.showMessageDialog(null, "!!! Lecturer with this ID already exists !!!");
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "!!! Please enter valid input only: Integer value for ID and years of experience, Decimal value for graded score !!!");
                }
            }
        });


        mainMenuLecturerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ButtonPanel");

            }
        });




        //Displaying the information of lecturer
        displayLecturerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arraylist.isEmpty()) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Techer Id: " + lecturerIdTextField.getText() + "\n"
                            + "Name: " + lecturerNameTextField.getText() + "\n"
                            + "Address: " + lecturerAddressTextField.getText() + "\n"
                            + "Working Type: " + lecturerWorkingTypeTextField.getText() + "\n"
                            + "Employment Status: " + lecturerEmploymentStatusTextField.getText() + "\n"
                            + "Department: " + lecturerDepartmentTextField.getText() + "\n"
                            + "Graded Score: " + lecturerGradedScoreTextField.getText() + "\n"
                            + "Years Of Experiance: " + lecturerYearsOfExperianceTextField.getText()
                            +"working Hours" + lecturerWorkingHoursTextField.getText()
                    )
                    ;
                }
            }
        });

        clearLecturerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                lecturerIdTextField.setText("");
                lecturerNameTextField.setText("");
                lecturerAddressTextField.setText("");
                lecturerWorkingTypeTextField.setText("");
                lecturerEmploymentStatusTextField.setText("");
                lecturerDepartmentTextField.setText("");
                lecturerGradedScoreTextField.setText("");
                lecturerYearsOfExperianceTextField.setText("");
                lecturerWorkingHoursTextField.setText("");

                // Show a popup if the text field get cleared
                JOptionPane.showMessageDialog(null, "Text fields cleared");
            }
        });


        //layout for Lecturer Panel
        GridBagLayout lecturerGridBagLayout = new GridBagLayout();
        GridBagConstraints lecturerGridBagConstraint = new GridBagConstraints();
        lecturerGridBagConstraint.insets = new Insets(10, 10, 10, 10);
        lecturerGridBagConstraint.fill = GridBagConstraints.BOTH;
        lecturerGridBagConstraint.anchor = GridBagConstraints.CENTER;
        lecturerPanel.setLayout(lecturerGridBagLayout);

        /* GridBagLayout positioning each component */
        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 0;
        lecturerPanel.add(addLecturerlabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 1;
        lecturerPanel.add(lecturerIdLabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridy = 1;
        lecturerGridBagConstraint.gridx = 1;
        lecturerPanel.add(lecturerIdTextField, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 2;
        lecturerPanel.add(lecturerNameLabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 2;
        lecturerPanel.add(lecturerNameTextField, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 3;
        lecturerPanel.add(lecturerAddressLabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 3;
        lecturerPanel.add(lecturerAddressTextField, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 4;
        lecturerPanel.add(lecturerWorkingTypeLabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 4;
        lecturerPanel.add(lecturerWorkingTypeTextField, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 5;
        lecturerPanel.add(lecturerEmploymentStatusLabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 5;
        lecturerPanel.add(lecturerEmploymentStatusTextField, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 6;
        lecturerPanel.add(lecturerDepartmentLabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 6;
        lecturerPanel.add(lecturerDepartmentTextField, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 7;
        lecturerPanel.add(lecturerGradedScoreLabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 7;
        lecturerPanel.add(lecturerGradedScoreTextField, lecturerGridBagConstraint);


        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 8;
        lecturerPanel.add(lecturerYearsOfExperianceLabel, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 8;
        lecturerPanel.add(lecturerYearsOfExperianceTextField, lecturerGridBagConstraint);


        lecturerGridBagConstraint.gridx = 0;
        lecturerGridBagConstraint.gridy = 9;
        lecturerPanel.add(lecturerWorkingHour, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 9;
        lecturerPanel.add(lecturerWorkingHoursTextField, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 10;
        lecturerGridBagConstraint.gridwidth = 1;
        lecturerPanel.add(addLecturerBtn, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 2;
        lecturerGridBagConstraint.gridy = 10;
        lecturerGridBagConstraint.gridwidth = 1;
        lecturerPanel.add(displayLecturerBtn, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 1;
        lecturerGridBagConstraint.gridy = 11;
        lecturerGridBagConstraint.gridwidth = 1;
        lecturerPanel.add(clearLecturerBtn, lecturerGridBagConstraint);

        lecturerGridBagConstraint.gridx = 2;
        lecturerGridBagConstraint.gridy = 11;
        lecturerGridBagConstraint.gridwidth = 1;
        lecturerPanel.add(mainMenuLecturerBtn, lecturerGridBagConstraint);

        return lecturerPanel;
    }
    /* method that add tutor and displays the information of the tutor */
    private JPanel createTutorPanel() {
        JPanel tutorPanel = new JPanel();

        tutorPanel.setBackground(new Color(230, 230, 250));//panel background to light purple


        JLabel addTutorLabel = new JLabel("Add  Tutor");
        addTutorLabel.setFont(new Font("KRICO", Font.BOLD, 26));
        tutorPanel.add(addTutorLabel);



        //Tutor label
        tutorIdLabel = customLabel("Teacher ID:");
        tutorNameLabel = customLabel("Teacher Name:");
        tutorAddressLabel = customLabel("Address:");
        tutorEmploymentStatusLabel = customLabel("Employment Status:");
        tutorWorkingHoursLabel = customLabel("Working Hours:");
        tutorSalaryLabel = customLabel("Salary:");
        tutorSpecializationLabel = customLabel("Specialization:");
        tutorAcademicQualificationLabel = customLabel("Academic Qualification:");
        tutorPerformanceIndexLabel = customLabel("Performance Index:");
        tutorWorkingTypeLabel=customLabel("Working Type");


        //Tutor Text field
        Insets insets = new Insets(5, 10, 5, 10);
        tutorIdTextField = customTextField(30, insets);
        tutorNameTextField = customTextField(30, insets);
        tutorAddressTextField = customTextField(30, insets);
        tutorEmploymentStatusTextField = customTextField(30, insets);
        tutorWorkingHoursTextField = customTextField(30, insets);
        tutorSalaryTextField = customTextField(30, insets);
        tutorSpecializationTextField = customTextField(30, insets);
        tutorAcademicQualificationTextField = customTextField(30, insets);
        tutorPerformanceIndexTextField = customTextField(30, insets);
        tutorWorkingTypeTextField=customTextField(30,insets);


        //Buttons for tutor panel
        Insets insets1 = new Insets(10, 10, 10, 10);    //margin for button
        addTutorBtn = customButton("Add", insets1);
        clearTutorBtn = customButton("Clear", insets1);
        displayTutorBtn = customButton("Display", insets1);
        mainMenuTutorBtn = customButton("Main Menu", insets1);

    //providing function to the add tutor button
    addTutorBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String tutorId = tutorIdTextField.getText().trim();
        String tutorName = tutorNameTextField.getText().trim();
        String tutorAddress = tutorAddressTextField.getText().trim();
        String tutorEmploymentStatus = tutorEmploymentStatusTextField.getText().trim();
        String  tutorWorkingHours = tutorWorkingHoursTextField.getText().trim();
        String tutorSalary = tutorSalaryTextField.getText().trim();
        String tutorWorkingType=tutorWorkingTypeTextField.getText().trim();
        String tutorSpecialization = tutorSpecializationTextField.getText().trim();
        String tutorAcademicQualification = tutorAcademicQualificationTextField.getText().trim();
        String tutorPerformanceIndex = tutorPerformanceIndexTextField.getText().trim();


        try {
            if (tutorId.isEmpty() || tutorName.isEmpty()|| tutorAddress.isEmpty() || tutorEmploymentStatus.isEmpty() || tutorWorkingHours.isEmpty()|| tutorSalary.isEmpty() ||tutorSpecialization.isEmpty() || tutorAcademicQualification.isEmpty()|| tutorPerformanceIndex.isEmpty()) {
                JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
            } else {
                // Convert values to required types
                int id = Integer.parseInt(tutorId);
                double salary = Double.parseDouble(tutorSalary);
                int workingHours = Integer.parseInt(tutorWorkingHours);
                int performanceIndex = Integer.parseInt(tutorPerformanceIndex);

                // Check if a tutor with the same ID already exists
                boolean tutorExists = false;
                for (Teacher tutor : arraylist) {
                    if (tutor.getTeacherId() == id) {
                        tutorExists = true;
                        break;
                    }
                }

                if (!tutorExists) {
                    if (workingHours<20) {
                        JOptionPane.showMessageDialog(null, "Your salary cannot be set due to low working hours");
                    }
                        // Create a new tutor object and add it to the list of tutors
                        Tutor newTutor = new Tutor(id, tutorName, tutorWorkingType, tutorAddress, tutorEmploymentStatus, workingHours, salary, tutorSpecialization, tutorAcademicQualification, performanceIndex);
                        arraylist.add(newTutor);
                        JOptionPane.showMessageDialog(null, "Tutor added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "!!! Tutor with this ID already exists !!!");
                }
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "!!! Please enter valid input only: Integer value for ID and working hours, Decimal value for salary and performance index !!!");
        }

    }
    });




        //adding functionality to the mainMenuTutorBtn which take back to the main menu
        mainMenuTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ButtonPanel");

            }
        });

        //adding functionality to the display Btn for displaying the information
        displayTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arraylist.isEmpty()) {
                    return;
                } else {

                    JOptionPane.showMessageDialog(null,
                            "Teacher ID: " + tutorIdTextField.getText() + "\n" +
                                    "Name: " + tutorNameTextField.getText() + "\n" +
                                    "Address: " + tutorAddressTextField.getText() + "\n" +
                                    "Employment Status: " + tutorEmploymentStatusTextField.getText() + "\n" +
                                    "Working Hours: " + tutorWorkingHoursTextField.getText() + "\n" +
                                    "Salary: " + tutorSalaryTextField.getText() + "\n" +
                                    "Specialization: " + tutorSpecializationTextField.getText() + "\n" +
                                    "Academic Qualification: " + tutorAcademicQualificationTextField.getText() + "\n" +
                                    "Performance Index: " + tutorPerformanceIndexTextField.getText()
                    );
                }
            }
        });

           //clearTutorBtn will clear all the textField
        clearTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                tutorIdTextField.setText("");
                tutorNameTextField.setText("");
                tutorAddressTextField.setText("");
                tutorEmploymentStatusTextField.setText("");
                tutorWorkingHoursTextField.setText("");
                tutorSalaryTextField.setText("");
                tutorSpecializationTextField.setText("");
                tutorAcademicQualificationTextField.setText("");
                tutorPerformanceIndexTextField.setText("");

                // Show a message text  field cleared
                JOptionPane.showMessageDialog(null, "Text fields cleared");
            }
        });

        //GridBagLayout for tutor to keep the buttons,levels and text field in position
        GridBagLayout tutorGridBagLayout = new GridBagLayout();
        GridBagConstraints tutorGridBagConstraint = new GridBagConstraints();
        tutorGridBagConstraint.insets = new Insets(10, 10, 10, 10);
        tutorGridBagConstraint.fill = GridBagConstraints.BOTH;
        tutorGridBagConstraint.anchor = GridBagConstraints.CENTER;
        tutorPanel.setLayout(tutorGridBagLayout);


        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 0;
        tutorPanel.add(addTutorLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 1;
        tutorPanel.add(tutorIdLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 1;
        tutorPanel.add(tutorIdTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 2;
        tutorPanel.add(tutorNameLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 2;
        tutorPanel.add(tutorNameTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 3;
        tutorPanel.add(tutorAddressLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 3;
        tutorPanel.add(tutorAddressTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 4;
        tutorPanel.add(tutorWorkingHoursLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 4;
        tutorPanel.add(tutorWorkingHoursTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 5;
        tutorPanel.add(tutorEmploymentStatusLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 5;
        tutorPanel.add(tutorEmploymentStatusTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 6;
        tutorPanel.add(tutorWorkingHoursLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 6;
        tutorPanel.add(tutorWorkingHoursTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 7;
        tutorPanel.add(tutorSalaryLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 7;
        tutorPanel.add(tutorSalaryTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 8;
        tutorPanel.add(tutorSpecializationLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 8;
        tutorPanel.add(tutorSpecializationTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 9;
        tutorPanel.add(tutorAcademicQualificationLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 9;
        tutorPanel.add(tutorAcademicQualificationTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 0;
        tutorGridBagConstraint.gridy = 10;
        tutorPanel.add(tutorPerformanceIndexLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 10;
        tutorPanel.add(tutorPerformanceIndexTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx=0;
        tutorGridBagConstraint.gridy = 11;
        tutorPanel.add(tutorWorkingTypeLabel, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx=1;
        tutorGridBagConstraint.gridy = 11;
        tutorPanel.add(tutorWorkingTypeTextField, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 12;
        tutorGridBagConstraint.gridwidth = 1;
        tutorPanel.add(addTutorBtn, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 2;
        tutorGridBagConstraint.gridy = 12;
        tutorGridBagConstraint.gridwidth = 1;
        tutorPanel.add(displayTutorBtn, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 1;
        tutorGridBagConstraint.gridy = 13;
        tutorGridBagConstraint.gridwidth = 1;
        tutorPanel.add(clearTutorBtn, tutorGridBagConstraint);

        tutorGridBagConstraint.gridx = 2;
        tutorGridBagConstraint.gridy = 13;
        tutorGridBagConstraint.gridwidth = 1;
        tutorPanel.add(mainMenuTutorBtn, tutorGridBagConstraint);

        return tutorPanel;
    }

    //method for grading assignment which grade assignment and display
    private JPanel createGradeAssignmentsPanel() {
        JPanel gradeAssignmentsPanel = new JPanel();
        gradeAssignmentsPanel.setBackground(new Color(230, 230, 250));


        //Jlabel for grade Assignments
        JLabel gradeAssignmentsLabel = new JLabel("Grade Assignments");
        gradeAssignmentsLabel.setFont(new Font("KRICO", Font.BOLD, 20));
        gradeAssignmentsPanel.add(gradeAssignmentsLabel);


        // Grade assignment label
        assignmentTeacherIdLabel = customLabel("Teacher ID:");
        assignmentGradedScoreLabel = customLabel("Graded Score:");
        assignmentDepartmentLabel = customLabel("Department:");
        assignmentYears0fExperienceLabel = customLabel("Years of experience:");

        //Grade Assignment Text Field
        Insets insets = new Insets(5, 5, 5, 5); //margin for button
        assignmentTeacherIdTextField = customTextField(30, insets);
        assignmentGradedScoreTextField = customTextField(30, insets);
        assignmentDepartmentTextField = customTextField(30, insets);
        assignmentYears0fExperienceTextField = customTextField(30, insets);

        //Buttons for Grade Assignment Panel
        Insets insets1 = new Insets(10, 10, 10, 10); //margin for button
        gradeAssignmentBtn = customButton("Grade ", insets1);
        clearAssignmentBtn = customButton("Clear", insets1);
        displayGradedAssignmentBtn = customButton("Display", insets1);
        mainMenuAssignmentBtn = customButton("Main Menu", insets1);


        /* providing function to the grade assignment button */
        gradeAssignmentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String teacherId = assignmentTeacherIdTextField.getText().trim();
                String gradedScore = assignmentGradedScoreTextField.getText().trim();
                String department = assignmentDepartmentTextField.getText().trim();
                String yearsOfExperience = assignmentYears0fExperienceTextField.getText().trim();

                int gradedScoreId = Integer.parseInt(teacherId);
                int gScore = Integer.parseInt(gradedScore);
                int experience = Integer.parseInt(yearsOfExperience);

                try {
                    if (teacherId.isEmpty() || gradedScore.isEmpty() || department.isEmpty() || yearsOfExperience.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                    } else {
                        for (Teacher teacher : arraylist) {
                            if (teacher  instanceof Lecturer && teacher.getTeacherId() == gradedScoreId) {
                                Lecturer gradedteacher = (Lecturer)  teacher;

                                gradedteacher.gradeAssignment(gScore, department, experience);

                                JOptionPane.showMessageDialog(null, "Successfully graded Assignment of \n\tTeacher: "+ gradedScoreId);
                                return;
                            }else {
                                JOptionPane.showMessageDialog(null, "Filed to graded Assignment of \n\tTeacher: "+ gradedScoreId);
                            }
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "!!! Please enter valid input only: Integer value for ID and years of experience, Decimal value for graded score !!!");
                }
            }
        });



        //functionality for clear button which converts the text field to null
        clearAssignmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                assignmentTeacherIdTextField.setText("");
                assignmentGradedScoreTextField.setText("");
                assignmentDepartmentTextField.setText("");
                assignmentYears0fExperienceTextField.setText("");

                // Show a message or perform any other action after clearing the fields if required
                JOptionPane.showMessageDialog(null, "Text fields cleared");
            }
        });
        //proving functionality to thw grade assignment button
        displayGradedAssignmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arraylist.isEmpty()) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Teacher ID: " + assignmentTeacherIdTextField.getText() + "\n" +
                                    "Graded Score: " + assignmentGradedScoreTextField.getText() + "\n" +
                                    "Department: " + assignmentDepartmentTextField.getText() + "\n" +
                                    "Years of Experience: " + assignmentYears0fExperienceTextField.getText()
                    );
                }
            }
        });
        //giving functionality to main menu assignment button which helps the user to return to the main menu
        mainMenuAssignmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ButtonPanel");

            }
        });



        // GridBagLayout for tutor
        GridBagLayout gradeAssignmentGridBagLayout = new GridBagLayout();
        GridBagConstraints gradeAssignmentGridBagConstraint = new GridBagConstraints();
        gradeAssignmentGridBagConstraint.insets = new Insets(10, 10, 10, 10);
        gradeAssignmentGridBagConstraint.fill = GridBagConstraints.BOTH;
        gradeAssignmentGridBagConstraint.anchor = GridBagConstraints.CENTER;
        gradeAssignmentsPanel.setLayout(gradeAssignmentGridBagLayout);


        gradeAssignmentGridBagConstraint.gridx = 1;
        gradeAssignmentGridBagConstraint.gridy = 0;
        gradeAssignmentsPanel.add(gradeAssignmentsLabel, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 0;
        gradeAssignmentGridBagConstraint.gridy = 1;
        gradeAssignmentsPanel.add(assignmentTeacherIdLabel, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 1;
        gradeAssignmentGridBagConstraint.gridy = 1;
        gradeAssignmentsPanel.add(assignmentTeacherIdTextField, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 0;
        gradeAssignmentGridBagConstraint.gridy = 2;
        gradeAssignmentsPanel.add(assignmentGradedScoreLabel, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 1;
        gradeAssignmentGridBagConstraint.gridy = 2;
        gradeAssignmentsPanel.add(assignmentGradedScoreTextField, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 0;
        gradeAssignmentGridBagConstraint.gridy = 3;
        gradeAssignmentsPanel.add(assignmentDepartmentLabel, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 1;
        gradeAssignmentGridBagConstraint.gridy = 3;
        gradeAssignmentsPanel.add(assignmentDepartmentTextField, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 0;
        gradeAssignmentGridBagConstraint.gridy = 4;
        gradeAssignmentsPanel.add(assignmentYears0fExperienceLabel, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 1;
        gradeAssignmentGridBagConstraint.gridy = 4;
        gradeAssignmentsPanel.add(assignmentYears0fExperienceTextField, gradeAssignmentGridBagConstraint);


        gradeAssignmentGridBagConstraint.gridx = 1;
        gradeAssignmentGridBagConstraint.gridy = 5;
        gradeAssignmentGridBagConstraint.gridwidth = 1;
        gradeAssignmentsPanel.add(gradeAssignmentBtn, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 2;
        gradeAssignmentGridBagConstraint.gridy = 5;
        gradeAssignmentGridBagConstraint.gridwidth = 1;
        gradeAssignmentsPanel.add(displayGradedAssignmentBtn, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 1;
        gradeAssignmentGridBagConstraint.gridy = 6;
        gradeAssignmentGridBagConstraint.gridwidth = 1;
        gradeAssignmentsPanel.add(clearAssignmentBtn, gradeAssignmentGridBagConstraint);

        gradeAssignmentGridBagConstraint.gridx = 2;
        gradeAssignmentGridBagConstraint.gridy = 6;
        gradeAssignmentGridBagConstraint.gridwidth = 1;
        gradeAssignmentsPanel.add(mainMenuAssignmentBtn, gradeAssignmentGridBagConstraint);




        return gradeAssignmentsPanel;
    }
    //method which sets salary and display to the user
    private JPanel createSetSalaryPanel() {
        JPanel setSalaryPanel = new JPanel();
        setSalaryPanel.setBackground(new Color(230, 230, 250));


        //JLabel for Set salary
        JLabel setSalaryLabel = new JLabel("Set Salary");
        setSalaryLabel.setFont(new Font("KRICO", Font.BOLD, 26));
        setSalaryPanel.add(setSalaryLabel);

        //JLabel for set salary
        salaryTutorIdLabel = customLabel("Teacher ID:");
        salaryTutorNewSalaryLabel = customLabel("New Salary:");
        salaryTutorNewPerformanceIndexLabel = customLabel("New Performance Index:");

        //JTextfield for set Salary
        Insets insets = new Insets(5, 10, 5, 10);
        salaryTutorIdTextField = customTextField(30, insets);
        salaryTutorNewSalaryTextField = customTextField(30, insets);
        salaryTutorNewPerformanceIndexTextField = customTextField(30, insets);

        //Button for SetSalary Panel
        Insets insets1 = new Insets(10, 10, 10, 10); //margin for button
        setSalaryOfTutorBtn = customButton("Set Salary", insets1);
        clearSetSalaryBtn = customButton("Clear", insets1);
        displaySalaryBtn = customButton("Display", insets1);
        mainMenuSetSalaryBtn = customButton("Main Menu", insets1);

        //adding functionality to the set salary of tutor button which sets the salary of the tutor
        setSalaryOfTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tutorId = salaryTutorIdTextField.getText().trim();
                String newSalary = salaryTutorNewSalaryTextField.getText().trim();
                String newPerformanceIndex = salaryTutorNewPerformanceIndexTextField.getText().trim();
                // If any field is empty, show an alert message
                try {

                    if (tutorId.isEmpty() || newSalary.isEmpty() || newPerformanceIndex.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                    } else {
                        // Convert values to required types
                        int id = Integer.parseInt(tutorId);
                        double salary = Double.parseDouble(newSalary);
                        int performanceIndex = Integer.parseInt(newPerformanceIndex);

                        // Check if a tutor with the given ID exists
                        boolean tutorExists = false;
                        for (Teacher teacher : arraylist) {
                            if (teacher instanceof Tutor && teacher.getTeacherId()==id ) {
                                Tutor newTeacher=(Tutor)teacher;
                                newTeacher.setSalary(salary,performanceIndex);
                                if (teacher.getWorkingHours()>20) {
                                    JOptionPane.showMessageDialog(null, "Salary and Performance Index set successfully for Tutor ID: " + id);
                                }else{
                                   JOptionPane.showMessageDialog(null,"Cannot set due to low working hours");
                                }
                                tutorExists = true;
                                break;
                            }
                        }

                        if (!tutorExists) {
                            JOptionPane.showMessageDialog(null, "!!! Tutor with this ID does not exist !!!");
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "!!! Please enter valid input only: Integer value for ID, Decimal value for salary and performance index !!!");
                }
            }
        });



        clearSetSalaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                salaryTutorIdTextField.setText("");
                salaryTutorNewSalaryTextField.setText("");
                salaryTutorNewPerformanceIndexTextField.setText("");

                // Show a message or perform any other action after clearing the fields if required
                JOptionPane.showMessageDialog(null, "Text fields cleared");
            }
        });

        displaySalaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arraylist.isEmpty()) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Teacher ID: " + salaryTutorIdTextField.getText() + "\n" +
                                    "New Salary: " + salaryTutorNewSalaryTextField.getText() + "\n" +
                                    "New Performance Index: " + salaryTutorNewPerformanceIndexTextField.getText()
                    );
                }
            }
        });

        mainMenuSetSalaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ButtonPanel");

            }
        });


        //GridBagLayout for tutor for positioning the labels,buttons and text field
        GridBagLayout setSalaryGridBagLayout = new GridBagLayout();
        GridBagConstraints setSalaryGridBagConstraint = new GridBagConstraints();
        setSalaryGridBagConstraint.insets = new Insets(10, 10, 10, 10);
        setSalaryGridBagConstraint.fill = GridBagConstraints.BOTH;
        setSalaryGridBagConstraint.anchor = GridBagConstraints.CENTER;
        setSalaryPanel.setLayout(setSalaryGridBagLayout);


        setSalaryGridBagConstraint.gridx = 1;
        setSalaryGridBagConstraint.gridy = 0;
        setSalaryPanel.add(setSalaryLabel, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 0;
        setSalaryGridBagConstraint.gridy = 1;
        setSalaryPanel.add(salaryTutorIdLabel, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 1;
        setSalaryGridBagConstraint.gridy = 1;
        setSalaryPanel.add(salaryTutorIdTextField, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 0;
        setSalaryGridBagConstraint.gridy = 2;
        setSalaryPanel.add(salaryTutorNewSalaryLabel, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 1;
        setSalaryGridBagConstraint.gridy = 2;
        setSalaryPanel.add(salaryTutorNewSalaryTextField, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 0;
        setSalaryGridBagConstraint.gridy = 3;
        setSalaryPanel.add(salaryTutorNewPerformanceIndexLabel, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 1;
        setSalaryGridBagConstraint.gridy = 3;
        setSalaryPanel.add(salaryTutorNewPerformanceIndexTextField, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 1;
        setSalaryGridBagConstraint.gridy = 4;
        setSalaryGridBagConstraint.gridwidth = 1;
        setSalaryPanel.add(setSalaryOfTutorBtn, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 2;
        setSalaryGridBagConstraint.gridy = 4;
        setSalaryGridBagConstraint.gridwidth = 1;
        setSalaryPanel.add(displaySalaryBtn, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 1;
        setSalaryGridBagConstraint.gridy = 5;
        setSalaryGridBagConstraint.gridwidth = 1;
        setSalaryPanel.add(clearSetSalaryBtn, setSalaryGridBagConstraint);

        setSalaryGridBagConstraint.gridx = 2;
        setSalaryGridBagConstraint.gridy = 5;
        setSalaryGridBagConstraint.gridwidth = 1;
        setSalaryPanel.add(mainMenuSetSalaryBtn, setSalaryGridBagConstraint);

        return setSalaryPanel;
    }


    //method that removes the tutor that had been added in the add tutor method
    private JPanel createRemoveTutorPanel() {
        JPanel removeTutorPanel = new JPanel();
        removeTutorPanel.setBackground(new Color(230, 230, 250));
        //JLabel for remove tutor
        JLabel removeTutorLabel = new JLabel("Remove Tutor");
        removeTutorLabel.setFont(new Font("KRICO", Font.BOLD, 26));
        removeTutorPanel.add( removeTutorLabel);

        //JLabel for remove tutor
        JLabel tutorRemoveIdLabel = customLabel("Teacher ID:");
        tutorRemoveIdLabel.setFont(new Font("KRICO", Font.PLAIN, 18));


        //JTextfield for remove tutor
        Insets insets = new Insets(5, 10, 5, 10);
        removeTutorTextField = customTextField(60, insets);

        //Button for remove tutor Panel
        Insets insets1 = new Insets(10, 10, 10, 10); //margin for button
        removeTutorBtn= customButton("Remove Tutor", insets1);
        clearRemoveTutorBtn = customButton("Clear", insets1);
        displayRemoveTutorBtn = customButton("Display", insets1);
        mainMenuRemoveTutorBtn = customButton("Main Menu", insets1);
        //adding functionality to main menu remove tutor button which takes user to the main panel
        mainMenuRemoveTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ButtonPanel");
            }
        });
        //adding functionality to remove tutor button which remove tutor
        removeTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(removeTutorTextField.getText());
                boolean found=false;
                for (Teacher teacher : arraylist) {
                    if (teacher instanceof Tutor && teacher.getTeacherId()==id ) {
                        found=true;
                        Tutor newTeacher=(Tutor)teacher;
                        newTeacher.removeTutor();
                        JOptionPane.showMessageDialog(null, "Tutor removed successfully");
                        break;
                    }
                }
                if(!found){
                    JOptionPane.showMessageDialog(null, "Tutor with id: "+ id+" doesn't exist!");

                }

            }
        });
        //adding functionality to remove tutor button which displays message
        displayRemoveTutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arraylist.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Array is empty: \n No teacher with id: "+ removeTutorTextField.getText());
                    return;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Tutor ID "+ removeTutorTextField.getText());
                }

            }
        });


        //GridBagLayout for the remove tutor panel
        GridBagLayout removeTutorGridBagLayout = new GridBagLayout();
        GridBagConstraints removeTutorGridBagConstraint = new GridBagConstraints();
        removeTutorGridBagConstraint.insets = new Insets(10, 10, 10, 10);
        removeTutorGridBagConstraint.fill = GridBagConstraints.BOTH;
        removeTutorGridBagConstraint.anchor = GridBagConstraints.CENTER;
        removeTutorPanel.setLayout(removeTutorGridBagLayout);


        removeTutorGridBagConstraint.gridx = 2;
        removeTutorGridBagConstraint.gridy = 0;
        removeTutorGridBagConstraint.gridwidth=2;
        removeTutorPanel.add(tutorRemoveIdLabel, removeTutorGridBagConstraint);

        removeTutorGridBagConstraint.gridx = 0;
        removeTutorGridBagConstraint.gridy = 1;
        removeTutorPanel.add(tutorRemoveIdLabel, removeTutorGridBagConstraint);

        removeTutorGridBagConstraint.gridx = 1;
        removeTutorGridBagConstraint.gridy = 1;
        removeTutorPanel.add(removeTutorTextField, removeTutorGridBagConstraint);

        removeTutorGridBagConstraint.gridx = 1;
        removeTutorGridBagConstraint.gridy = 2;
        removeTutorGridBagConstraint.gridwidth=1;
        removeTutorPanel.add(removeTutorBtn, removeTutorGridBagConstraint);

        removeTutorGridBagConstraint.gridx = 2;
        removeTutorGridBagConstraint.gridy = 2;
        removeTutorGridBagConstraint.gridwidth=1;
        removeTutorPanel.add(clearRemoveTutorBtn, removeTutorGridBagConstraint);

        removeTutorGridBagConstraint.gridx = 1;
        removeTutorGridBagConstraint.gridy = 3;
        removeTutorGridBagConstraint.gridwidth=1;
        removeTutorPanel.add(displayRemoveTutorBtn, removeTutorGridBagConstraint);

        removeTutorGridBagConstraint.gridx = 2;
        removeTutorGridBagConstraint.gridy = 3;
        removeTutorGridBagConstraint.gridwidth=1;
        removeTutorPanel.add(mainMenuRemoveTutorBtn, removeTutorGridBagConstraint);




        return removeTutorPanel;
    }
    // calling main method by making the object
    public static void main(String[] args) {

        new TeacherGUI();
    }



 }
