public class CNPJHandler {
    /**
     * Returns true if given CNPJ can be validated; false otherwise.
     *
     * @param cnpj an int array representing the CNPJ digits
     * @throws IllegalArgumentException if the given CNPJ is not 14 digits long
     * @return boolean value
     */
    public static boolean validateCNPJ(int[] cnpj) {
        int val1, val2;
        if (cnpj.length != 14) {
            throw new IllegalArgumentException("CNPJ is not 14 digits long.");
        }

        // calculates the first verifying digit
        val1 = 5 * cnpj[0] + 4 * cnpj[1] + 3 * cnpj[2] + 2 * cnpj[3];
        val1 += 9 * cnpj[4] + 8 * cnpj[5] + 7 * cnpj[6] + 6 * cnpj[7];
        val1 += 5 * cnpj[8] + 4 * cnpj[9] + 3 * cnpj[10] + 2 * cnpj[11];
        val1 = 11 - (val1 % 11);
        if (val1 >= 10) {
            val1 = 0;
        }

        // calculates the second verifying digit
        val2 = 6 * cnpj[0] + 5 * cnpj[1] + 4 * cnpj[2] + 3 * cnpj[3];
        val2 += 2 * cnpj[4] + 9 * cnpj[5] + 8 * cnpj[6] + 7 * cnpj[7];
        val2 += 6 * cnpj[8] + 5 * cnpj[9] + 4 * cnpj[10] + 3 * cnpj[11];
        val2 += 2 * cnpj[12];
        val2 = 11 - (val2 % 11);
        if (val2 >= 10) {
            val2 = 0;
        }

        // compares the obtained validation values with the ones present in the given CNPJ
        return val1 == cnpj[12] && val2 == cnpj[13];
    }

    /**
     * Returns true if given CNPJ can be validated; false otherwise.
     *
     * @param formattedCNPJ a String representing a formatted CNPJ number
     * @throws IllegalArgumentException if the given CNPJ is not properly formatted
     * @return boolean value
     */
    public static boolean validateCNPJ(String formattedCNPJ) {
        int[] cnpj = parseCNPJ(formattedCNPJ); // extracts cnpj from the formatted string

        return validateCNPJ(cnpj);
    }

    /**
     * Returns true if given CNPJ is formatted as in the following pattern: XX.XXX.XXX/YYYY-ZZ
     *
     * @param formattedCNPJ a String representing a formatted CNPJ number
     * @return boolean value
     */
    public static boolean CNPJIsFormatted(String formattedCNPJ) {
        // TODO: reimplementar com regex
        // TODO: mudar para considerar uma String só com números
        return formattedCNPJ.length() == 18 && formattedCNPJ.charAt(2) == '.' &&
                formattedCNPJ.charAt(6) == '.' && formattedCNPJ.charAt(10) == '/' &&
                formattedCNPJ.charAt(15) == '-';
    }

    /**
     * Parses a CNPJ number from a String with the following format: XX.XXX.XXX/YYYY-ZZ
     *
     * @param formattedCNPJ a String representing a formatted CNPJ number
     * @throws IllegalArgumentException if the given CNPJ is not properly formatted
     * @return int array representing the parsed CNPJ
     */
    private static int[] parseCNPJ(String formattedCNPJ) {
        int[] cnpj = new int[14];
        int cnpjIndex = 0;

        if (!CNPJIsFormatted(formattedCNPJ)) {
            throw new IllegalArgumentException("CNPJ is not properly formatted.");
        }

        for (int i = 0; i < formattedCNPJ.length(); i++) {
            if (Character.isDigit(formattedCNPJ.charAt(i))) {
                cnpj[cnpjIndex] = Character.getNumericValue(formattedCNPJ.charAt(i));
                cnpjIndex += 1;
            }
        }

        return cnpj;
    }
}
