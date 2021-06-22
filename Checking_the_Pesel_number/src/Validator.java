public class Validator {
    public static boolean validatePesel(String tmpPesel) {

        try {
            int[] numberWeight = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
            int sum = 0;

            if (tmpPesel.length() != 11) {
                return false;
            }

            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(tmpPesel.substring(i, i + 1)) * numberWeight[i];
            }

            int controlDigit = Integer.parseInt(tmpPesel.substring(10, 11));

            sum %= 10;
            sum = 10 - sum;
            sum %= 10;

            return (sum == controlDigit);

        } catch (Exception e) {
            return false;
        }
    }
}
