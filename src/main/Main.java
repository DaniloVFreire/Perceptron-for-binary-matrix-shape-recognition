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
        for (int k = 0; k < 1; k++) {
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
//                    System.out.println(size);
                    //printMatrix(matrix);
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
                //System.out.println("matrix");
                //printMatrix(matrix);
                //nn.infer(matrix);
                System.out.println("Quantidade de retângulos " + nn.infer(matrix));
            }
        }
    }
}

//    public static void readAndTest2(NeuralNetwork nn) throws IOException {
//        Scanner testInput = new Scanner(new File("src/main/test.txt"));
//        int size, nexInt;
//        while (testInput.hasNextInt()){
//            nexInt = testInput.nextInt();
//            if(nexInt != 0 && nexInt != 1){
//                int [][] matrix = new int [nexInt] [nexInt];
//                testInput.nextInt();
//                for (int i = 0; i < nexInt; i++) {
//                    for (int j = 0; j < nexInt; j++) {
//                        matrix[i][j] = testInput.nextInt();
//                    }
//                }
//                //System.out.println("matrix");
//                //printMatrix(matrix);
//                nn.infer(matrix);
//                //System.out.println("resultado " + nn.infer(matrix));
//            }
//        }
//    }
//}

//    public static void readAndTrain2(NeuralNetwork nn) throws IOException {
//        for (int k = 0; k < 8; k++) {
//            Scanner traininInput = new Scanner(new File("src/main/treino.txt"));
//            int size, nexInt;
//            while (traininInput.hasNextInt()){
//                nexInt = traininInput.nextInt();
//                if(nexInt != 0 && nexInt != 1){
//                    int [][] matrix = new int [nexInt] [nexInt];
//                    traininInput.nextInt();
//                    for (int i = 0; i < nexInt; i++) {
//                        for (int j = 0; j < nexInt; j++) {
//                            matrix[i][j] = traininInput.nextInt();
//                        }
//                    }
//                    //System.out.println(nexInt);
//                    nexInt = traininInput.nextInt();
//                    //printMatrix(matrix);
//                    nn.train(matrix, nexInt);
//                }
//            }
//        }
//    }
