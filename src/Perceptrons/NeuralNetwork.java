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
        if (question[0].length > 2) {
            Perceptron perceptron = perceptrons.get((question[0].length - 3));
            try {
                perceptron.train(question, rightAnswer);
//                if (rightAnswer == 1)
//                    printMatrix(question);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int infer(int[][] question) {
        int counter = 0, answer, submatrix_counter = 0;
        int[][] submatrix;
        if (question.length > 19) {
            for (int i = 3; i <= question.length; i++) {//matrix size ixi
                for (int j = 0; j < question.length - i + 1; j++) { // submatrix inicial position j
                    for (int k = 0; k <= question[0].length - i + 1; k++) { // submatrix inicial position k
//                        System.out.println("k = " + (question[0].length-i+2) + " j = " + (question.length-i+1));
//                        System.out.println("k = " + (k) + " j = " + (j));
//                        System.out.println("ci"+ (0) +"cf");
//                        System.out.println("li"+ "lf");
                        submatrix = new int[i - 1][i];
                        for (int l = 0; l < (i - 1); l++) {
                            for (int m = 0; m < i; m++) {
                                submatrix[l][m] = question[l + k][m + j];
                            }
                        }
                        submatrix_counter++;
                        Perceptron perceptron = perceptrons.get((i - 3));
                        answer = perceptron.infer(submatrix);
//                        printReusableMatrix(submatrix);
//                        System.out.println(submatrix_counter);

                        counter += answer;
                        if (answer == 1) {
                            System.out.println(submatrix[0].length);
                            printReusableMatrix(submatrix);
                            //System.out.println(answer);
                            System.out.println(0 + "\n");
                        }
                    }
                }
            }
            return counter;
        }
        return -1;
    }
}
