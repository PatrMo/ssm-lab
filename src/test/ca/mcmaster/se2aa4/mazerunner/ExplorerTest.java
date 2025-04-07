package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExplorerTest {

    private Explorer explorer;

    @BeforeEach
    public void setup() throws Exception {
        Maze maze = new Maze("examples/small.maz.txt");
        explorer = new Explorer(maze);
    }

    @Test
    public void testMoveForward() {
        if (explorer.canMoveForward()) {
            int initialX = explorer.getPosition().getX();
            int initialY = explorer.getPosition().getY();

            explorer.moveForward();

            assertNotEquals(initialX, explorer.getPosition().getX());
            assertNotEquals(initialY, explorer.getPosition().getY());
        }
    }

    @Test
    public void testTurnRight() {
        Direction initial = explorer.getPosition().getDirection();
        explorer.turnRight();
        Direction turned = explorer.getPosition().getDirection();

        assertNotEquals(initial, turned);
    }

    @Test
    public void testTurnLeft() {
        Direction initial = explorer.getPosition().getDirection();
        explorer.turnLeft();
        Direction turned = explorer.getPosition().getDirection();

        assertNotEquals(initial, turned);
    }
}