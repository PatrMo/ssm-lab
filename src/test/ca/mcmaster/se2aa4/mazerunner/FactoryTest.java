package ca.mcmaster.se2aa4.mazerunner.factory;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    @Test
    public void testPathFindingFactory() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        MazeRunnerFactory factory = new PathFindingFactory();

        assertDoesNotThrow(() -> factory.run(maze));
    }

    @Test
    public void testPathValidationFactory_valid() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        MazeRunnerFactory factory = new PathValidationFactory("F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F");

        assertDoesNotThrow(() -> factory.run(maze));
    }

    @Test
    public void testPathValidationFactory_invalid() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        MazeRunnerFactory factory = new PathValidationFactory("10F"); 

        assertDoesNotThrow(() -> factory.run(maze));
    }
}