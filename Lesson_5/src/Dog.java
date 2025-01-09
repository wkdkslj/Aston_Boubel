public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("собака пробежала " + distance + "м.");
        } else {
            System.out.println("собака не может бежать больше 500м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("собака проплыла " + distance + "м.");
        } else {
            System.out.println("собака не может плыть больше 10м.");
        }
    }
}
