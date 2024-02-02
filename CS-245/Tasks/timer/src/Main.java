import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Seconds:");
        int seconds = scan.nextInt();
        System.out.println("Input Minutes:");
        int minutes = scan.nextInt();
        System.out.println("Input Hours:");
        int hours = scan.nextInt();
        Timerclass timer = new Timerclass(seconds,minutes,hours);
    }
}