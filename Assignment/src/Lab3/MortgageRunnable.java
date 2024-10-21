package Lab3;

public class MortgageRunnable {
    public static void main(String[] args) {
        Mortgage businessMortgage = new BusinessMortgage("123456", "John Hill", 100000, 0.04, 3);

        businessMortgage.getMortgageInfo();

        Mortgage personalMortagae = new PersonalMortgage("654321", "Peter Parker",
                200000, 0.05, 4);

        personalMortagae.getMortgageInfo();

    }



}
