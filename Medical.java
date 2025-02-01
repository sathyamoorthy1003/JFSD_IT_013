import java.util.Scanner;


interface HospitalOperations {
    void scheduleAppointment(String patientName, String doctorName);
    void dischargePatient(String patientName);
    void checkDoctorAvailability(String doctorName);
    void displayPatientRecords();
}


abstract class Patient {
    protected String patientName;
    protected int patientId;
    protected String medicalHistory;

    public Patient(String patientName, int patientId, String medicalHistory) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.medicalHistory = medicalHistory;
    }


    public abstract void displayDetails();
}


class Inpatient extends Patient {
    private String roomNumber;

    public Inpatient(String patientName, int patientId, String medicalHistory, String roomNumber) {
        super(patientName, patientId, medicalHistory);
        this.roomNumber = roomNumber;
    }

    
    public void displayDetails() {
        System.out.println("Inpatient Details:");
        System.out.println("Name: " + patientName);
        System.out.println("ID: " + patientId);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Room Number: " + roomNumber);
    }
}

class Outpatient extends Patient {
    private String appointmentDate;

    public Outpatient(String patientName, int patientId, String medicalHistory, String appointmentDate) {
        super(patientName, patientId, medicalHistory);
        this.appointmentDate = appointmentDate;
    }

    public void displayDetails() {
        System.out.println("Outpatient Details:");
        System.out.println("Name: " + patientName);
        System.out.println("ID: " + patientId);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Appointment Date: " + appointmentDate);
    }
}

class HospitalManagementSystem implements HospitalOperations {
    private Patient[] patients = new Patient[100];
    private int patientCount = 0; 

    
    public void scheduleAppointment(String patientName, String doctorName) {
        System.out.println("Appointment scheduled for " + patientName + " with Dr. " + doctorName);
    }

    
    public void dischargePatient(String patientName) {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].patientName.equals(patientName)) {
                System.out.println("Patient " + patientName + " has been discharged.");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    
    public void checkDoctorAvailability(String doctorName) {
        System.out.println("Dr. " + doctorName + " is available today.");
    }

    
    public void displayPatientRecords() {
        if (patientCount == 0) {
            System.out.println("No patient records found!");
            return;
        }
        for (int i = 0; i < patientCount; i++) {
            patients[i].displayDetails();
            System.out.println("-----------------------------");
        }
    }

    public void addPatient(Patient patient) {
        if (patientCount < patients.length) {
            patients[patientCount] = patient;
            patientCount++;
            System.out.println("Patient added successfully!");
        } else {
            System.out.println("Hospital at full capacity!");
        }
    }
}

public class Medical{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalManagementSystem hospital = new HospitalManagementSystem();

        boolean running = true;
        while (running) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. Discharge Patient");
            System.out.println("3. Check Doctor Availability");
            System.out.println("4. Add Patient");
            System.out.println("5. Display Patient Records");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    hospital.scheduleAppointment(patientName, doctorName);
                    break;
                case 2:
                    System.out.print("Enter patient name to discharge: ");
                    String dischargeName = scanner.nextLine();
                    hospital.dischargePatient(dischargeName);
                    break;
                case 3:
                    System.out.print("Enter doctor name to check availability: ");
                    String checkDoctor = scanner.nextLine();
                    hospital.checkDoctorAvailability(checkDoctor);
                    break;
                case 4:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter medical history: ");
                    String history = scanner.nextLine();
                    System.out.print("Is the patient an Inpatient (I) or Outpatient (O)? ");
                    char type = scanner.nextLine().charAt(0);
                    if (type == 'I' || type == 'i') {
                        System.out.print("Enter room number: ");
                        String room = scanner.nextLine();
                        hospital.addPatient(new Inpatient(name, id, history, room));
                    } else if (type == 'O' || type == 'o') {
                        System.out.print("Enter appointment date: ");
                        String date = scanner.nextLine();
                        hospital.addPatient(new Outpatient(name, id, history, date));
                    } else {
                        System.out.println("Invalid patient type!");
                    }
                    break;
                case 5:
                    hospital.displayPatientRecords();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}