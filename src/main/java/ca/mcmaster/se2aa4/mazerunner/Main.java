package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner **");

        Options options = new Options();
        options.addOption("i", "input", true, "Input file containing the maze");
        options.addOption("p", "path", true, "Path to verify (e.g., '6F L 2F R 3F')");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            String mazeFile = cmd.getOptionValue("i");
            String inputPath = cmd.getOptionValue("p");

            if (mazeFile == null) {
                logger.error("Error: Missing input file. Please provide the maze file using the -i option.");
                return;
            }

            logger.info("Reading the maze from file: " + mazeFile);
            Maze maze = new Maze(mazeFile);
            Explorer explorer = new Explorer(maze);

            if (inputPath != null) {
                // Validate path using the new PathValidator class
                PathValidator validator = new PathValidator(explorer);
                boolean isValid = validator.isValidPath(inputPath);
                logger.info(isValid ? "Path is VALID." : "Path is INVALID.");
            } else {
                // Compute a path using the right-hand rule algorithm
                PathFinder pathFinder = new RightHandRulePathFinder(explorer);
                String computedPath = pathFinder.findPath();
                logger.info("Computed Path: " + computedPath);
            }
        } catch (Exception e) {
            logger.error("An error occurred while processing the maze.", e);
        }

        logger.info("** End of Maze Runner **");
    }
}
