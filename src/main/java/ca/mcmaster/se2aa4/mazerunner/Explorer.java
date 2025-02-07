package ca.mcmaster.se2aa4.mazerunner;

public class Explorer {
    private Position position;
    private Maze maze;

    public Explorer(Maze maze) {
        this.maze = maze;
        Position entry = maze.getEntry();
        this.position = new Position(entry.getX(), entry.getY(), entry.getDirection(), maze);
    }

    public Position getPosition() {
        return position;
    }

    public boolean canMoveForward() {
        return position.canMoveForward();
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

}
