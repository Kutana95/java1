package geekbrains.lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;//230;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    //чтобы акцентрироваться относительно окна геймвиндов
    private GameWindow gameWindow;

    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    SettingsWindow(GameWindow gameWindow) {
        //чтобы акцентрироваться относительно геймвиндов передаем в локальную переменную
        this.gameWindow = gameWindow;
        //установить размер окна
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        //получить прямоугольник формы
        Rectangle gameWindowBounds = gameWindow.getBounds();
        //установить положение окна относительно первого
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        //установить "не расстягивать окно"
        setResizable(false);
        //установить заголовок
        setTitle("Creating new game");
        //установить окну тип
        setLayout(new GridLayout(10, 1));
        //показать выбор режима -->
        addGameModeControls();
        //выбрать размер поля -->
        addFieldControls();
        //создать кнопку стара игры с выбранными параметрами
        JButton btnStart = new JButton("Start new game");
        //действия при нажатии
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //вызвать старт игры -->
                btnStartClick();
            }
        });
        add(btnStart);
    }

    //установить режим игры
    private void addGameModeControls() {
        //добавить надпись
        add(new JLabel("Choose gaming mode"));
        //радио батон
        humVSAI = new JRadioButton("Human vs. AI", true);
        humVShum = new JRadioButton("Human vs. Human");
        //группировка батонов
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        //добавляем батоны на форму
        add(humVSAI);
        add(humVShum);
    }

    //установить размер поля и количество выигрышной комбинации
    private void addFieldControls() {
        //надписи
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        //слайд(ползунок)
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        //по умолчанию максимум равен минимуму поля
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        //действие над ползунком
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //получить значение ползунка
                int currentValue = slideFieldSize.getValue();
                //изменить заголовок
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                //установить максимальное значение ползунка в зависимости от выбранного размера поля
                slideWinLen.setMaximum(currentValue);
            }
        });
        //Добавить текст
        //добавить текст с выбранным значением
        //добавить ползунок
        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLen);
    }

    private void btnStartClick() {
        int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = Map.GM_HVA;
        } else if (humVShum.isSelected()) {
            gameMode = Map.GM_HVH;
        } else {//добавляем на случай, если добавят новый режим и забудут изменить здесь
            throw new RuntimeException("Unexpected game mode!");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLen = slideWinLen.getValue();

        //передать делать старт игры в
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen);

        //пссле старта нужно сделать данное окно невидиым
        setVisible(false);
    }
}
