import java.util.*;

public class Rambo {
    
    public int dazed = 0;
 
    public int x = 200;
    
    public int y = 350;
    
    public List<Shoot> theShoot = new ArrayList<Shoot>();

    public List<Bomb> bombs = new ArrayList<Bomb>();

    public class Bomb {
        
        public int x;
        
        public int y;
        
        public int stage = 1;
        
        public Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void moveRight() {
            x+=10;
            if(x < 0)
                x+=10;
            if(x > 1200)
                x-=10;
        }
        
        public void move() {
            if(stage == 1) {
                x+=3*5;
                y-=10*5;
                stage++;
            }
            else if(stage == 2) {
                x+=4*5;
                y-=9*5;
                ++stage;
            }
            else if(stage == 3) {
                x+=5*5;
                y-=8*5;
                ++stage;
            }
            else if(stage == 4) {
                x+=5*5;
                y-=5*5;
                ++stage;
            }
            else if(stage == 5) {
                x+=5*5;
                y-=2*5;
                ++stage;
            }
            else if(stage == 6) {
                x+=5*5;
                ++stage;
            }

            else if(stage == 7) {
                x+=5*5;
                y+=1*5;
                stage++;
            }
            else if(stage == 8) {
                x+=5*5;
                y+=3*5;
                ++stage;
            }
            else if(stage == 9) {
                x+=5*5;
                y+=6*5;
                ++stage;
            }
            else if(stage == 10) {
                x+=5*5;
                y+=8*5;
                ++stage;
            }
            else if(stage == 11) {
                x+=5*5;
                y+=10*5;
                ++stage;
            }
            else if(stage == 12) {
                x+=5*5;
                y+=12*5;
                ++stage;
            }
        }
    }

    public class Shoot {
        
        public int x;
        
        public int y;
        
        public Shoot(int x, int y) {
            
            this.x = x;
            
            this.y = y;
        }

        public void moveRight() {
            x+=30;
            if(x < 0)
                x+=10;
            if(x > 1200)
                x-=10;
        }
    }
    
    public void throwBomb() {
        if(dazed == 0) {
            if(bombs == null) {
                bombs = new ArrayList<Bomb>();
            }
            bombs.add(new Bomb(x, y));
        
        }
    }

    public void shoot() {
        if(dazed == 0) {
            if(theShoot == null) {
                theShoot = new ArrayList<Shoot>();
            }
            theShoot.add(new Shoot(x, y));
            theShoot.add(new Shoot(x, y+16));
            theShoot.add(new Shoot(x, y+32));
        } else {
            if(theShoot == null) {
                theShoot = new ArrayList<Shoot>();
            }
            theShoot.add(new Shoot(x, y));
        }
    }
    
    public void moveTop() {
        y-=30;
        if(y < 0)
            y+=30;
        if(y > 700)
            y-=30;
    }

    public void moveBottom() {
        y+=30;
        if(y < 0)
            y+=30;
        if(y > 620)
            y-=30;
    }

    public void moveLeft() {
        x-=30;
        if(x < 0)
            x+=30;
        if(x > 1200)
            x-=30;
    }

    public void moveRight() {
        x+=30;
        if(x < 0)
            x+=30;
        if(x > 1100)
            x-=30;
    }
}