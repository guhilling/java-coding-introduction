/**
 * Version of the simplest possible program for Java.
 */
public class HelloWorld {
    /**
     * Method called when a class is run from the command line
     * using <code>java -jar &lt;archive.jar></code>
     * <br/>
     * This is a Javadoc comment, started with <code>/**</code> and
     * closed with <code>&#47;</code> as usual.
     * <br/>
     * Sample:
     * <pre>
     *     /**
     *      * This is a correctly formatted Javadoc comment.
     *      *&#47;
     * </pre>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        /*
            Call the static method println from the constant out.
            This is _not_ a javadoc comment. So no special syntax is used here
            as it's purely for instructional purposes.
         */
        System.out.println("Hello, Osnabrück!");
        // Goodbye message
        System.out.println("Goodbye");
    }
}
