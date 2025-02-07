package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRulePathFinder implements PathFinder {
    private Explorer explorer;
    
    public RightHandRulePathFinder(Explorer explorer) {
        this.explorer = explorer;
    }

    @Override
    public String findPath() {
        StringBuilder path = new StringBuilder();

        while (!explorer.getPosition().equals(explorer.getPosition().getMaze().getExit())) {
            explorer.turnRight();
            if (explorer.canMoveForward()) {
                explorer.moveForward();
                path.append("F");
            } else {
                explorer.turnLeft();
                if (explorer.canMoveForward()) {
                    explorer.moveForward();
                    path.append("F");
                } else {
                    explorer.turnLeft();
                    path.append("L");
                }
            }
        }
        return factorizePath(path.toString());
    }

    private String factorizePath(String path) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == path.charAt(i - 1)) {
                count++;
            } else {
                result.append(count > 1 ? count : "").append(path.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count > 1 ? count : "").append(path.charAt(path.length() - 1));
        return result.toString();
    }
}
