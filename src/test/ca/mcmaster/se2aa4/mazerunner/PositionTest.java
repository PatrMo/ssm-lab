package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    private Maze maze;
    private Position position;

    @BeforeEach
    public void setup() throws Exception {
        maze = new Maze("examples/small.maz.txt");
        position = new Position(maze.getEntry().getX(), maze.getEntry().getY(), Direction.EAST, maze);
    }

    @Test
    public void testCanMoveForward_valid() {
        assertTrue(position.canMoveForward());
    }

    @Test
    public void testMoveForward_changesCoordinates() {
        int initialX = position.getX();
        int initialY = position.getY();

        position.moveForward();

        assertTrue(initialX != position.getX() || initialY != position.getY());
    }

    @Test
    public void testTurnRightCorrectly() {
        position.setDirection(Direction.NORTH);
        position.turnRight();
        assertEquals(Direction.EAST, position.getDirection());
    }

    @Test
    public void testTurnLeftCorrectly() {
        position.setDirection(Direction.NORTH);
        position.turnLeft();
        assertEquals(Direction.WEST, position.getDirection());
    }

    @Test
    public void testCannotMoveIntoWall() {
        Position wallFacing = new Position(0, 0, Direction.NORTH, maze);
        assertFalse(wallFacing.canMoveForward());
    }
}
