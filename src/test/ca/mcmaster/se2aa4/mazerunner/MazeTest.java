package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    @Test
    public void testLoadMaze_successfully() throws Exception {
        Maze maze = new Maze("src/test/resources/simple_maze.txt");
        assertNotNull(maze);
        assertNotNull(maze.getEntry());
        assertNotNull(maze.getExit());
    }

    @Test
    public void testIsValidMove_insidePath() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        assertTrue(maze.isValidMove(8, 0));
    }

    @Test
    public void testIsValidMove_outsideMaze() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        assertFalse(maze.isValidMove(-1, -1));
        assertFalse(maze.isValidMove(100, 100));
    }

}
