//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик");
        System.out.println("имя собаки: " + dog.getName());
        dog.run(150);
        dog.swim(5);
        Dog dog1 = new Dog("Бублик");
        System.out.println("имя собаки: " + dog1.getName());
        dog1.run(344);
        dog1.swim(20);
        Dog dog2 = new Dog("Марш");
        System.out.println("имя собаки: " + dog2.getName());
        dog2.run(123);
        dog2.swim(34);
        Cat cat = new Cat("Жора");
        System.out.println("имя кота: " + cat.getName());
        cat.run(130);
        cat.swim(4);
        System.out.println("общее количество животных " + Animal.getCount());
        System.out.println("количество собак " + Dog.getDogCount());
        System.out.println("количество котов " + Cat.getCatCount());
        Bowl bowl = new Bowl(50);

        Cat.createCats("Маруся", "Герман", "Пусик", "Ромчик", "Папиломка", "Бубочка", "Крендель", "Штрудель");
        System.out.println("количество котов " + Cat.getCatCount());

        for (Cat i : Cat.catsArrayList) {
            i.eat(bowl, 6);
        }

        Cat.printAllCats();

        System.out.println("осталось еды в миске: " + bowl.getFoodAmount() + " единиц.");
        bowl.addFood(6);
        System.out.println("Добавлена еда в миску. В ней: " + bowl.getFoodAmount() + " единиц еды.");
    }
}
