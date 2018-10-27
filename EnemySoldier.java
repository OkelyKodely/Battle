import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySoldier {

    public Bomb bomb = null;
    
    private int v;
 
    private int steps;

    private Random r = new Random();
    
    public int x = 0;
    
    public int y = 0;
    
    public int dest = 0;
    
    public int width = 38;
    
    public int height = 38;
    
    public String PLACE = "normal";
    
    public Battle war = null;
    
    public List<Shoot> shoots = new ArrayList<Shoot>();
    
    public Shoot shoot = null;
    
    public boolean firing = false;
    
    public int dest1x = 0, dest1y = 0, dest2x = 0, dest2y = 0,
            dest3x = 0, dest3y = 0, dest4x = 0, dest4y = 0, dest5x = 0, dest5y = 0,
            dest6x = 0, dest6y = 0, dest7x = 0, dest7y = 0;
    
    public class Bomb {
        
        public int x;
        
        public int y;
        
        public int stage = 1;
        
        public Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void moveLeft() {
            x-=10;
            if(x < 0)
                x+=10;
            if(x > 1200)
                x-=10;
        }
        
        public void move() {
            if(stage == 1) {
                x-=3*5;
                y-=10*5;
                stage++;
            }
            else if(stage == 2) {
                x-=4*5;
                y-=9*5;
                ++stage;
            }
            else if(stage == 3) {
                x-=5*5;
                y-=8*5;
                ++stage;
            }
            else if(stage == 4) {
                x-=5*5;
                y-=5*5;
                ++stage;
            }
            else if(stage == 5) {
                x-=5*5;
                y-=2*5;
                ++stage;
            }
            else if(stage == 6) {
                x-=5*5;
                ++stage;
            }

            else if(stage == 7) {
                x-=5*5;
                y+=1*5;
                stage++;
            }
            else if(stage == 8) {
                x-=5*5;
                y+=3*5;
                ++stage;
            }
            else if(stage == 9) {
                x-=5*5;
                y+=6*5;
                ++stage;
            }
            else if(stage == 10) {
                x-=5*5;
                y+=8*5;
                ++stage;
            }
            else if(stage == 11) {
                x-=5*5;
                y+=10*5;
                ++stage;
            }
            else if(stage == 12) {
                x-=5*5;
                y+=12*5;
                ++stage;
            }
        }
    }

    public void throwBomb() {
        int w = r.nextInt(30);
        if(w == 0) {
            bomb = new Bomb(this.x, this.y);
        }
    }

    public void shoot(Rambo rambo) {
        if(rambo.y >= this.y - 10 && rambo.y <= this.y + 10) {
            int w = r.nextInt(3);
            if(w == 1) {
                shoot = new Shoot(this.x, this.y);
                war.shoots.add(shoot);
            }
        }

        int w = r.nextInt(233);
        if(w == 1) {
            shoot = new Shoot(this.x, this.y);
            shoot.awayWidth = this.x - rambo.x;
            shoot.awayHeight = this.y - rambo.y;

            if(shoot.awayWidth == 0) {
                shoot.movx = 0;
                if(shoot.awayHeight < 0)
                    shoot.movy = 6;
                if(shoot.awayHeight > 0)
                    shoot.movy = -6;
            }
            else if(shoot.awayWidth != 0) {
                shoot.rat = (double) shoot.awayHeight / (double) shoot.awayWidth;
                if(shoot.rat < 0)
                    shoot.rat *= -1d;
                if(shoot.awayWidth < 0)
                    shoot.movx = 6;
                if(shoot.awayWidth > 0)
                    shoot.movx = -6;
                if(shoot.awayHeight < 0)
                    shoot.movy = (int) (6d*shoot.rat);
                if(shoot.awayHeight > 0)
                    shoot.movy = -(int) (6d*shoot.rat);
            }
            
            war.shoots.add(shoot);
        }
    }
    
    public class Shoot {
        
        public double rat = -1d;
            
        public int x;
        
        public int y;
        
        public int awayWidth = 0;

        public int awayHeight = 0;
        
        public int movx;
        
        public int movy;

        public Shoot(int x, int y) {
            
            this.x = x;
            
            this.y = y;
        }

        public void moveLeft() {
            x-=7;
        }
    }
    
    public EnemySoldier(Battle war) {
        
        this.war = war;
        
        x = r.nextInt(600) + 400;
        
        y = r.nextInt(600) + 50;
        
        dest1x = x - 30;
        dest1y = y - 30;
        
        dest2x = x - 45;
        dest2y = y - 30;
        
        dest3x = x - 60;
        dest3y = y;
        
        dest4x = x - 45;
        dest4y = y + 30;
        
        dest5x = x - 30;
        dest5y = y + 30;
        
        dest6x = x;
        dest6y = y;
        
        dest7x = x - 5;
        dest7y = y;
    }
    
    public void moveTop() {
        y-=10;
        if(y < 0)
            y+=10;
        if(y > 700)
            y-=10;
    }

    public void moveBottom() {
        y+=10;
        if(y < 0)
            y+=10;
        if(y > 620)
            y-=10;
    }

    public void moveLeft() {
        x-=10;
        if(x > 1200)
            x-=10;
        if(x < 0) {
            ++war.deadCount;
            if((double)war.deadCount/(double)10>0.8) {
                war.randomizeMiniNewEnemySoldiers();
                war.deadCount = 0;
            }
        }
    }

    public void moveRight() {
        x+=10;
        if(x > 1200)
            x-=10;
    }
    
    private void miniMoveLeft() {
        x-=1;
        if(x > 1200)
            x-=10;
    }
    
    public void nextMove() {
        if(steps == 5)
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
        miniMoveLeft();
        ++steps;
    }

    public boolean didYouDie(int x, int y) {
        if(this.x >= x - 38 && this.y >= y - 38 && this.x <= x + 38 && this.y <= y + 38) {
            return true;
        }
        return false;
    }

    public boolean didYouExplode(int x, int y) {
        if(this.x >= x - 338 && this.y >= y - 338 && this.x <= x + 338 && this.y <= y + 338) {
            return true;
        }
        return false;
    }
}