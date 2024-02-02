import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MSLabel extends JLabel {
    private MSCell cell;
    private ArrayList<RevealListener> listeners;
    ImageIcon[] squares;

    public MSLabel(){
        cell = new MSCell();
        listeners = new ArrayList<RevealListener>();
        MSListener mouse = new MSListener();
        squares = new ImageIcon[15];
        for(int i = 0; i <9;i++)
            squares[i] = new ImageIcon("MineSweeperIcons/"+ i + ".png");
        squares[9] = new ImageIcon("MineSweeperIcons/BadFlag.png");
        squares[10] = new ImageIcon("MineSweeperIcons/Blank.png");
        squares[11] = new ImageIcon("MineSweeperIcons/Bomb.png");
        squares[12] = new ImageIcon("MineSweeperIcons/Empty.png");
        squares[13] = new ImageIcon("MineSweeperIcons/Explode.png");
        squares[14] = new ImageIcon("MineSweeperIcons/Flag.png");
        setIcon(squares[10]);
        MSListener m = new MSListener();
        addMouseListener(m);
    }

    public void setAsBomb(){
        cell.setAsBomb();
    }

    public boolean isBomb(){
        return cell.isBomb();
    }

    public void setBombsNear(int n){
        cell.setBombsNear(n);
    }

    public int getBombsNear(){
        return cell.getBombsNear();
    }

    public void addRevealListener(RevealListener b){
        listeners.add(b);
    }

    public void notifyListeners(){
        RevealEvent b = new RevealEvent(cell);
        for(RevealListener i: listeners)
            i.update(b);
    }

    public void reveal(){
        cell.reveal();
        if(cell.isBomb())
            setIcon(squares[13]);
        else
            setIcon(squares[cell.getBombsNear()]);
    }
    public void flag(){
        setIcon(squares[14]);
    }
    public class MSListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                reveal();
                notifyListeners();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON3){
                flag();
                JOptionPane.showMessageDialog(null,"GAME OVER");
                System.exit(0);

            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

