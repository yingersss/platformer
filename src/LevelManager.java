import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelManager {
    private List<Level> levels;
    private int currentLevelIndex;

    public LevelManager() {
        levels = new ArrayList<>();
        currentLevelIndex = 0;

        // level 1
        levels.add(new Level(Arrays.asList(
                new Platform(200, 400, 100, 10, Color.GRAY),
                new Platform(400, 300 , 100, 10, Color.GRAY),
                new Platform(600, 200, 100, 10, Color.GRAY)
        ), new Platform(750, 100, 50, 10, Color.GREEN)));

        // level 2
        levels.add(new Level(Arrays.asList(
                new Platform(150, 450, 100, 10, Color.GRAY),
                new Platform(350, 350, 100, 10, Color.GRAY),
                new Platform(550, 250, 100, 10, Color.GRAY)
        ), new Platform(700, 70, 50, 10, Color.GREEN)));

        // add more here
    }

    public Level getCurrentLevel() {
        return levels.get(currentLevelIndex);
    }

    public void advanceToNextLevel() {
        if (currentLevelIndex < levels.size() - 1) {
            currentLevelIndex++;
        } else {
            System.out.println("Congratulations! You've completed all the levels!");
        }
    }
}
