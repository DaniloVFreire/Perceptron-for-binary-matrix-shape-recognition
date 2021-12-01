package src.Perceptrons;

import java.util.ArrayList;

import static src.Utils.*;


public class NeuralNetwork {

    ArrayList<Perceptron> perceptrons = new ArrayList<>();

    public NeuralNetwork() {
        for (int i = 3; i <= 20; i++) {
            perceptrons.add(new Perceptron(i * i));
        }
    }

    public void train(int[][] question, int rightAnswer) {
        if (question[0].length > 2) {
            Perceptron perceptron = perceptrons.get((question[0].length - 3));
            try {
                perceptron.train(question, rightAnswer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int infer(int[][] question) {
        int counter = 0, answer;
        int[][] submatrix;
        if (question.length > 19) {
            for (int i = 3; i <= question.length; i++) {//matrix size ixi
                for (int j = 0; j < question.length - i + 1; j++) { // submatrix inicial position j
                    for (int k = 0; k <= question[0].length - i + 1; k++) { // submatrix inicial position k
                        submatrix = new int[i - 1][i];
                        for (int l = 0; l < (i - 1); l++) {
                            for (int m = 0; m < i; m++) {
                                submatrix[l][m] = question[l + k][m + j];
                            }
                        }
                        Perceptron perceptron = perceptrons.get((i - 3));
                        answer = perceptron.infer(submatrix);

                        counter += answer;
                        if (answer == 1) {
                            System.out.println(submatrix[0].length);
                            printReusableMatrix(submatrix);
                            System.out.println(answer);
                        }
                    }
                }
            }
            return counter;
        }
        return -1;
    }
}
