package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule implements PathFinder {
    private Explorer explorer;
    private StringBuilder path;

    public RightHandRule(Explorer explorer) {
        this.explorer = explorer;
        this.path = new StringBuilder();
    }

    @Override
    public String findPath() {
        Command turnRight = new TurnRightCommand(explorer);
        Command moveForward = new MoveForwardCommand(explorer);
        Command turnLeft = new TurnLeftCommand(explorer);
        while (!hasReachedExit()) {
            if (canTurnRight()) {
                turnRight.execute();
                path.append("R");
                moveForward.execute();
                path.append("F");
            } else if (canMoveForward()) {
                moveForward.execute();
                path.append("F");
            } else {
                turnLeft.execute();
                path.append("L");
            }
        }
        return factorizePath(path.toString().trim());
    }

    private boolean hasReachedExit() {
        Position pos = explorer.getPosition();
        Position exit = pos.getMaze().getExit();
        return pos.getX() == exit.getX() && pos.getY() == exit.getY();
    }

    private boolean canTurnRight() {
        explorer.turnRight();
        boolean canMove = explorer.getPosition().canMoveForward();
        explorer.turnLeft();
        return canMove;
    }

    private boolean canMoveForward() {
        return explorer.getPosition().canMoveForward();
    }

    private String factorizePath(String canonicalPath) {
        StringBuilder factorized = new StringBuilder();
        char prev = ' ';
        int count = 0;

        for (char c : canonicalPath.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                if (count > 1) {
                    factorized.append(count).append(prev).append(" ");
                } else if (count == 1) {
                    factorized.append(prev).append(" ");
                }
                prev = c;
                count = 1;
            }
        }

        if (count > 1) {
            factorized.append(count).append(prev);
        } else {
            factorized.append(prev);
        }

        return factorized.toString();
    }
}