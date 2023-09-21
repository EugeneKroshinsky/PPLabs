//Крошинский Евгений Задания 5 19 33
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        Scanner in1 = new Scanner(new File("input1.txt"));
        Scanner in2 = new Scanner(new File("input2.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        int[][] arr1 = readArray(in1);
        System.out.println("Matrix 1:");
        writeArrayConsole(arr1);
        System.out.println();
        System.out.println("Task 1");
        Task1(arr1);

        int[][] arr2 = readArray(in2);
        System.out.println("Task 2");
        System.out.println("Matrix 2:");
        writeArrayConsole(arr2);
        Task2(arr2);

        System.out.println("Matrix 3:");
        writeArrayConsole(arr1);
        System.out.println("Task 3");
        Task3(arr1);
        out.flush();
    }

    public static void Task1(int[][] arr) {
        //Scanner inConsole = new Scanner(System.in);
        //System.out.println("Enter n for task 1:");
        //int k = inConsole.nextInt();
        int min = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < arr[0].length; i++) {
            int current = 1;
            for (int j = 0; j < arr.length; j++) {
                current *= arr[j][i];
            }
            if (current < min) {
                min = current;
                result = i;
            }
        }
        System.out.println("Column: " + (result  + 1) + ", Multiply: " + min);
        System.out.println();
    }

    public static void Task2(int[][] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++){
            int[] numbers = new int[20];
            flag = true;
            for (int j = 0; j < arr[0].length; j++){
                if(arr[i][j] < 21 && arr[i][j] > 0){
                    numbers[arr[i][j] - 1] = 1;
                }
                else{
                    System.out.println("Row: " + i  + " No");
                    flag = false;
                    break;
                }
            }
            if (flag){
                if (Arrays.binarySearch(numbers, 0) < 0) {
                    System.out.println("Row: " + i  + " Yes");
                }
                else{
                    System.out.println("Row: " + i  + " No");
                }
            }
        }

        System.out.println();
    }
    public static void Task3(int[][] arr){

        int[] minElements = new int[arr[0].length];
        for (int i = 0; i < arr[0].length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] < min) {
                    min = arr[j][i];
                }
            }
            minElements[i] = min;
        }

        int n = minElements.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (minElements[j] > minElements[j + 1]) {
                    int temp = minElements[j];
                    minElements[j] = minElements[j + 1];
                    minElements[j + 1] = temp;
                    swapped = true;
                    for (int k = 0; k < arr.length; k++){
                        int buf = arr[k][j];
                        arr[k][j] = arr[k][j+1];
                        arr[k][j+1] = buf;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
        writeArrayConsole(arr);
    }
    public static int[][] readArray(Scanner in){
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr[i][j] = in.nextInt();
            }
        }
        return arr;
    }
    public static void writeArrayFile(int[][] arr, PrintWriter out){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                out.print(arr[i][j] + " ");
            }
            out.println();
        }
        out.println();
    }
    public static void writeArrayConsole(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}