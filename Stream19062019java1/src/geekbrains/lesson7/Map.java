package geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    //режимы игры, которые выбираются в SettingsWindow - инкапсуляция
    public static final int GM_HVA = 0;
    public static final int GM_HVH = 1;


    //public  static int linesCount = 3;
    int cellSize;
    int x;
    int y;
    String[][] cell;
    public final String NOT_SIGN = "*";
    public static final int FIELD_SIZE = 400;
    public static Graphics g;
    /*
1. Полностью разобраться с кодом
(попробовать полностью самостоятельно переписать одно из окон)

2. Составить список вопросов и приложить в виде комментария к домашней работе

3. * Рачертить панель Map на поле для игры, согласно fieldSize

*/

    Map() {
        setBackground(Color.BLACK);

    }

    void startNewGame(int mode, int fieldSizeX, int filedSizeY, int winLength) {
        System.out.println("mod" + mode +
                "\nfsX" + fieldSizeX +
                "\n fsY" + filedSizeY +
                "\n wLn" + winLength);


        paintMap(g,fieldSizeX);



    }

    void paintMap(Graphics g, int linesCount){
        this.cellSize = FIELD_SIZE / linesCount;
        cell = new String[linesCount][linesCount];
        System.out.println(this.cellSize);
        for (int i = 0; i <= linesCount; i++) {
            int a = i * this.cellSize + GameWindow.WIN_POSY;
            int b = GameWindow.WIN_POSX+FIELD_SIZE;
            int c = i * this.cellSize + GameWindow.WIN_POSY;
            System.out.println(GameWindow.WIN_POSX +" " + a + " "+b+" " +c);

            g.drawLine( GameWindow.WIN_POSX, a, b, c);
            System.out.println(GameWindow.WIN_POSX +"" + ((i * this.cellSize) + GameWindow.WIN_POSY)+ ""+GameWindow.WIN_POSX+FIELD_SIZE+"" +i * this.cellSize + FIELD_SIZE);
            g.drawLine(i * this.cellSize + GameWindow.WIN_POSX, 0 + GameWindow.WIN_POSY, i * this.cellSize + GameWindow.WIN_POSX, FIELD_SIZE + GameWindow.WIN_POSY);
            System.out.println("ok " + i);
        }
        for (int i = 0; i < linesCount; i++) {
            for (int j = 0; j < linesCount; j++) {
                if (cell[i][j] != NOT_SIGN) {
                    if (cell[i][j] == "X") {
                        // Рисуем крестик
                        g.setColor(Color.RED);
                        g.drawLine((i * cellSize), (j * cellSize), (i + 1) * cellSize, (j + 1) * cellSize);
                        g.drawLine((i + 1) * cellSize, (j * cellSize), (i * cellSize), (j + 1) * cellSize);
                    }
                    if (cell[i][j] == "O") {
                        // Рисуем нолик
                        g.setColor(Color.BLUE);
                        g.drawOval((i * cellSize), (j * cellSize), cellSize, cellSize);
                    }
                }
            }
        }

    }

}