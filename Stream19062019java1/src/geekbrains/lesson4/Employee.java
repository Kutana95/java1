package geekbrains.lesson4;

public class Employee {

    private String fullName;
    private int age;
    private String phoneNumber;
    private float salary;
    private String position;
    private int id = 0;
    private static int counter = 0;

    Employee() {
        fullName = "Иванов Петр Валерианович";
        age = 32;
        phoneNumber = "+79235698788";
        salary = 60000.5f;
        position = "Программист";
        counter +=1;
        id = counter;

    }

    Employee(String fullName, int age, String phoneNumber, float salary, String position) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.position = position;
        this.id = counter + 1;
        counter +=1;
    }

    public String getFullName() {
        return this.fullName;
    }
    public int getAge() {
        return this.age;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public float getSalary() {
        return this.salary;
    }
    public String getPosition() {
        return this.position;
    }
    public int getId() {
        return this.id;
    }

    /*Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000;
    * Не совсем поняла, сделала 2 решения*/
    public void increaseSalary(){
        if (this.getAge() > 45){this.salary += 5000;}
    }

    public static void increaseSalaryMain(Employee[] ar){
        for (int i = 0; i<ar.length; i++){
            if (ar[i].getAge() > 40){
                System.out.println(ar[i].getFullName() + " " + ar[i].getAge());
            }
        }
    }

}
