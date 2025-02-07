public class Explorer {
    private Position position;

    public Explorer(Maze maze) {
        this.position = new Position(maze.getEntry().getX(), maze.getEntry().getY(), Direction.EAST, maze);
    }

    public Position getPosition() {
        return position;
    }

    public void moveForward() {
        if (position.canMoveForward()) {
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