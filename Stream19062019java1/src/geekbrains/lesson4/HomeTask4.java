package geekbrains.lesson4;

public class HomeTask4 {
    public static void main(String[] args) {

        Employee e1 = new Employee();
        System.out.println("Full name: "+ e1.getFullName() + " , position: "+ e1.getPosition());

        Employee e2 = new Employee("Ибрагимов Владислав Невикторович", 53, "89998794242", 52000.5f, "Админисратор");
        System.out.println("Full name: "+ e2.getFullName() + " , position: "+ e2.getPosition());

        Employee arr[] = new Employee[5];
        arr[0] = e1;
        arr[1] = e2;
        Employee e3 = new Employee("Третий Петр Олегович",
                40, "899922222", 55000.5f, "Администратор ИТ");
        arr[2] = e3;
        Employee e4 = new Employee("Четвертый Виктор Сергеевич",
                42, "89998787877", 62000.5f, "Сантехник");
        arr[3] = e4;
        Employee e5 = new Employee("Пятый Счастливчик Юрьевич",
                21, "89994635317", 720000.5f, "Хоккеист");
        arr[4] = e5;

        for (int i = 0; i<arr.length; i++){
            if (arr[i].getAge() > 40){
                System.out.println(arr[i].getFullName() + " " + arr[i].getAge());
            }
        }

        /*Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000;
        * Не совсем поняла, сделала 2 решения*/
        e1.increaseSalary();
        Employee.increaseSalaryMain(arr);


        System.out.println("ID: "+ e1.getId());
        System.out.println("ID: "+ e2.getId());
        System.out.println("ID: "+ e3.getId());
        System.out.println("ID: "+ e4.getId());
        System.out.println("ID: "+ e5.getId());


    }

}
