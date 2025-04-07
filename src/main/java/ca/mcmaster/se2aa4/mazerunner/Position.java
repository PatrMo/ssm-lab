package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int x, y;
    private Direction direction;
    private Maze maze;

    public Position(int x, int y, Direction direction, Maze maze) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.maze = maze;
    }

    // getters
    public int getX() { return x; }
    public int getY() { return y; }
    public Direction getDirection() { return direction; }
    public Maze getMaze() {
        return this.maze;
    }

    // setter
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean canMoveForward() {
        switch (direction) {
            case NORTH: return maze.isValidMove(x - 1, y);
            case EAST: return maze.isValidMove(x, y + 1);
            case SOUTH: return maze.isValidMove(x + 1, y);
            case WEST: return maze.isValidMove(x, y - 1);
            default: return false;
        }
    }

    public void moveForward() {
        if (!canMoveForward()) return;
        switch (direction) {
            case NORTH: x--; break;
            case EAST: y++; break;
            case SOUTH: x++; break;
            case WEST: y--; break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case NORTH: direction = Direction.EAST; break;
            case EAST: direction = Direction.SOUTH; break;
            case SOUTH: direction = Direction.WEST; break;
            case WEST: direction = Direction.NORTH; break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case NORTH: direction = Direction.WEST; break;
            case EAST: direction = Direction.NORTH; break;
            case SOUTH: direction = Direction.EAST; break;
            case WEST: direction = Direction.SOUTH; break;
        }
    }

}