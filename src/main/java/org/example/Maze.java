package org.example;

public class Maze {

    public interface MazeGenerator{
        int MAZE_T = 5;  // Taille de la grille (5x5)
        final int CELL_T = 3;  // Taille d'une cellule (3x3)
        final char MUR = '#';    // Caractère pour les murs
        final char POINT = '.';   // Caractère pour les chemins

        char[][] generateMaze();

        default void printMaze(char[][] maze) {
            for (char[] row : maze) {
                for (char cell : row) {
                    System.out.print(cell);
                }
                System.out.println();
            }
        }
    }
}