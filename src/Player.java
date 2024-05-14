import java.awt.*;

public class Player {
    private int x, y;
    private int width, height;
    private int xVelocity, yVelocity;
    private int jumpCounter;
    private boolean isJumping;
    private boolean jumpKeyHeld;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.jumpCounter = 0;
        this.isJumping = false;
        this.jumpKeyHeld = false;
    }

    public void update(boolean leftPressed, boolean rightPressed, boolean jumpPressed) {
        if (leftPressed) {
            xVelocity = -5;
        } else if (rightPressed) {
            xVelocity = 5;
        } else {
            xVelocity = 0;
        }

        if (jumpPressed) {
            if (!jumpKeyHeld && jumpCounter < 2) {
                yVelocity = -15;
                isJumping = true;
                jumpCounter++;
                jumpKeyHeld = true;
            }
        } else {
            jumpKeyHeld = false;
        }

        yVelocity += 1; // gravity

        x += xVelocity;
        y += yVelocity;

        if (y > 500) { // ground level
            y = 500;
            yVelocity = 0;
            jumpCounter = 0;
            isJumping = false;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    public void setJumpCounter(int jumpCounter) {
        this.jumpCounter = jumpCounter;
    }
}
