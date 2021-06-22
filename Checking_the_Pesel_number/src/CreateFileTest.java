import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreateFileTest {
    private boolean isEmptyDir() {
        File pathToTestDir = new File("list_of_saved_residents");
        return Objects.requireNonNull(pathToTestDir.list()).length <= 0;
    }

    private void deleteDir(File dirToDelete) {

        File[] files = dirToDelete.listFiles();
        if (files != null) {
            for (final File file : files) {
                deleteDir(file);
            }
        }
        dirToDelete.delete();
    }

    @Test
    public void ListOfSavedResidentsIsCreated() {

        deleteDir(new File("list_of_saved_residents"));
        List<Resident> residents = new ArrayList<>();
        ResidentsProcessor.saveResidents(residents);
        assertFalse(isEmptyDir());
    }
}
