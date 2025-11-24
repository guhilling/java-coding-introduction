public class ControlStructures {
    public static void main(String[] args) {
        System.out.println(args.toString());
        int numArguments = args.length;
        if(numArguments == 0) {
            System.err.println("no args");
        } else {
            for(int currentArg=0; currentArg < numArguments; currentArg++) {
                System.out.println(args[currentArg]);
            }
        }
    }
}
