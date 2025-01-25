package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int x, y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // getters
    public int getX() { 
        return x; 
    }

    public int getY() { 
        return y; 
    }
    public Direction getDirection() { 
        return direction; 
    }

    // setters
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    // logic
    public void moveForward() {
        switch (direction) {
            case NORTH: y--; break;
            case EAST: x++; break;
            case SOUTH: y++; break;
            case WEST: x--; break;
        }
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }
}