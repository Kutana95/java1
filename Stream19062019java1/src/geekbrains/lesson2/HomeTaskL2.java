package geekbrains.lesson2;
import java.util.Arrays;

public class HomeTaskL2 {
    /*1 Задать целочисленный массив, состоящий из элементов 0 и 1.
Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в
принятом массиве 0 на 1, 1 на 0;*/
    public static void change1And0(int[] a) {

        for (int i = 0; i < a.length; i++) {

            a[i] = (a[i] == 0) ? 1 : 0;
        }

    }
        /*2 Задать пустой целочисленный массив размером 8. Написать метод,
	который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;*/

    public static void toFillArr(int[] a) {
        int value = 1;

        for (int i = 0; i < a.length; i++) {

            a[i] = value;
            value += 3;
        }

    }

    /*3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
принимающий на вход массив и умножающий числа меньше 6 на 2;*/
    public static void toMultiplyOn2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (a[i] < 6) ? (a[i] *= 2) : (a[i]);
        }
    }

    /*4 Задать одномерный массив. Написать методы поиска в нём
минимального и максимального элемента;*/
    public static int maxArr(int[] a) {
        int max, value;
        max = a[0];
        for (int i = 1; i < a.length; i++) {
            value = a[i];
            max = (value > max) ? value : max;
        }
        return max;
    }

    public static int minArr(int[] a) {
        int min, value;
        min = a[0];
        for (int i = 1; i < a.length; i++) {
            value = a[i];
            min = (value < min) ? value : min;
        }
        return min;
    }

    /*5 * Создать квадратный целочисленный массив
	(количество строк и столбцов одинаковое), заполнить его диагональные
	элементы единицами, используя цикл(ы);*/
    public static void createArr(int b) {
        int a[][] = new int[b][b];

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < b; j++) {
                a[i][j] = ((i == j) || (i + j == b - 1)) ? 1 : 0;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*6 ** Написать метод, в который передается не пустой одномерный
	целочисленный массив, метод должен вернуть true если в массиве есть
	место, в котором сумма левой и правой части массива равны. Примеры:
	checkBalance([1, 1, 1, || 2, 1]) → true,
	checkBalance ([2, 1, 1, 2, 1]) → false,
	checkBalance ([10, || 1, 2, 3, 4]) → true.
	Абстрактная граница показана символами ||, эти символы в массив не входят.*/
    public static boolean isEqual(int[] a) {

        int sum = 0;

        int sum1, sum2;
        ;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        sum1 = a[0];
        sum2 = sum - a[0];

        for (int i = 1; i < a.length; i++) {
            if (sum1 == sum2) {
                return true;
            } else {
                sum1 += a[i];
                sum2 -= a[i];
            }
        }
        return false;
    }

    /*7 *** Написать метод, которому на вход подаётся одномерный массив и
	число n (может быть положительным, или отрицательным), при этом метод
	должен циклически сместить все элементы массива на n позиций.
	[1,2,3,4,5], -2 => [3,4,5,1,2]
	[1,2,3,4,5], 2 => [4,5,1,2,3]

	8 **** Не пользоваться вспомогательным массивом при решении задачи 7.*/

    public static void replace(int b, int[] a) {
        int d = 0;
        if (b > 0) {

            int c;
            while (b != 0) {
                d = a[0];
                for (int i = 1; i < a.length; i++) {
                    c = a[i];
                    a[i] = d;
                    d = c;
                }
                a[0] = d;

                b -= 1;
            }
        } else {
            while (b != 0) {
                d = a[0];
                for (int i = 0; i < a.length - 1; i++) {
                    a[i] = a[i + 1];
                }
                a[a.length - 1] = d;
                b += 1;
            }
        }
    }


    public static void main(String[] args) {
        //1
        int[] arr = new int[10];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 0;
        arr[5] = 0;
        arr[6] = 1;
        arr[7] = 0;
        arr[8] = 0;
        arr[9] = 1;

        change1And0(arr);
        System.out.println(Arrays.toString(arr));

        //2
        int[] arr2 = new int[8];
        toFillArr(arr2);
        System.out.println(Arrays.toString(arr2));

        //3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        toMultiplyOn2(arr3);
        System.out.println(Arrays.toString(arr3));

        //4
        int[] arr4 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(maxArr(arr4));
        System.out.println(minArr(arr4));

        //5
        int a = 7;
        createArr(a);

        //6
        int[] arr61 = {1, 1, 1, 2, 1};
        System.out.println(isEqual(arr61));
        int[] arr62 = {2, 1, 1, 2, 1};
        System.out.println(isEqual(arr62));
        int[] arr63 = {10, 1, 2, 3, 4};
        System.out.println(isEqual(arr63));

        //7
        //[1,2,3,4,5], 2 => [4,5,1,2,3]
        //[1,2,3,4,5], -2 => [3,4,5,1,2]
        int[] arr7 = {1, 2, 3, 4, 5};
        replace(-3, arr7);
        System.out.println(Arrays.toString(arr7));


    }

}

