package calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2018/1/1 0001.
 */
public class Main {






    public static void main(String[] args){


        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String  str  = null;
        str = scanner.nextLine();
        while( !str.equals("=") ) {


            calculator.handle_str(str);


            calculator.show();

            str = scanner.nextLine();

        }

        calculator.handle_last();



        System.out.println("last:");

        calculator.show();



        calculator.operation();



        calculator.result();



//        String str=scanner.nextLine();

//        System.out.println(str);






    }








}
