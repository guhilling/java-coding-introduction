public class ArgumentUtils {
    public static void main(String[] args) {
        printArgs(args);
    }

    public static void printArgs(String[] args) {
        for(int index = 0; index < args.length; index++) {
            print("args[" + index + "]: " + args[index]);
            print("args: " + (index+1) + "/" + args.length);
        }
        for (String arg : args) {
            print(arg);
        }
        int index = 0;
        while(index< args.length) {
            print(args[index++]);
        }

        if(args.length == 0) {
            print("no args supplied");
        } else {
            if(args.length == 1) {
                print("arg: " + args[0]);
            } else {
                for (String arg : args) {
                    print(arg);
                }
            }
        }
        print("switch: ");
        print(formatArgs(args));
    }

    public static String formatArgs(String[] args) {
        switch (args.length) {
            case 0:
                return "no args supplied";
            case 1:
                return "one arg: " + args[0];
            default:
                String result="";
                for (String arg : args) {
                    result = result + arg + " ";
                }
                return result;
        }
    }

    private static void print(String output) {
        System.out.println(output);
    }
}
