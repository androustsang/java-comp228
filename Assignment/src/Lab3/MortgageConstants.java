package Lab3;

interface MortgageConstants {

    // All fields in an interface are implicitly public, static and final
    int SHORT_TERM = 1; // 1 year for short-term
    int MEDIUM_TERM = 3; // 3 years for medium-term
    int LONG_TERM = 5; // 5 years for long-term
    int[] MORTGAGE_TERM_ALLOWED = {SHORT_TERM, MEDIUM_TERM, LONG_TERM};
    String BANKNAME = "CityToronto";
    int MAX_MORTGAGE_AMT = 300000; // Maximum Mortgage Amount
}
