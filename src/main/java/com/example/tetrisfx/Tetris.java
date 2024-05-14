package com.example.tetrisfx;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Tetris{

    //Variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int [][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane groupe = new Pane();
    private static Form object;
    private static Scene scene = new Scene(groupe, XMAX + 150, YMAX);
    public static int score = 0;
    private static boolean game = true;
    private static Form nextObj = controller.makeRect();
    private static int linesno = 0;


}
