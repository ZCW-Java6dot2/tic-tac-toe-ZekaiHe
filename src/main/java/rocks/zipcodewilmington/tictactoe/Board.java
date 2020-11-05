package rocks.zipcodewilmington.tictactoe;

import javax.sound.sampled.BooleanControl;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] board;

    public Board(Character[][] matrix) {
        this.board = matrix;
    }

    private int hCheckBoard() {
        int size = board.length;
        int condition = 0;

        for (int y = 0; y < size; y++) {//look at rows
            int xCount = 0;
            int oCount = 0;
            for (int x = 0; x < size; x++) {
                switch (board[y][x]) {
                    case 'X':
                        xCount++;
                        break;
                    case 'O':
                        oCount++;
                        break;
                }

                if (xCount == 3) {
                    condition = 1;
                } else if (oCount == 3) {
                    condition = 2;
                }
            }
        }
        return condition;
    }

    private int vCheckBoard() {
        int size = board.length;
        int condition = 0;

        for (int x = 0; x < size; x++) {//look at columns
            int xCount = 0;
            int oCount = 0;
            for (int y = 0; y < size; y++) {
                switch (board[y][x]) {
                    case 'X':
                        xCount++;
                        break;
                    case 'O':
                        oCount++;
                        break;
                }

                if (xCount == 3) {
                    condition = 1;
                } else if (oCount == 3) {
                    condition = 2;
                }
            }
        }
        return condition;
    }

    private int diagonal1() {
        int size = board.length;
        int condition = 0;
        int xCount = 0; //outside all loops because loops ONLY looks at diagonal, resets to 0 in set inside loop
        int oCount = 0; //outside all loops because loops ONLY looks at diagonal, resets to 0 in set inside loop

        for (int x = 0; x < size; x++) {//look at diagonal (ul->lr)
            for (int y = x; y < x + 1; y++) {

                switch (board[y][x]) {
                    case 'X':
                        xCount++;
                        break;
                    case 'O':
                        oCount++;
                        break;
                }

                if (xCount == size) {
                    condition = 1;
                } else if (oCount == size) {
                    condition = 2;
                }
            }
        }
        return condition;
    }

    private int diagonal2() {
        int size = board.length;
        int condition = 0;
        int xCount = 0; //outside all loops because loops ONLY looks at diagonal, resets to 0 in set inside loop
        int oCount = 0; //outside all loops because loops ONLY looks at diagonal, resets to 0 in set inside loop

        for(int y=0; y<size;y++) {//look at diagonal (ll->ur)
            for (int x=size-1-y; x<size-y; x++) {

                switch (board[y][x]){
                    case 'X':
                        xCount ++;
                        break;
                    case 'O':
                        oCount ++;
                        break;
                }

                if (xCount == size) {
                    condition = 1;
                }
                else if (oCount == size) {
                    condition = 2;
                }
            }
        }
        return condition;
    }

    public Boolean isInFavorOfX() {
        return hCheckBoard()==1 || vCheckBoard()==1 || diagonal1()==1 || diagonal2()==1;

    }

    public Boolean isInFavorOfO() {
        return hCheckBoard()==2 || vCheckBoard()==2 || diagonal1()==2 || diagonal2()==2;
    }

    public Boolean isTie() {
        return hCheckBoard()==0 && vCheckBoard()==0 && diagonal1()==0 && diagonal2()==0;
    }

    public String getWinner() {
        if (hCheckBoard()==1 || vCheckBoard()==1 || diagonal1()==1 || diagonal2()==1){
            return "X";
        }
        else if (hCheckBoard()==2 || vCheckBoard()==2 || diagonal1()==2 || diagonal2()==2){
            return "O";
        }
        else{
            return "";
        }
    }
}
