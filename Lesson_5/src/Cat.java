import java.util.ArrayList;

public class Cat extends Animal {
    private static int catCount = 0;
    public static ArrayList<Cat> catsArrayList = new ArrayList<>();
    private boolean isFull = false;

    public Cat(String name) {
        super(name);
        catCount++;
        catsArrayList.add(this);
    }

    public static void createCats(String... names) {
        for (String i : names) {
            new Cat(i);
        }
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean eat(Bowl bowl, int amount) {
        if (bowl.feedCat(amount)) {
            isFull = true;
            System.out.println("кот понямал " + amount + " единиц еды.");
            return true;
        } else {
            System.out.println("недостаточно еды в миске.");
            return false;
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static void printAllCats() {
        for (Cat i : Cat.catsArrayList) {
            System.out.println(i.toString());
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("кот пробежал " + distance + "м.");
        } else {
            System.out.println("кот не может бежать больше 200м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("кот не умеет плавать ");
    }

    @Override
    public String toString() {
        return "Кот " + name + ". Сыт ли?: " + (isFull ? "сыт" : "голоден");
    }
}
