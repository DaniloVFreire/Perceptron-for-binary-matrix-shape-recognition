package src.Perceptrons;

import java.util.concurrent.TimeUnit;

import static src.Utils.printArray;
import static src.Utils.printMatrix;

public class Perceptron {
    //A percetron to recognize a 20x20 matrix scaled by any matrix with i = j
    // witch contains a rectagle with height one less the width

    double bias = -0.01;// Viez inicial

    int size;

    private double[] weights; //matriz com 2 perceptrons(2 arrays de 25)

    double learningRate = 0.001;//Taxa de Aprendizagem

    Perceptron(int _size) {
        this.weights = new double[_size];
        this.size = _size;
    }

    public void train(int[][] question, int rightAnswer) throws InterruptedException {
        int inferedAnswer;
        int errorRate = 1;
        int counter = 0;
        while (errorRate != 0) {

            inferedAnswer = infer(question);

            errorRate = rightAnswer - inferedAnswer; //verificando se a IA acertou;
            for (int i = 0; i < question.length; i++) {
                for (int j = 0; j < question[0].length; j++) {
                    weights[i * j] = weights[i * j] + (learningRate * errorRate * question[i][j]);
                }
            }
            ++counter;
        }
    }

    public int infer(int[][] question) {
        double y = 0; // resultado cru da inferencia do perceptron
        int inferedAnswer = 0;

        for (int i = 0; i < question.length; i++) {
            for (int j = 0; j < question[0].length; j++) {
                y += weights[i * j] * question[i][j];
            }
        }
        y += bias;

        if (y >= 0) {
            inferedAnswer = 1;// Achou H
        }

        return inferedAnswer;
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
