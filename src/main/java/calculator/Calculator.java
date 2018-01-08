package calculator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Administrator on 2018/1/1 0001.
 */
public class Calculator {


    private  Stack<String> stack = new Stack<String>();
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<Integer> typelist = new ArrayList<>();       //用于判断数据类型,1代表数字，0代表操作符
    private Stack<Double>  calstack = new Stack<>();





    private static final HashMap<String,Integer> prioritymap = new HashMap<String, Integer>();


    static {

        prioritymap.put("+",2);
        prioritymap.put("-",2);
        prioritymap.put("*",1);
        prioritymap.put("/",1);
        prioritymap.put("%",1);
        prioritymap.put("^",0);
//        prioritymap.put(")",100);
        prioritymap.put("(",100);
        prioritymap.put("[",100);
//        prioritymap.put("]",100);


    }



    public void insert_list(String str,int type){


        list.add(str);
        typelist.add(type);


    }



    public void handle_str(String str){

        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%") || str.equals("^")){


            handle_opterator(str);

        }
        else if(str.equals("(") || str.equals(")") || str.equals("[") || str.equals("]") ){


            handle_brackets(str);


        }

        else {


            insert_list(str,1);

        }



    }



    public void handle_brackets(String str){

        if(str.equals("(") || str.equals("[")){

            stack.push(str);

        }

        else if(str.equals(")")){

            String pop = stack.pop();
            while(!pop.equals("(")){


                insert_list(pop,0);
                pop = stack.pop();



            }



        }

        else if(str.equals("]")){



            String pop = stack.pop();
            while(!pop.equals("[")){


                insert_list(pop,0);
                pop = stack.pop();



            }


        }



    }




    public void insert_stack(String str){

        stack.push(str);


    }


    public void handle_opterator(String str){


        if(stack.isEmpty()){

            stack.push(str);

        }

        else {


//            if(prioritymap.get(str) <= prioritymap.get(stack.peek())){
//
//                stack.push(str);
//
//            }
//
//            else {
//
//                insert_list(stack.pop(),0);
//                stack.push(str);
//
//
//            }


            while(prioritymap.get(str) > prioritymap.get(stack.peek())){

                insert_list(stack.pop(),0);
                if(!stack.isEmpty())
                    continue;


            }

            stack.push(str);




        }






    }


    public void show(){




        for(String s : list){

            System.out.print(s+" ");

        }


    }


    public void handle_last(){

        while(!stack.isEmpty()){

            insert_list(stack.pop(),0);


        }



    }





    private Double compute(Double x , Double y , String s){


        Double result = null;


        switch (s){


            case "+":
                result = x+y;
                break;

            case "-":
                result = y-x;
                break;

            case "*":
                result = x*y;
                break;


            case "/":
                result = y/x;
                break;

            case "%":
                result = y%x;
                break;

            case "^":
                result = 1d;
                while(x>0){
                    result = result*y;
                    x--;
                }
                break;

        }




        return  result;


    }






    public void operation(){

        int i = 0;

        for(String s : list){

            if(typelist.get(i).equals(1)){

                calstack.push(Double.parseDouble(s));


            }

            else if(typelist.get(i).equals(0)){


                Double x = calstack.pop();
                Double y = calstack.pop();

                Double result = compute(x,y,s);

                calstack.push(result);

            }



            i++;

        }




    }





    public void result(){


        System.out.println(calstack.peek());

    }





}
