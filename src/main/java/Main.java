import managgers.App;

/**
 * <h3> Main class to run the program. </h3>
 *
 * @author Szabó Kristóf Gyula - ZSRYPQ
 * @author Völgyes Viktor - NEPTUN
 *
 * @version 1.0
 * @since 2022.05.15
 */
class Main {

    /**
     * <h3> Main method to run the program. </h3>
     * @param args we don't use this parameter
     */
    public static void main(String[] args) {
        App app = new managgers.App();
        app.run();
    }
}
