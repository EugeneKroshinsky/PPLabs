import java.io.*;
import java.text.*;
class Main {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int k = 0;
        double x = 0;
        try{
            System.out.println("Enter k:");
            k = Integer.parseInt(br.readLine());
            System.out.println("Enter x:");
            x = Double.parseDouble(br.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Не целое число");
            System.exit(1);
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
            System.exit(1);
        }

        if (x > 1 || x < -1){
            System.out.println("x не удовлетворяет промежутку (-1, 1)");
            System.exit(1);
        }

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k + 1);

        double systemResult = 1f / Math.sqrt(1+x);
        System.out.println("System result:");
        System.out.println(formatter.format(systemResult));

        double myResult = Calculate(k, x);
        System.out.println("My result:");
        System.out.println(formatter.format(myResult));
    }
    public static double Calculate(int k, double x) {
        double epsilon = Math.pow(10, -k);
        double element = 1, result = 1, count = 1;
        while(Math.abs(element) > epsilon)
        {
            element = (element * count * x * -1) / (count + 1);
            result += element;
            count+=2;
        }
        return result;
    }

}