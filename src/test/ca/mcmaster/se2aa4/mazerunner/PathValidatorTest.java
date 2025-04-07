package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PathValidatorTest {

    @Test
    public void testValidPath() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt"); // ensure this file exists
        Explorer explorer = new Explorer(maze);
        PathValidator validator = new PathValidator(explorer);
        assertTrue(validator.isValidPath("F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F"));
    }

    @Test
    public void testInvalidPath_dueToWall() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        Explorer explorer = new Explorer(maze);
        PathValidator validator = new PathValidator(explorer);
        assertFalse(validator.isValidPath("1F 1F")); // too far, hits a wall
    }

    @Test
    public void testInvalidPath_dueToBadCommand() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        Explorer explorer = new Explorer(maze);
        PathValidator validator = new PathValidator(explorer);
        assertFalse(validator.isValidPath("1F X 2F"));
    }
}