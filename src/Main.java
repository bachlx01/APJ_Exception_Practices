import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice = 0;

        while (choice != 9) {
            System.out.println("1. IllegalTriangle");
            System.out.println("2. IndexOutOfBoundsException");
            System.out.println("3. NumberFormatException");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1: //IllegalTriangle
                    illegalTriangle(input);
                    break;
                case 2: //IndexOutOfBoundsException
                    indexOutOfBounds();
                    break;
                case 3: //NumberFormatException
                    System.out.print("Hãy nhập x: ");
                    int x = input.nextInt();
                    System.out.print("Hãy nhập y: ");
                    int y = input.nextInt();
                    calculate(x, y);
                    break;
                case 9:
                    System.exit(0);
            }
        }

    }

    static public void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
        } catch (Exception e) {
            System.err.println("Xảy ra ngoại lệ: " + e.getMessage());
        }
    }

    private static void indexOutOfBounds() {
        Integer[] arr = createRandom();

        Scanner scaner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int x = scaner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số 5" + x + " là " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }

    private static void illegalTriangle(Scanner input) {
        System.out.println("Enter the size of triangle: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        try{
            boolean negativeNumber = a <=0 || b<= 0 || c <=0;
            boolean checkTriangle = (a + b <= c) || (a + c <= b) || (b + c <= a);
            if (checkTriangle || negativeNumber) {
                throw new IllegalArgumentException("Not triangle") ;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.printf("%-5d%-5d%-5d",a, b, c);
    }

    static public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
}
