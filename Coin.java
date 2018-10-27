public class Coin {

    public int ttl = 350;
    
    public int x = 0;
    
    public int y = 0;
    
    public int width = 80;
    
    public int height = 80;
    
    public Coin(int x, int y) {
        
        this.x = x;
        
        this.y = y;
    }

    public boolean didYouEatMe(int x, int y) {
        if(this.x >= x - 0 && this.y >= y - 0 && this.x <= x + 80 && this.y <= y + 80) {
            return true;
        }
        return false;
    }
}