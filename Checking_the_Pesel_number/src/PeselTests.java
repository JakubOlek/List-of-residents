import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeselTests {

    @Test
    public void peselIsCorrect() {
        assertTrue(Validator.validatePesel("04320596335"));
        assertTrue(Validator.validatePesel("90073138337"));
    }

    @Test
    public void peselHadTooManyCharacters() {
        assertFalse(Validator.validatePesel("04320596306506535"));
        assertFalse(Validator.validatePesel("002303200006535"));
    }

    @Test
    public void peselHadTooLessCharacters() {
        assertFalse(Validator.validatePesel("56535"));
        assertFalse(Validator.validatePesel("15"));
    }

    @Test
    public void peselHadIllegalCharacters() {
        assertFalse(Validator.validatePesel("9!07D1^X3C7"));
        assertFalse(Validator.validatePesel("AB07D$2H1C0"));
    }
}
