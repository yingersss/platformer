import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private boolean leftPressed, rightPressed, jumpPressed;
    private Player player;
    private Platform[] platforms;
    private LevelManager levelManager;

    public GamePanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocusInWindow();

        timer = new Timer(16, this); // ~60 FPS
        timer.start();

        player = new Player(100, 500);
        levelManager = new LevelManager();
        System.out.println("GamePanel initialized");

    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    private void update() {
        player.update(leftPressed, rightPressed, jumpPressed);
        checkCollisions();

        Platform goalPlatform = levelManager.getCurrentLevel().getGoalPlatform();
        if (player.getBounds().intersects(goalPlatform.getBounds())) {
            levelManager.advanceToNextLevel();
            resetPlayerPosition();
        }
    }

    private void checkCollisions() {
        for (Platform platform : levelManager.getCurrentLevel().getPlatforms()) {
            if (player.getBounds().intersects(platform.getBounds()) && player.getBounds().y + player.getBounds().height <= platform.getBounds().y + player.getBounds().height / 2) {
                player.setY(platform.getBounds().y - player.getBounds().height);
                player.setyVelocity(0);
                player.setJumping(false);
                player.setJumpCounter(0);
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        for (Platform platform : levelManager.getCurrentLevel().getPlatforms()) {
            platform.draw(g);
        }
        levelManager.getCurrentLevel().getGoalPlatform().draw(g); // Draw the goal platform
        // draw game objects
    }

    public void keyTyped(KeyEvent e) {
    }

    private void resetPlayerPosition() {
        player.setX(100);
        player.setY(500);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        } else if (key == KeyEvent.VK_SPACE) {
            jumpPressed = true;
        }

        System.out.println("Key pressed: " + KeyEvent.getKeyText(key));

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        } else if (key == KeyEvent.VK_SPACE) {
            jumpPressed = false;
        }

        System.out.println("Key released: " + KeyEvent.getKeyText(key));
    }
}
