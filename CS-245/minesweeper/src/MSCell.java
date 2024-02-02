public class MSCell {
    private int bombsNear;
    private boolean isBomb;
    private boolean isFlagged;
    private boolean isHidden;

    public MSCell(){
        this.bombsNear = 0;
        this.isBomb = false;
        this.isFlagged = false;
        this.isHidden = true;
    }

    public void setBombsNear(int n){
        this.bombsNear = n;
    }

    public void setAsBomb(){
        this.isBomb = true;
    }

    public void toggleFlagged(){
        this.isFlagged = true;
    }

    public void reveal(){
        this.isHidden = false;
    }

    public int getBombsNear(){
        return bombsNear;
    }

    public boolean isBomb(){
        return isBomb;
    }

    public boolean isFlagged(){
        return isFlagged;
    }

    public boolean isHidden(){
        return isHidden;
    }
}
