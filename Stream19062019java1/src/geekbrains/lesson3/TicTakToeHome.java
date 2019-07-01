package geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTakToeHome {
    private static Scanner SCANNER = new Scanner(System.in);
    private static Random RANDOM = new Random();

    private static final char HUMAN_DOT = 'X';
    private static final char EMPTY_DOT = '_';
    private static final char COMP_DOT = 'O';

    private static int fieldX;
    private static int fieldY;
    private static char[][] field;

    private static int winDots;
    private static int score;
    private static int scoreHuman;
    private static int scoreComp;

    private static void createMap(int x, int y) {
        fieldX = x;
        fieldY = y;
        field = new char[fieldY][fieldX];

        for (int i = 0; i < fieldY; i++) {
            for (int k = 0; k < fieldX; k++) {
                field[i][k] = EMPTY_DOT;


            }
        }
    }

    private static void printMap() {

        for (int i = 0; i < fieldX; i++) {
            System.out.print("|");
            for (int k = 0; k < fieldY; k++) {
                System.out.print(field[i][k] + "|");
            }
            System.out.println();
        }
    }

    private static void humanStep() {
        int x;
        int y;
        System.out.println("Введите координаты хода от 1 до 3, соответствующие х и у, через пробед");
        do {
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = HUMAN_DOT;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldX && y >= 0 && y < fieldY;

    }

    private static void compStep() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldX);
            y = RANDOM.nextInt(fieldY);
        } while (!isEmptyCell(x, y));

        field[y][x] = COMP_DOT;
    }

    private static boolean checkWin(char dot) {
        int sequence = 0;

        for (int i = 0; i < fieldY; i++) {
            for (int k = 0; k < fieldX; k++) {
                if (field[i][k] == dot) {
                    sequence += 1;
                } else {
                    sequence = 0;
                }
                if (sequence == winDots) return true;
            }
            sequence = 0;
        }
        sequence = 0;

        for (int i = 0; i < fieldX; i++) {
            for (int k = 0; k < fieldY; k++) {
                if (field[k][i] == dot) {
                    sequence += 1;
                } else {
                    sequence = 0;
                }
                if (sequence == winDots) return true;
            }
            sequence = 0;
        }
        return false;


        //if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
        //if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
        //if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;

        //if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
        //if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
        //if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;

        //if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
        //if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;

    }

    private static boolean checkMapisFull() {
        for (int y = 0; y < fieldY; y++) {
            for (int x = 0; x < fieldX; x++) {
                if (field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }


    /*Работате слева направо и сверху вниз, нужно еще справа налево и снизу вверх*/
    private static void aLittleBitIntelligence() {
        int sequence = 0;
        while (true) {
            for (int i = 0; i < fieldY; i++) {
                for (int k = 0; k < fieldX - 1; k++) {
                    if (field[i][k] == HUMAN_DOT) {
                        sequence += 1;
                    } else {
                        sequence = 0;
                    }
                    if ((sequence == winDots - 1) && isEmptyCell(k+1, i)) {
                        field[i][k + 1] = COMP_DOT;
                        break;
                    }
                }
                sequence = 0;
            }
            sequence = 0;

            for (int i = 0; i < fieldX; i++) {
                for (int k = 0; k < fieldY - 1; k++) {
                    if (field[k][i] == HUMAN_DOT) {
                        sequence += 1;
                    } else {
                        sequence = 0;
                    }
                    if ((sequence == winDots - 1) && isEmptyCell( i, k + 1)) {
                        field[k + 1][i] = COMP_DOT;
                        break;
                    }
                }
                sequence = 0;
            }

            int x;
            int y;
            do {
                x = RANDOM.nextInt(fieldX);
                y = RANDOM.nextInt(fieldY);
            } while (!isEmptyCell(x, y));

            field[y][x] = COMP_DOT;
            break;
        }

    }

    public static void main(String[] args) {

        winDots = 4;
        score = 4;
        scoreHuman = 0;
        scoreComp = 0;


        while (scoreHuman < score && scoreComp < score) {
            createMap(5, 5);
            printMap();
            while (true) {
                humanStep();
                printMap();
                if (checkWin(HUMAN_DOT)) {

                    scoreHuman += 1;
                    System.out.println("You are win!! Cчет: человек - компьютер   " + scoreHuman + " - " + scoreComp);
                    break;
                }
                if (checkMapisFull()) {
                    System.out.println("It's a draw, so pity( Cчет: человек - компьютер   " + scoreHuman + " - " + scoreComp);
                    break;
                }
                System.out.println();
                //compStep();
                aLittleBitIntelligence();
                printMap();
                if (checkWin(COMP_DOT)) {
                    scoreComp += 1;
                    System.out.println("Comp beat you!! Cчет: человек - компьютер   " + scoreHuman + " - " + scoreComp);

                    break;
                }
                if (checkMapisFull()) {
                    System.out.println("It's a draw, so pity(");
                    break;
                }
            }





        }
        System.out.println("Игра окончена. Cчет: человек - компьютер   " + scoreHuman + " - " + scoreComp);
        }


}