package src.main;

import src.Perceptrons.NeuralNetwork;

import java.io.*;
import java.util.Scanner;

import static src.Utils.printMatrix;

public class Main {

    public static void main(String[] args) throws IOException {
        NeuralNetwork nn = new NeuralNetwork();
        readAndTrain(nn);
        readAndTest(nn);
    }

    public static void readAndTrain(NeuralNetwork nn) throws IOException {
        for (int k = 0; k < 40; k++) {//epochs
            Scanner traininInput = new Scanner(new File("src/main/treino.txt"));
            int size, desiredAnswer;
            while (traininInput.hasNextInt()) {
                size = traininInput.nextInt();
                if (size != 0 && size != 1) {
                    int[][] matrix = new int[size - 1][size];
                    for (int i = 0; i < size - 1; i++) {
                        for (int j = 0; j < size; j++) {
                            matrix[i][j] = traininInput.nextInt();
                        }
                    }
                    desiredAnswer = traininInput.nextInt();
                    nn.train(matrix, desiredAnswer);
                }
            }
        }
    }

    public static void readAndTest(NeuralNetwork nn) throws IOException {
        Scanner testInput = new Scanner(new File("src/main/test.txt"));
        int size;
        while (testInput.hasNextInt()) {
            size = testInput.nextInt();
            if (size != 0 && size != 1) {
                int[][] matrix = new int[size][size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = testInput.nextInt();
                    }
                }
                System.out.println("Quantidade de retângulos " + nn.infer(matrix));
            }
        }
    }
}
