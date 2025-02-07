package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {
    private Explorer explorer;

    public PathValidator(Explorer explorer) {
        this.explorer = explorer;
    }

    /**
     * Validates if a given path correctly leads from the entry to the exit.
     * 
     * @param path The input path as a string (e.g., "6F L 2F R 3F L F")
     * @return True if the path is valid, False otherwise
     */
    public boolean isValidPath(String path) {
        String expandedPath = expandFactorizedPath(path); // Expand "6F" → "FFFFFF"
        
        for (char command : expandedPath.toCharArray()) {
            switch (command) {
                case 'F':
                    if (!explorer.canMoveForward()) {
                        return false;  // Invalid move (wall or boundary)
                    }
                    explorer.moveForward();
                    break;
                case 'L':
                    explorer.turnLeft();
                    break;
                case 'R':
                    explorer.turnRight();
                    break;
                default:
                    return false;  // Invalid character in path
            }
        }

        // Check if we reached the exit
        return explorer.getPosition().equals(explorer.getPosition().getMaze().getExit());
    }

    /**
     * Expands factorized path notation (e.g., "3F L 2F" → "FFF L FF")
     */
    private String expandFactorizedPath(String factorizedPath) {
        StringBuilder expanded = new StringBuilder();
        StringBuilder numberBuffer = new StringBuilder();

        for (char c : factorizedPath.toCharArray()) {
            if (Character.isDigit(c)) {
                numberBuffer.append(c); // Build the number (e.g., "6")
            } else {
                int repeat = numberBuffer.length() > 0 ? Integer.parseInt(numberBuffer.toString()) : 1;
                expanded.append(String.valueOf(c).repeat(repeat));
                numberBuffer.setLength(0); // Reset buffer
            }
        }

        return expanded.toString();
    }
}
