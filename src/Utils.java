package src;


public class Utils {

    public static void printMatrix(int [] [] matrix){
        System.out.print("{\n");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("{");
            for (int j = 0; j < matrix[0].length; j++) {
                if (j != matrix[0].length-1){
                    System.out.print(matrix[i][j]+", ");
                }
                else{
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.print("},\n");
        }
        System.out.print("}\n");
    }

    public static void printReusableMatrix(int [] [] matrix){
        System.out.print("\n");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("");
            for (int j = 0; j < matrix[0].length; j++) {
                if (j != matrix[0].length-1){
                    System.out.print(matrix[i][j]+" ");
                }
                else{
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void printArray(int [] array){
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length-1){
                System.out.print(array[i]+", ");
            }
            else{
                System.out.print(array[i]);
            }
        }
        System.out.print("}\n");
    }

    public static void printArray(double [] array){
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length-1){
                System.out.print(array[i]+", ");
            }
            else{
                System.out.print(array[i]);
            }
        }
        System.out.print("}\n");
    }
}
