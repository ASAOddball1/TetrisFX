package com.example.tetrisfx;
import javafx.scene.shape.*;
public class Controller {
    //Getting numbers and MESH from Tetris class
    public static final int MOVE = Tetris.MOVE;
    public static final int SIZE = Tetris.SIZE;
    public static int XMAX = Tetris.XMAX;
    public static int YMAX = Tetris.YMAX;
    public static int[][] MESH = Tetris.MESH;

    //Moving the blocks

    public static void MoveRight (Form form){
        if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.get
    }
 


}