package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RightHandRuleTest {

    @Test
    public void testFindsAPath() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        Explorer explorer = new Explorer(maze);
        RightHandRule pathFinder = new RightHandRule(explorer);
        String path = pathFinder.findPath();
        assertNotNull(path);
        assertFalse(path.isEmpty());
    }
}