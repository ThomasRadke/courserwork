import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MSPanelL extends JPanel implements RevealListener{
    private MSLabel[][] squares;
    private ImageIcon is;

    private int rows;
    private int cols;
    private int numShowing;
    private int difficulty;

    public MSPanelL(int r, int c,double difficulty){
        is = new ImageIcon("MineSweeperIcons/Bomb.png");
        squares = new MSLabel[r][c];
        this.rows = r;
        this.cols = c;
        this.squares = new MSLabel[r][c];
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(r,c));
        for(int i = 0; i < r;i++)
            for (int j = 0; j < c;j++){
                squares[i][j] = new MSLabel();
                squares[i][j].addRevealListener(this);
                panel.add(squares[i][j]);
            }
        add(panel);
        setBombs((int) (r*c*difficulty));
        setNumbers();
    }

    public void setBombs(int n){
        Random f = new Random();
        int r;
        int c;
        int a = 0;
        while (a < n){
            r = f.nextInt(rows-1);
            c = f.nextInt(cols-1);
            squares[r][c].setAsBomb();
            a++;
        }
    }

    public int getNum(int r, int c){
        int p = squares[r][c].getBombsNear();
        return p;
    }

    public void setNumbers(){

        for (int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++) {
                int bombs = 0;
                if (squares[r][c].isBomb())
                    continue;
                if(squares[Math.max(r-1,0)][c].isBomb())
                    bombs++;
                if(squares[r][Math.max(c-1,0)].isBomb())
                    bombs++;
                if(squares[Math.max(r-1,0)][Math.max(c-1,0)].isBomb())
                    bombs++;
                if(squares[Math.max(r-1,0)][Math.min(c+1,cols-1)].isBomb())
                    bombs++;
                if(squares[Math.min(r+1,rows-1)][Math.max(c-1,0)].isBomb())
                    bombs++;
                if(squares[Math.min(r+1,rows-1)][c].isBomb())
                    bombs++;
                if(squares[r][Math.min(c+1,cols-1)].isBomb())
                    bombs++;
                if(squares[Math.min(r+1,rows-1)][Math.min(c+1,cols-1)].isBomb())
                    bombs++;

                squares[r][c].setBombsNear(bombs);
            }

    }

    @Override
    public void update(RevealEvent b) {
        MSCell m = (MSCell) b.getSource();
        if(m.isBomb()){
            m.reveal();
            for(int i = 0; i < cols; i++)
                for(int j = 0; j < rows; j++) {
                    if(squares[i][j].isBomb())
                        squares[i][j].setIcon(is);
                }
            JOptionPane.showMessageDialog(null, "Game Over!");
            System.exit(0);
        }
        numShowing++;
        if(numShowing >= (rows*cols) - (int) difficulty*rows*cols);

    }
}
