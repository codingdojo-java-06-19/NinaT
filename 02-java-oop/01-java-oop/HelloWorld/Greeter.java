public class Greeter {
    public String greet(String name) {
        return createGreeting(name);
    }

    public String greet() {
        return createGreeting("World");
    }

    public String greet(String firstName, String lastName) {
        System.out.println("We are about to greet " + firstName);
        return createGreeting(firstName + " " + lastName);
    }

    // private means that the createGreeting method is only accessible within our
    // Greeter class
    private String createGreeting(String toBeGreeted) {
        return "Greetings " + toBeGreeted + ", welcome to coding dojo!";
    }

    public static void testGreeting(String name) {
        System.out.println("This is a test of a static method, " + name);
    }
}