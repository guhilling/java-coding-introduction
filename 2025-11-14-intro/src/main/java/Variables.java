/**
 * Demo for definition and usage of primitive types as well as
 * {@link String}
 */
public class Variables {
    public static void main(String[] args) {
        String name = "Gunnar";
        int age =54;
        // Strings can be created ("concatenated") using a + sign.
        System.out.println(name + " is " + age + " years old.");
        boolean married = true;
        String no = "61";
        System.out.println("married? " + married + ", living in no. " + no + ".");
        int a=2;
        int b=14;
        System.out.println(a * b);
        float c=3.14f;
        System.out.println(a * c);

        System.out.println("This building in no. " + a*b);
    }
}
