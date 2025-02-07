package ca.mcmaster.se2aa4.mazerunner;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Maze {
    private char[][] grid;
    private int width, height;
    private Position entry;
    private Position exit;

    public Maze(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        height = lines.size();
        width = lines.get(0).length();
        grid = new char[height][width];

        for (int i = 0; i < height; i++) {
            grid[i] = lines.get(i).toCharArray();
            // Find entry and exit points (assuming they're on the borders)
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == ' ' && (i == 0 || i == height - 1 || j == 0 || j == width - 1)) {
                    if (entry == null) {
                        entry = new Position(i, j, Direction.EAST, this);  // Assuming the first entry point is on the East
                    } else {
                        exit = new Position(i, j, Direction.WEST, this); // Assuming the second entry point is the exit
                    }
                }
            }
        }
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width && grid[x][y] == ' ';
    }

    //getters
    public Position getEntry() {
        return entry;
    }
    public Position getExit() {
        return exit;
    }
}