package patientintake;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClinicMain {

    private static ClinicCalendar calendar;

    public static void main(String[] args) throws Throwable {
        calendar = new ClinicCalendar();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Patient Intake Computer System!\n\n");
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("x")) {
            lastOption = displayMenu(scanner);
        }
        System.out.println("\nExiting System...\n");

    }

    private static String displayMenu(Scanner scanner) throws Throwable {
        System.out.println("Please select an option: ");
        System.out.println("1. Enter a Patient Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("X. Exit System.");
        System.out.println("Option: ");
        String option = scanner.next();
        switch (option) {
            case "1":
                performPatientEntry(scanner);
                return option;
            case "2":
                performAllAppointments();
                return option;
            default:
                System.out.println("Invalid option, please re-enter.");
                return option;
        }
    }

    private static void performPatientEntry(Scanner scanner) {
        scanner.nextLine();
        System.out.println("\n\nPlease Enter Appointment Info:");
        System.out.println(" Patient Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println(" Patient First Name: ");
        String firstName = scanner.nextLine();
        System.out.println(" Appointment Date: (M/d/yyyy h:m a):");
        String when = scanner.nextLine();
        System.out.println(" Doctor Last Name: ");
        String doc = scanner.nextLine();

        try {
            calendar.addAppoinment(firstName, lastName, doc, when);
        } catch (Throwable t) {
            System.out.println("Error! " + t.getMessage());
            return;
        }
        System.out.println("Patient entered sucessfully.\n\n");
    }

    private static void performAllAppointments() throws Throwable {
        System.out.println("\n\nAllAppointments in System:");
        for (PatientAppointment appoinment : calendar.getAppointments()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a");
            String appTime = formatter.format(appoinment.getAppointmentDateTime());
            System.out.println(String.format("%s: %s, %s\t\tDoctor: %s", appTime, appoinment.getPatientLastName(), appoinment.getPatientFirstName(), appoinment.getDoctor().getName()));
        }
        System.out.println("\nPress any key to continue...");
    }

}
