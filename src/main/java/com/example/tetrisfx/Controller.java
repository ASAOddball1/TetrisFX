package com.example.tetrisfx;
import javafx.scene.shape.*;
public class Controller {
    //Getting numbers and MESH from Tetris class
    public static final int MOVE = Tetris.MOVE;
    public static final int SIZE = Tetris.SIZE;
    public static int XMAX = Tetris.XMAX;
    public static int YMAX = Tetris.YMAX;
    public static int[][] MESH = Tetris.MESH;


    public static void MoveDown (Form form) {
        if (form.a.getY() + MOVE <= YMAX - SIZE &&
                form.b.getY() + MOVE <= YMAX - SIZE &&
                form.c.getY() + MOVE <= YMAX - SIZE &&
                form.d.getY() + MOVE <= YMAX - SIZE) {

            int movea = MESH[((int) form.a.getX() / SIZE)][((int) form.a.getY() / SIZE + 1)];
            int moveb = MESH[((int) form.b.getX() / SIZE)][((int) form.b.getY() / SIZE + 1)];
            int movec = MESH[((int) form.c.getX() / SIZE)][((int) form.c.getY() / SIZE + 1)];
            int moved = MESH[((int) form.d.getX() / SIZE)][((int) form.d.getY() / SIZE + 1)];

            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + MOVE);
                form.b.setY(form.b.getY() + MOVE);
                form.c.setY(form.c.getY() + MOVE);
                form.d.setY(form.d.getY() + MOVE);
            }
        }
    }



    public static void MoveRight (Form form){
        if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.getX() + MOVE <= XMAX - SIZE
                && form.c.getX() + MOVE - SIZE <= XMAX && form.d.getX() + MOVE <= XMAX - SIZE)
        {
            int movea = MESH[((int) form.a.getX() / SIZE + 1)][((int) form.a.getY() / SIZE)];
            int moveb = MESH[((int) form.b.getX() / SIZE + 1)][((int) form.b.getY() / SIZE)];
            int movec = MESH[((int) form.c.getX() / SIZE + 1)][((int) form.c.getY() / SIZE)];
            int moved = MESH[((int) form.d.getX() / SIZE + 1)][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved){
                form.a.setX(form.a.getX() + MOVE);
                form.b.setX(form.b.getX() + MOVE);
                form.c.setX(form.c.getX() + MOVE);
                form.d.setX(form.d.getX() + MOVE);

            }

        }
    }

    public static void MoveLeft (Form form){
        if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0
                && form.c.getX() - MOVE >= 0 && form.d.getX() - MOVE >= 0)
        {
            int movea = MESH[((int) form.a.getX() / SIZE - 1)][((int) form.a.getY() / SIZE)];
            int moveb = MESH[((int) form.b.getX() / SIZE - 1)][((int) form.b.getY() / SIZE)];
            int movec = MESH[((int) form.c.getX() / SIZE - 1)][((int) form.c.getY() / SIZE)];
            int moved = MESH[((int) form.d.getX() / SIZE - 1)][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved){
                form.a.setX(form.a.getX() - MOVE);
                form.b.setX(form.b.getX() - MOVE);
                form.c.setX(form.c.getX() - MOVE);
                form.d.setX(form.d.getX() - MOVE);

            }

        }
    }

    public static void moveDownToBottom (Form form) {
        //AI Helped me with this
        while (canMoveDown(form)) {
            form.a.setY(form.a.getY() + MOVE);
            form.b.setY(form.b.getY() + MOVE);
            form.c.setY(form.c.getY() + MOVE);
            form.d.setY(form.d.getY() + MOVE);
        }
    }

    public static boolean canMoveDown(Form form) {
        if (form.a.getY() + MOVE > YMAX - SIZE ||
                form.b.getY() + MOVE > YMAX - SIZE ||
                form.c.getY() + MOVE > YMAX - SIZE ||
                form.d.getY() + MOVE > YMAX - SIZE) {
            return false;
        }

        int movea = MESH[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE + 1];
        int moveb = MESH[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE + 1];
        int movec = MESH[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE + 1];
        int moved = MESH[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE + 1];

        return movea == 0 && movea == moveb && moveb == movec && movec == moved;
    }



    //Creating the stones
    public static Form makeRect() {
        // randomly generate stone order

        int block = (int) (Math.random() * 100);
        String name;

        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1),
                b = new Rectangle(SIZE - 1, SIZE - 1),
                c = new Rectangle(SIZE - 1, SIZE - 1),
                d = new Rectangle(SIZE - 1, SIZE - 1);

        if (block < 15) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 30) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 45) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 75) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
        } else if (block < 90) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
        }

        return new Form (a, b, c, d, name);
    }



}