package src.main;

import src.Perceptrons.NeuralNetwork;

import java.io.*;

import static src.Utils.printArray;
import static src.Utils.printMatrix;

public class Main {

    public static void main(String[] args) throws IOException {
        //ler casos de treino (arquivo)
        //Treinar modelo (chamar função de treino)
        //ler arquivo de teste
        NeuralNetwork nn = new NeuralNetwork();
        readAndTrain(nn);
        //printar resultado
        //formato x y e x*y de 1's ou 0's e a resposta
        //4 4  size i j
        //0 0 0 0
        //1 1 1 1
        //1 1 1 1
        //1 1 1 1
        //1 answer
    }
    public static void readAndTrain(NeuralNetwork nn) throws IOException {
        File file = new File("C:\\Users\\danil\\Documents\\projetos github\\Perceptron-for-binary-matrix-shape-recognition\\src\\main\\treino.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int counter, value;
        while ((st = br.readLine()) != null){
            System.out.println(st);
            if(st.length()>0){
                if(st.length()==3 && st.charAt(1) == ' '){
                    counter =(int) st.charAt(0);
                    counter -= 48;
                    System.out.println(counter);
                    value =0;
                    int [] []matrix = new int[counter][counter];
                }
                else if(st.length()==5 && st.charAt(2) == ' '){
                    counter = ((int) st.charAt(0)-48)*10 +((int)st.charAt(1)-48);
                    System.out.println(counter);
                    value = 0;
                    int [] []matrix = new int[counter][counter];
                }
                else{
                    printArray(st.split(""));
                    value++;
                }
            }
            else{

            }
        }
    }
}
