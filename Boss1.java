import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JProgressBar;

public class Boss1 {

    private int v;
    
    private int steps;

    public JProgressBar pb = new JProgressBar();

    private Random r = new Random();
    
    public int x = -1000;
    
    public int y = -1000;
    
    public int dest = 0;
    
    public int width = 300;
    
    public int height = 300;
    
    public Battle war = null;
    
    public int life = 1000;
    
    public List<Shoot> shoots = new ArrayList<Shoot>();
    
    public Shoot shoot = null;
    
    public void shoot(Rambo rambo) {
        int w = r.nextInt(70);
        if(w == 0) {
            shoot = new Shoot(this.x+100, this.y + 150);
            shoot.movx = -6;
            shoot.movy = -4;
            war.bs1.add(shoot);

            shoot = new Shoot(this.x+100, this.y + 150);
            shoot.movx = -6;
            shoot.movy = -2;
            war.bs1.add(shoot);

            shoot = new Shoot(this.x+100, this.y + 150);
            shoot.movx = -6;
            shoot.movy = 0;
            war.bs1.add(shoot);

            shoot = new Shoot(this.x+100, this.y + 150);
            shoot.movx = -6;
            shoot.movy = 2;
            war.bs1.add(shoot);

            shoot = new Shoot(this.x+100, this.y + 150);
            shoot.movx = -6;
            shoot.movy = 4;
            war.bs1.add(shoot);
        }
    }
    
    public class Shoot {
        
        public int x;
        
        public int y;
        
        public int movx;
        
        public int movy;
        
        public Shoot(int x, int y) {
            
            this.x = x;
            
            this.y = y;
        }
    }
    
    public Boss1(Battle war) {
        
        this.war = war;
        
        x = r.nextInt(600) + 400;
        
        y = r.nextInt(600) + 50;
        
        pb.setMinimum(0);
        pb.setMaximum(1000);
        pb.setValue(1000);
        pb.setForeground(Color.yellow);
    }
    
    public void moveTop() {
        y-=5;
        if(y < 0)
            y+=5;
        if(y > 620)
            y-=5;
    }

    public void moveBottom() {
        y+=5;
        if(y < 0)
            y+=5;
        if(y > 620)
            y-=5;
    }

    public void moveLeft() {
        x-=5;
        if(x > 1200)
            x-=5;
    }

    public void moveRight() {
        x+=5;
        if(x > 1200)
            x-=5;
    }
   
    public void nextMove() {
        if(steps == 3)
            steps = 0;
        if(steps == 0)
            v = r.nextInt(4);
        if(v == 0) {
            moveLeft();
        } else if(v == 1) {
            moveTop();
        } else if(v == 2) {
            moveRight();
        } else if(v == 3) {
            moveBottom();
        }
        ++steps;
    }

    public boolean didYouDie(int x, int y) {
        if(this.x >= x - 14 && this.y >= y - 14 && this.x <= x + 14 && this.y <= y + 14) {
            return true;
        }
        return false;
    }

    public boolean didYouExplode(int x, int y) {
        if(this.x >= x - 44 && this.y >= y - 44 && this.x <= x + 44 && this.y <= y + 44) {
            return true;
        }
        return false;
    }
}