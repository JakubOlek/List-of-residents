import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ResidentsProcessor {
    public static final String redColour = "\u001B[31m";
    public static final String resetColour = "\u001B[0m";
    Scanner userInput = new Scanner(System.in);
    List<Resident> residents = new ArrayList<>();
    String continueAdding;

    public void process() {
        do {
            String tmpCity;
            String tmpName;
            String tmpSurname;
            String tmpPesel;

            println("Podaj nazwę miasta: ");
            tmpCity = userInput.nextLine();

            println("Podaj imię: ");
            tmpName = userInput.nextLine();

            println("Podaj nazwisko: ");
            tmpSurname = userInput.nextLine();

            println("Podaj PESEL: ");
            tmpPesel = userInput.nextLine();

            while (!Validator.validatePesel(tmpPesel)) {
                println("Podano niepoprawny numer pesel. Proszę spróbować jeszcze raz:");
                tmpPesel = userInput.nextLine();
            }

            for (Resident currentlyResident : residents) {
                if (currentlyResident.getPesel().equals(tmpPesel)) {
                    currentlyResident.setCity(tmpCity);
                    currentlyResident.setName(tmpName);
                    currentlyResident.setSurname(tmpSurname);
                }
            }

            Resident newResident = new Resident(tmpCity, tmpName, tmpSurname, tmpPesel);
            residents.add(newResident);

            println("\nAby dodać kolejną osobę wciśnij: " + redColour + "enter" + resetColour);
            println("Aby zakończyć wpisz: " + redColour + "exit" + resetColour);
            continueAdding = userInput.nextLine();

        } while (!continueAdding.equalsIgnoreCase("exit"));

        saveResidents(residents);
    }

    private static void println(String text) {
        System.out.println(text);
    }

    public static void saveResidents(List<Resident> residents) {
        try {
            String createdFileName = new SimpleDateFormat("'Residents_'yyyy-MM-dd_HH-mm-ss'.txt'").format(new Date());

            File savedResidentsDir = new File("list_of_saved_residents");
            if (!savedResidentsDir.exists()) {
                savedResidentsDir.mkdirs();
            }

            File residentsFile = new File(savedResidentsDir + "/" + createdFileName);
            if (residentsFile.createNewFile()) {
                println("\nPlik " + residentsFile.getName() + " został stworzony : \"" + residentsFile.getAbsolutePath() + "\" \n");

                FileWriter writeToFile = new FileWriter(residentsFile.getAbsolutePath());

                for (Resident currentlyResident : residents) {
                    writeToFile.write(currentlyResident.toWriteableLine());
                }

                writeToFile.flush();
                writeToFile.close();

                println("Dane zostały zapisane");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


