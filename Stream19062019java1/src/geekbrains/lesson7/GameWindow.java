package geekbrains.lesson7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIN_WIDTH = 450;//507
    private static final int WIN_HEIGHT = 450;//555
    public static final int WIN_POSX = 200;
    public static final int WIN_POSY = 100;

    private Map map;
    private SettingsWindow settingsWindow;

    GameWindow() {
        //устанавливаем, что при нажатии крестика - программа закрывается
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //устанавливаем размер
        setSize(WIN_WIDTH, WIN_HEIGHT);
        //устанавливаем ыерхнюю левую точку окна относительно экрана
        setLocation(WIN_POSX, WIN_POSY);
        //устанавливаем заголовок
        setTitle("TicTacToe");
        //запрещаем растягивать окно
        setResizable(false);

        map = new Map();
        //создание окна настроек
        settingsWindow = new SettingsWindow(this);

        //кнопка, нажатие которой вызовет окно настроек
        JButton btnStartGame = new JButton("Start new game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //окно было создано выше - сейчас мы просто сделали его видимым
                settingsWindow.setVisible(true);
            }
        });

        //кнопка выхода
        JButton btnExit = new JButton("<b>Exit</b>");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //На типе форме, в определенной секции можно создать еще один тип формы
        //в днном случае в нижней зоне создаем грид, разделяющий эту зону на 2 колонки
        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStartGame);
        panelBottom.add(btnExit);

        //добавляем грид на нижнюю границу формы с типом по умолчанию
        add(panelBottom, BorderLayout.SOUTH);
        //добавляем на главное окно окно карты в центральную часть формы (центр по умолчанию, можно не указывать
        // карта - это не окно, это пенал
        add(map);
        setVisible(true);
    }

    //вызвать старт игры, стар игры на карте - инкапсуляция
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}
