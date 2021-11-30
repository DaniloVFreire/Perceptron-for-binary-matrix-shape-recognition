package src.Perceptrons;

import java.util.concurrent.TimeUnit;

import static src.Utils.printArray;
import static src.Utils.printMatrix;

public class Perceptron {
    //A percetron to recognize a 20x20 matrix scaled by any matrix with i = j
    // witch contains a rectagle with height one less the width

    double bias = -0.01;// Viez inicial

    int size;

    private double [] weights; //matriz com 2 perceptrons(2 arrays de 25)

    double learningRate = 0.001;//Taxa de Aprendizagem

    Perceptron(int _size){
        this.weights = new double[_size];
        this.size = _size;
    }

    public void train(int [] [] question, int rightAnswer) throws InterruptedException {
        int inferedAnswer ; // tipos de resposta vistas em aula [0,0](nada), [0,1](M), [1,0](H), [1,1](nada)
        int errorRate = 1;
        int counter = 0;
        while (errorRate != 0) {

            inferedAnswer = infer(question);

            errorRate = rightAnswer - inferedAnswer; //verificando se a IA acertou;
//            if (counter > 5) {
//            if (question[0].length == 3){
//                System.out.println("Inferencia");
//                System.out.println(inferedAnswer);
//                System.out.println("resposta");
//                System.out.println(rightAnswer);
//                System.out.println("taxa de erro do perceptron");
//                System.out.println(errorRate);
//                System.out.println("Pesos dos perceptrons");
//                printArray(weights);
//                System.out.println(question.length);
//                wait(3000);
//            }
                for (int i = 0; i < question.length; i++) {
                    for (int j = 0; j < question[0].length; j++) {
                        weights[i*j] = weights[i*j] + (learningRate * errorRate * question[i][j]);
                    }
                }
            ++counter;
        }
        //System.out.println("\nSe ajustou com "+ counter + " tentativas\n");
    }

    public int infer(int [] [] question){
        double y = 0; // resultado cru da inferencia do perceptron
        int inferedAnswer = 0; // tipos de resposta vistas em aula [0,0](nada), [0,1](M), [1,0](H), [1,1](nada)

            for (int i = 0; i < question.length; i++) {
                for (int j = 0; j < question[0].length; j++) {
                    y += weights[i*j] * question[i][j];
//                    System.out.println(i + " " + j + " ");
                }
            }
        y += bias;

//        System.out.println("Resposta bruta da IA");
//        System.out.println(y);

       // System.out.println("Pesos dos perceptrons");
        //printArray(weights);
        if (y >= 0){
            inferedAnswer = 1;// Achou H
        }

        return inferedAnswer;
    }

    Perceptron(int i, int j){
        this.weights = new double[i*j];
        this.size = i*j;
    }

    Perceptron(int i, int j, double _learningRate){
        this.weights = new double[i*j];
        this.learningRate = _learningRate;
        this.size = i*j;
    }

    Perceptron(int i, int j, double _learningRate, double _bias){
        this.weights = new double[i*j];
        this.learningRate = _learningRate;
        this.bias = _bias;
        this.size = i*j;
    }

    Perceptron(int _size, double _learningRate){
        this.weights = new double[_size];
        this.learningRate = _learningRate;
        this.size = _size;
    }

    Perceptron(int _size, double _learningRate, double _bias){
        this.weights = new double[_size];
        this.learningRate = _learningRate;
        this.bias = _bias;
        this.size = _size;
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
