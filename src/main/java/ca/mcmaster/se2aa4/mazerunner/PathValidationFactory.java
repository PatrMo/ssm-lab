package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.*;

public class PathValidationFactory implements MazeRunnerFactory {
    private final String path;

    public PathValidationFactory(String path) {
        this.path = path;
    }

    @Override
    public void run(Maze maze) {
        Explorer explorer = new Explorer(maze);
        PathValidator validator = new PathValidator(explorer);
        boolean isValid = validator.isValidPath(path);
        System.out.println(isValid ? "Path is VALID." : "Path is INVALID.");
    }
}