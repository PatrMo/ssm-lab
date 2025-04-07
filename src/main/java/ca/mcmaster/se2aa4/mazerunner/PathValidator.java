package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {
    private Explorer explorer;

    public PathValidator(Explorer explorer) {
        this.explorer = explorer;
    }

    public boolean isValidPath(String path) {
        String expandedPath = expandFactorizedPath(path); // Expand 
        
        for (char command : expandedPath.toCharArray()) {
            System.out.println(command);
            Command cmd;
            switch (command) {
                case 'F':
                    if (!explorer.canMoveForward()) return false;
                    cmd = new MoveForwardCommand(explorer);
                    break;
                case 'L':
                    cmd = new TurnLeftCommand(explorer);
                    break;
                case 'R':
                    cmd = new TurnRightCommand(explorer);
                    break;
                default:
                    return false;
            }
            cmd.execute();
        }

        // Check if we reached the exit

        if (explorer.getPosition().getX()==explorer.getPosition().getMaze().getExit().getX() & explorer.getPosition().getY()==explorer.getPosition().getMaze().getExit().getY()) {
            return true;
        }
        else {
            return false;
        }
        //return explorer.getPosition().equals(explorer.getPosition().getMaze().getExit()); -- doesn't work due to direction maybe refactor in future
    }


    // Expands factorized path notation

    private String expandFactorizedPath(String factorizedPath) {
        StringBuilder expanded = new StringBuilder();
        StringBuilder numberBuffer = new StringBuilder();

        for (char c : factorizedPath.toCharArray()) {
            if (Character.isDigit(c)) {
                numberBuffer.append(c); // Build the number
            } else {
                int repeat = numberBuffer.length() > 0 ? Integer.parseInt(numberBuffer.toString()) : 1;
                expanded.append(String.valueOf(c).repeat(repeat));
                numberBuffer.setLength(0); // Reset buffer
            }
        }

        return expanded.toString();
    }
}
