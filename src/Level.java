import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Platform> platforms;
    private Platform goalPlatform;

    public Level(List<Platform> platforms, Platform goalPlatform) {
        this.platforms = platforms;
        this.goalPlatform = goalPlatform;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public Platform getGoalPlatform() {
        return goalPlatform;
    }
}
