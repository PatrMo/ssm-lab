package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.*;

public class PathFindingFactory implements MazeRunnerFactory {
    @Override
    public void run(Maze maze) {
        Explorer explorer = new Explorer(maze);
        PathFinder pathFinder = new RightHandRule(explorer);
        String computedPath = pathFinder.findPath();
        System.out.println("Computed Path: " + computedPath);
    }
}