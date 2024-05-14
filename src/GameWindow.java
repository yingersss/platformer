import javax.swing.JFrame;

public class GameWindow extends JFrame {
    private GamePanel panel;

    public GameWindow() {
        panel = new GamePanel();
        this.setTitle("Platformer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
