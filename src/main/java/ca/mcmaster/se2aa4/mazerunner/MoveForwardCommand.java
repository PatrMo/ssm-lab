package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Explorer;


public class MoveForwardCommand implements Command {
    private Explorer explorer;
    
    public MoveForwardCommand(Explorer explorer) {
        this.explorer = explorer;
    }

    @Override
    public void execute() {
        explorer.moveForward();
    }
}
