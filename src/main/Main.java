package src.main;

import src.Perceptrons.NeuralNetwork;

import java.io.*;
import java.util.Scanner;

import static src.Utils.printArray;
import static src.Utils.printMatrix;

public class Main {

    public static void main(String[] args) throws IOException {
        //ler casos de treino (arquivo)
        //Treinar modelo (chamar função de treino)
        //ler arquivo de teste
        NeuralNetwork nn = new NeuralNetwork();
        readAndTrain(nn);
        readAndTest(nn);
    }
    public static void readAndTrain(NeuralNetwork nn) throws IOException {
        for (int k = 0; k < 8; k++) {
            Scanner traininInput = new Scanner(new File("src/main/treino.txt"));
            int size, nexInt;
            while (traininInput.hasNextInt()){
                nexInt = traininInput.nextInt();
                if(nexInt != 0 && nexInt != 1){
                    int [][] matrix = new int [nexInt] [nexInt];
                    traininInput.nextInt();
                    for (int i = 0; i < nexInt; i++) {
                        for (int j = 0; j < nexInt; j++) {
                            matrix[i][j] = traininInput.nextInt();
                        }
                    }
                    //System.out.println(nexInt);
                    nexInt = traininInput.nextInt();
                    //printMatrix(matrix);
                    nn.train(matrix, nexInt);
                }
            }
        }
    }

    public static void readAndTest(NeuralNetwork nn) throws IOException {
            Scanner testInput = new Scanner(new File("src/main/test.txt"));
            int size, nexInt;
            while (testInput.hasNextInt()){
                nexInt = testInput.nextInt();
                if(nexInt != 0 && nexInt != 1){
                    int [][] matrix = new int [nexInt] [nexInt];
                    testInput.nextInt();
                    for (int i = 0; i < nexInt; i++) {
                        for (int j = 0; j < nexInt; j++) {
                            matrix[i][j] = testInput.nextInt();
                        }
                    }
                    System.out.println("matrix");
                    //printMatrix(matrix);
                    System.out.println("resultado " + nn.infer(matrix));
                }
            }
    }
}
