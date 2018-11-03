public class Age implements Process {

    protected final String PROMPT = "In the Input line, please enter " +
                                    "an age (the sentinel is ";
    protected final int SENTINEL = -1;
    protected int highestAge;
    protected GUI gui;

    // Postcondition: This Age has been initialized.
    public Age() {           // default constructor
         gui = new GUI (this);
         gui.print(PROMPT + SENTINEL + "): ");
    }

    // Postcondition: The input string s has been processed.
    public void processInput(String s) {
        final String HIGHEST_MESSAGE = "\nThe highest age is ";
        final String CLOSE_WINDOW_PROMPT = "\nThe execution of this project has " +
                     "been completed.\nPlease close this window when you are ready.";

        gui.println(s);
        int age = Integer.parseInt(s);
        if (age != SENTINEL) {  // not the sentinel
            if (age > highestAge) highestAge = age;
            gui.print(PROMPT + SENTINEL + "): ");

        } else {                // sentinel reached
            gui.println(HIGHEST_MESSAGE + highestAge + CLOSE_WINDOW_PROMPT);
            gui.freeze( );
        }
    }

    public static void main(String argv[]) {
        Age age = new Age();
    }

}

