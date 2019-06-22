package geekbrains.lesson1;

public class HomeTask {
    /*Написать метод вычисляющий выражение a * (b + (c / d)) и
    возвращающий результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода; */

    public static float calculate (int a, int b, int c, int d){
        return a * (b + (c*1.0f / d));
    }

    /*Написать метод, принимающий на вход два целых числа, и проверяющий,
     что их сумма лежит в пределах от 10 до 20(включительно),
     если да – вернуть true, в противном случае – false;*/

    public static boolean between10and20 (int a, int b){
        int c;
        c = a + b;
        return ((c>=10) & (c<=20));
    }

    /*Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль проверить положительное ли число передали,
    или отрицательное. Замечание: ноль считаем положительным числом.
    Результат работы метода вывести в консоль */

    public static boolean isPositive (int a){

       return (a >= 0);
    }

    /* Написать метод, которому в качестве параметра передается строка,
    обозначающая имя, метод должен вернуть приветственное сообщение «Привет, переданное_имя!»;
    Вывести приветствие в консоль.
     */

    public static String privet(String name){

       return ("Привет, " + name + "!");
    }

    /*Написать метод, который определяет является ли год високосным.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    Для проверки работы вывести результаты работы метода в консоль
     */

    public static boolean leapYear(int year){

        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);

    }

    public static void main(String[] args){

        System.out.println(calculate(5, 10, 32, 96));
        System.out.println(between10and20(3, 5));
        System.out.println("Ваше число " + ((isPositive(-52) ? "положительное" : "отрицательное")));
        System.out.println(privet("Ann"));

        System.out.println(leapYear(-2502));
        System.out.println(leapYear(4));
        System.out.println(leapYear(5));
        System.out.println(leapYear(47));
        System.out.println(leapYear(96));
        System.out.println(leapYear(100));
        System.out.println(leapYear(200));
        System.out.println(leapYear(300));
        System.out.println(leapYear(400));
        System.out.println(leapYear(500));
        System.out.println(leapYear(1200));
        System.out.println(leapYear(3500));

    }
}
