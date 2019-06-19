package geekbrains.lesson1;

public class HomeTask {
    /*Написать метод вычисляющий выражение a * (b + (c / d)) и
    возвращающий результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода; */

    public static float calculate (int a, int b, int c, int d){
        return a * (b + (c / d));
    }

    /*Написать метод, принимающий на вход два целых числа, и проверяющий,
     что их сумма лежит в пределах от 10 до 20(включительно),
     если да – вернуть true, в противном случае – false;*/

    public static boolean between10and20 (int a, int b){
        int c;
        c = a + b;
        if ((c>=10) & (c<=20)){
            return true;
        } else{
            return false;
        }
    }

    /*Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль проверить положительное ли число передали,
    или отрицательное. Замечание: ноль считаем положительным числом.
    Результат работы метода вывести в консоль */

    public static void isPositiveOrNegative (int a){

        if (a >= 0){
            System.out.println("Значение а = " + a + " - положительное");
        } else{
            System.out.println("Значение а = " + a + " - отрицательное");
        }
    }

    /* Написать метод, которому в качестве параметра передается строка,
    обозначающая имя, метод должен вернуть приветственное сообщение «Привет, переданное_имя!»;
    Вывести приветствие в консоль.
     */

    public static void privet(String name){

        System.out.println("Привет, " + name + "!");
    }

    public static void main(String[] args){

        System.out.println(calculate(5, 10, 32, 96));
        System.out.println(between10and20(3, 5));
        isPositiveOrNegative(-52);
        privet("Ann");

    }
}
