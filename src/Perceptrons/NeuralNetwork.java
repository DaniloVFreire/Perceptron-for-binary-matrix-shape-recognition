package src.Perceptrons;

import static src.Utils.printArray;
import static src.Utils.printMatrix;
import src.Perceptrons.Perceptron;
import java.util.ArrayList;


public class NeuralNetwork {
    //Neural network with perceptrons to recognize all the possible
    //rectangles with height + 1 = width, exsting in the 1x1 to 20x20 matrixes
    // 2 3, 3 4, 4 5, 5 6, 6 7, 7 8, 8 9, 9 10
    // 19 20, 18 perceptrons

    ArrayList<Perceptron> perceptrons = new ArrayList<>();

    public NeuralNetwork(){
        for (int i = 3; i <= 20; i++) {
            perceptrons.add(new Perceptron(i*i));
        }
    }

    public void train(int [] [] question, int rightAnswer) {
        if(question.length > 2){
            Perceptron perceptron = perceptrons.get((question.length-3));
            perceptron.train(question, rightAnswer);
        }
    }

    public int infer(int [] [] question){
        if(question.length > 2){
            Perceptron perceptron = perceptrons.get((question.length-3));
            return perceptron.infer(question);
        }
        else {
            return 0;
        }
    }
}
