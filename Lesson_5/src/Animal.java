public class Animal {
    private static int count = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        System.out.println("животное пробежало " + distance + "м.");
    }

    public void swim(int distance) {
        System.out.println("животное проплыло " + distance + "м.");
    }
}
