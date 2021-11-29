package src.Perceptrons;

import static src.Utils.printArray;
import static src.Utils.printMatrix;

public class Perceptron {
    //A percetron to recognize a 20x20 matrix scaled by any matrix with i = j
    // witch contains a rectagle with height one less the width

    double bias = -1;// Viez inicial

    int size;

    private double [] weights; //matriz com 2 perceptrons(2 arrays de 25)

    double learningRate = 1;//Taxa de Aprendizagem

    //constructors

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

    Perceptron(int _size){
        this.weights = new double[_size];
        this.size = _size;
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

    public void train(int [] [] question, int rightAnswer) {

        int inferedAnswer ; // tipos de resposta vistas em aula [0,0](nada), [0,1](M), [1,0](H), [1,1](nada)
        int errorRate = 1;
        int counter = 0;
        while (errorRate != 0) {

            inferedAnswer = infer(question);

            errorRate = rightAnswer - inferedAnswer; //verificando se a IA acertou;

            System.out.println("Inferencia");
            System.out.println(inferedAnswer+", "+inferedAnswer);
            System.out.println("resposta");
            System.out.println(rightAnswer+", "+rightAnswer);
            System.out.println("taxa de erro dos perceptrons");
            System.out.println(errorRate+", "+errorRate);

                for (int i = 0; i < question.length; i++) {
                    for (int j = 0; j < question[0].length; j++) {
                        weights[i*j] = weights[i*j] + (learningRate * errorRate * question[i][j]);
                    }
                }
            ++counter;
        }
        System.out.println("\nSe ajustou com "+ counter + " tentativas\n");
    }

    public int infer(int [] [] question){
        double y = 0; // resultado cru da inferencia do perceptron
        int inferedAnswer = 0; // tipos de resposta vistas em aula [0,0](nada), [0,1](M), [1,0](H), [1,1](nada)

            for (int i = 0; i < question.length; i++) {
                for (int j = 0; j < question[0].length; j++) {
                    y += weights[j*j] * question[i][j];
                }
            }
        y += bias;

        System.out.println("Resposta bruta da IA");
        System.out.println(y);

        System.out.println("Pesos dos perceptrons");
        printArray(weights);
        if (y >= 0){
            inferedAnswer = 1;// Achou H
        }

        return inferedAnswer;
    }
}