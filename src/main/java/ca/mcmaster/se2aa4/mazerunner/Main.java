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

            Maze maze = new Maze(mazeFile);
            MazeRunnerFactory factory = (inputPath != null) ? new PathValidationFactory(inputPath) : new PathFindingFactory();

            factory.run(maze);
        } catch (Exception e) {
            //logger.error("An error occurred while processing the maze.", e);
            System.out.println("An error occurred while processing the maze: " + e.getMessage());
        }

        //logger.info("** End of Maze Runner **");
    }
}
