package ca.mcmaster.se2aa4.mazerunner;
public class Explorer {
    private Maze maze;
    private Position position;

    public Explorer(Maze maze) {
        this.maze = maze;
        this.position = maze.getEntry();
    }

    public String exploreMaze() {
        StringBuilder path = new StringBuilder();
        
        // We will follow the right hand rule.
        while (!(position.getX() == maze.getExit().getX() && position.getY() == maze.getExit().getY())) {
            // Try turning right first.
            position.turnRight();
            if (canMoveForward()) {
                position.moveForward();
                path.append("F");
            } else {
                // If right is blocked, try moving forward.
                if (canMoveForward()) {
                    position.moveForward();
                    path.append("F");
                } else {
                    // If both right and forward are blocked, turn left.
                    position.turnLeft();
                    path.append("L");
                }
            }
        }

        return path.toString();
    }

    // Check if the explorer can move forward.
    private boolean canMoveForward() {
        int x = position.getX();
        int y = position.getY();
        switch (position.getDirection()) {
            case NORTH: return maze.isValidMove(x - 1, y);
            case EAST: return maze.isValidMove(x, y + 1);
            case SOUTH: return maze.isValidMove(x + 1, y);
            case WEST: return maze.isValidMove(x, y - 1);
            default: return false;
        }
    }
}