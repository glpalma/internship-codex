public class Tester {
    public static void main(String[] args) {
        System.out.println(CNPJHandler.validateCNPJ("06.990.590/0001-23")); // Google -> true
        int[] googleCNPJ = {0,6,9,9,0,5,9,0,0,0,0,1,2,3};
        System.out.println(CNPJHandler.validateCNPJ(googleCNPJ)); // Google -> true
        System.out.println(CNPJHandler.validateCNPJ("00.623.904/0001-73")); // Apple brasil -> true
        System.out.println(CNPJHandler.validateCNPJ("00.623.904/0001-90")); // wrong Apple brasil -> false
        System.out.println(CNPJHandler.validateCNPJ("00.623.904/0001-9")); // wrong format -> raises exception
    }
}
