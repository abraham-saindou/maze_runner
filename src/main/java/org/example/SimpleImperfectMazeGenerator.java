package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimpleImperfectMazeGenerator implements Maze.MazeGenerator {
    private int MAZE_T;
    private static final int[][] DIRECTIONS = {
            {-CELL_T, 0},   // Up
            {CELL_T, 0},    // Down
            {0, -CELL_T},   // Left
            {0, CELL_T}};
    private Random random;

    public SimpleImperfectMazeGenerator(int MAZE_T){
        this.MAZE_T = MAZE_T;
        random = new Random();
    }
    @Override
    public char[][] generateMaze() {
        char[][] maze = new char[MAZE_T * CELL_T][MAZE_T * CELL_T];

        // Initialiser le labyrinthe
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = MUR;
            }
        }
        // Remplir les cellules avec des points
        for (int i = 1; i < maze.length; i += CELL_T) {
            for (int j = 1; j < maze[0].length; j += CELL_T) {
                maze[i][j] = POINT;
            }
        }
        exploreMaze(maze, 1, 1);
        return maze;
    }

    private void exploreMaze(char[][] maze, int row, int col) {
        maze[row][col] = POINT;  // Marquer la cellule comme visitée

        List<int[]> directions = new ArrayList<>();
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0] * CELL_T;
            int newCol = col + dir[1] * CELL_T;

            // Vérification si la nouvelle cellule est valide
            if (newRow > 0 && newRow < maze.length - 1 && newCol > 0 && newCol < maze[0].length - 1 && maze[newRow][newCol] == MUR) {
                directions.add(dir);
            }
        }
        // Mélange des directions aléatoirement
        Collections.shuffle(directions, random);

        for (int[] dir : directions) {
            int newRow = row + dir[0] * CELL_T;
            int newCol = col + dir[1] * CELL_T;
            int wallRow = row + dir[0];
            int wallCol = col + dir[1];

            // Suppression du mur entre la cellule actuelle et la nouvelle cellule
            maze[wallRow][wallCol] = POINT;

            // Céllule suivante
            exploreMaze(maze, newRow, newCol);
        }
    }
}
