package org.example;

public class Main {
    public static void main(String[] args){
        int MAZE_T = 5;
        if (args.length > 0 ) {
            try {
                MAZE_T = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                System.err.println("Invalid maze size. Using default size: " + MAZE_T);
            }
        }
            SimpleImperfectMazeGenerator SIMG = new SimpleImperfectMazeGenerator(MAZE_T);
            char[][] maze = SIMG.generateMaze();
            SIMG.printMaze(maze);
        }
    }
