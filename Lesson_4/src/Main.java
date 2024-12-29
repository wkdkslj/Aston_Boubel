//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee ivanA = new Employee("Ivan", "QA", "ivan@gmail.com", "375252552325", 2500.00, 25);
        System.out.println(ivanA);
        ivanA.setAge(54);
        System.out.println(ivanA);
        System.out.println(ivanA.getSalary());

        Employee[] arrayEmp = new Employee[5];
        arrayEmp[0] = new Employee("Ivan2", "QA", "ivan2@gmail.com", "375252552326", 2500.00, 26);
        arrayEmp[1] = new Employee("Ivan3", "QA", "ivan3@gmail.com", "375252552327", 2500.00, 24);
        arrayEmp[2] = new Employee("Ivan4", "QA", "ivan4@gmail.com", "375252552328", 2500.00, 23);
        arrayEmp[3] = new Employee("Ivan5", "QA", "ivan5@gmail.com", "375252552329", 2500.00, 22);
        arrayEmp[4] = new Employee("Ivan6", "QA", "ivan6@gmail.com", "375252552320", 2500.00, 21);
    }

    Park disney = new Park("Cool park", "10:00 - 22:00");
}
