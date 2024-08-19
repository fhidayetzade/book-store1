package springdata.bookstore1.services;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Massivin olcusunu teyin edin.");

        boolean valid = false;
        while (!valid){

            try {
                int arr[] = new int[sc.nextInt()];
                for (int i = 0; i < arr.length; i++) {

                    arr[i] = Integer.parseInt(sc.nextLine());
                }
                Arrays.sort(arr);
                System.out.println("Artan sira");
                System.out.println(Arrays.toString(arr));
                valid = true;
            }
            catch (InputMismatchException type_error) {
                System.out.println("Simvol ve herf daxil etmek olmaz!");
                break;
            }
        }

    }
}
