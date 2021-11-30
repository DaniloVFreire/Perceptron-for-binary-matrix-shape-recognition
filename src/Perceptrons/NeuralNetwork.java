package src.Perceptrons;

import java.util.ArrayList;

import static src.Utils.*;


public class NeuralNetwork {
    //Neural network with perceptrons to recognize all the possible
    //rectangles with height + 1 = width, exsting in the 1x1 to 20x20 matrixes
    // 2 3, 3 4, 4 5, 5 6, 6 7, 7 8, 8 9, 9 10
    // 19 20, 18 perceptrons

    ArrayList<Perceptron> perceptrons = new ArrayList<>();

    public NeuralNetwork() {
        for (int i = 3; i <= 20; i++) {
            perceptrons.add(new Perceptron(i * i));
        }
    }

    public void train(int[][] question, int rightAnswer) {

        if (question.length > 2) {
            Perceptron perceptron = perceptrons.get((question.length - 3));
            try {
                perceptron.train(question, rightAnswer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int infer(int[][] question) {
        int counter = 0;
        int[][] submatrix = {} ;
        if (question.length > 19) {
            for (int i = 3; i <= question.length; i++) {//matrix size ixi
                for (int j = 0; j < question.length-i+1; j++) { // submatrix inicial position j
                    for (int k = 0; k < question[0].length-i+1; k++) { // submatrix inicial position k
                        submatrix = new int[i][i];
                        for (int l = j; l < i; l++) {
                            for (int m = k; m < i; m++) {
                                submatrix[l][m] = question[j+l][m+k];
                            }
                        }
                    }
                    Perceptron perceptron = perceptrons.get((i - 3));
                    counter+=perceptron.infer(submatrix);
                    System.out.println("answer" + counter);
                    printReusableMatrix(submatrix);
                }
            }

            return counter;
        } else {
            return 0;
        }
    }
}
