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
        }

        findEntryAndExit();
    }

    private void findEntryAndExit() {
        // Look for entry and exit in the left and right columns only
        for (int i = 0; i < height; i++) {
            if (entry == null && grid[i][0] == ' ') {
                entry = new Position(i, 0, Direction.EAST, this);
            } 
            if (exit == null && grid[i][width - 1] == ' ') {
                exit = new Position(i, width - 1, Direction.WEST, this);
            }
        }

        if (entry == null || exit == null) {
            throw new IllegalArgumentException("Invalid maze: Entry and/or exit not found.");
        }
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width && grid[x][y] == ' ';
    }

    // Getters
    public Position getEntry() {
        return entry;
    }

    public Position getExit() {
        return exit;
    }
}
