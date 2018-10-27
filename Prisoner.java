import java.util.Random;

public class Prisoner {

    private Random r = new Random();

    public int x = 0;
    
    public int y = 0;
    
    public int width = 120;
    
    public int height = 120;
    
    public String image = "prisoner.gif_c200";
    
    public Prisoner() {
        
        x = r.nextInt(600) + 400;
        
        y = r.nextInt(550) + 50;
    }

    public boolean didYouEatMe(int x, int y) {
        if(x >= this.x && y >= this.y && x <= this.x + 120 && y <= this.y + 120) {
            return true;
        }
        return false;
    }
}