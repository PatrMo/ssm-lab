package ca.mcmaster.se2aa4.mazerunner;

public class Explorer {
    private Position position;
    private Maze maze;

    public Explorer(Maze maze) {
        this.maze = maze;
        this.position = maze.getEntry();
    }

    public Position getPosition() {
        return position;
    }

    public void moveForward() {
        if (canMoveForward()) {
            position.moveForward();
        }
    }

    public void turnRight() {
        position.turnRight();
    }

    public void turnLeft() {
        position.turnLeft();
    }

    private boolean canMoveForward() {
        int x = position.getX();
        int y = position.getY();
        switch (position.getDirection()) {
            case NORTH: return maze.isValidMove(x - 1, y);
            case EAST:  return maze.isValidMove(x, y + 1);
            case SOUTH: return maze.isValidMove(x + 1, y);
            case WEST:  return maze.isValidMove(x, y - 1);
            default: return false;
        }
    }
}
