package calculator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Calculator2 {

    private Stack<Double> result_stack = new Stack<Double>();
    private Stack<String> opterator_stack = new Stack<String>();
    private ArrayList<String> inputlist = new ArrayList<String>();
    private StringBuffer inputbuffer = new StringBuffer();
    private StringBuffer numberbuffer = new StringBuffer();
    private ArrayList<String> expression = new ArrayList<String>();
    private ArrayList<Integer> typelist = new ArrayList<Integer>();

    private int flag = 0;




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








    public boolean isZero(){


        if(numberbuffer.toString().equals("0"))
            return true;
        return false;


    }



    public void deletenumberbuffer(){


        numberbuffer.setLength(0);

    }



    public void deletelast(){



        inputbuffer.deleteCharAt(inputbuffer.length()-1);
        inputlist.remove(inputlist.size()-1);



    }


    public void addall(String number){


        numberbuffer.append(number);
        inputlist.add(number);
        inputbuffer.append(number);



    }




    public void show(JTextField field){


        field.setText(inputbuffer.toString());


    }







    public boolean isNoinput(){



        return inputlist.size()==0;



    }




    public boolean isLkuo(){


        return inputlist.get(inputlist.size()-1).equals("(");



    }


    public boolean isRkuo(){


        return inputlist.get(inputlist.size()-1).equals(")");


    }



    public boolean isNonumber(){


      return  numberbuffer.toString().equals("");


    }




    public void addExpression(int i){


        String str = numberbuffer.toString();

        insert_expression(str,i);
        numberbuffer.setLength(0);

        flag = 0;

    }



    public void insert_expression(String str,int i){


        expression.add(str);
        typelist.add(i);


    }




    public void addall2(String str){

        inputlist.add(str);
        inputbuffer.append(str);


    }



    public void handle_opterator(String opterator){



        if(opterator_stack.isEmpty()){

            opterator_stack.push(opterator);

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


            while(prioritymap.get(opterator) > prioritymap.get(opterator_stack.peek())){

                insert_expression(opterator_stack.pop(),0);
                if(!opterator_stack.isEmpty())
                    continue;
                else
                    break;


            }

            opterator_stack.push(opterator);




        }






    }





    public void handle_last(){

        while(!opterator_stack.isEmpty()){

            insert_expression(opterator_stack.pop(),0);


        }





    }





    public void operation(){

        int i = 0;

        for(String s : expression){

            if(typelist.get(i).equals(1)){

                result_stack.push(Double.parseDouble(s));


            }

            else if(typelist.get(i).equals(0)){


                Double x = result_stack.pop();
                Double y = result_stack.pop();

                Double result = compute(x,y,s);

                result_stack.push(result);

            }



            i++;

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




    public void clear(){



        Double result = result_stack.peek();

        inputbuffer.setLength(0);

        inputbuffer.append(result.toString());

        if(result.toString().indexOf(".") == -1)
            flag =0;
        else
            flag =1;


        inputlist.clear();
        String str = result.toString();
        for(int i=0; i < str.length();i++){

            char c = str.charAt(i);
            inputlist.add(String.valueOf(c));



        }


//        inputlist.add(result.toString());

        numberbuffer.append(result.toString());

        expression.clear();
        typelist.clear();

        result_stack.pop();







    }



    public void addlkuo(){


        opterator_stack.push("(");
        inputlist.add("(");
        inputbuffer.append("(");







    }



    public void handle_rkuo(){


        String pop = opterator_stack.pop();
        while(!pop.equals("(")){


            insert_expression(pop,0);
            pop = opterator_stack.pop();



        }





    }





    public void clearall(){


        opterator_stack.clear();
        result_stack.clear();
        inputlist.clear();
        expression.clear();
        typelist.clear();
        inputbuffer.setLength(0);
        numberbuffer.setLength(0);
        flag = 0;






    }




    public void handle_flag(int i){



        flag = i;



    }




    public void handle_dian(){



        if(flag == 0){


            addall(".");

            handle_flag(1);
            return;

        }

        else if(flag == 1){



            return;





        }






    }




    public boolean isOpterator(){



        String str = inputlist.get(inputlist.size()-1);


        return str.equals("+")|| str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%");



    }






    public boolean isJian(){



        return inputlist.get(inputlist.size()-1).equals("-");



    }



    public boolean isDian(){


        return inputlist.get(inputlist.size()-1).equals(".");


    }



    public void clear1(){



        numberbuffer.deleteCharAt(numberbuffer.length()-1);
        inputlist.remove(inputlist.size()-1);
        inputbuffer.deleteCharAt(inputbuffer.length()-1);





    }


    public void clear2(){


        opterator_stack.pop();
        inputlist.remove(inputlist.size()-1);
        inputbuffer.deleteCharAt(inputbuffer.length()-1);






    }


    public void clear3(){


        opterator_stack.pop();
        int length = expression.size()-1;

        while (equalsOpterator(expression.get(length))){


            opterator_stack.push(expression.get(length));
            expression.remove(length);
            typelist.remove(length);
            length--;


        }


        inputlist.remove(inputlist.size()-1);
        inputbuffer.deleteCharAt(inputbuffer.length()-1);




    }



    public void clear4(){


        inputbuffer.deleteCharAt(inputbuffer.length()-1);
        inputlist.remove(inputlist.size()-1);
        opterator_stack.push("(");
        int length = expression.size()-1;
        while (equalsOpterator(expression.get(length))){


            opterator_stack.push(expression.get(length));
            expression.remove(length);
            typelist.remove(length);
            length--;


        }


        String str = expression.get(expression.size()-1);
        numberbuffer.append(str);
        expression.remove(expression.size()-1);
        typelist.remove(typelist.size()-1);
        if(str.indexOf(".")!= -1)
            flag =1 ;
        else
            flag =0 ;




    }



    private boolean equalsOpterator(String str){


        return str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")||str.equals("%");


    }



    public boolean isNumberJian(){



        if( inputlist.size() == 1 || (inputlist.size() != 1 && inputlist.get(inputlist.size()-2).equals("(") ) )
            return true;
        else
            return false;




    }






    public boolean isOpreratorexpression(){


        String str = expression.get(expression.size()-1);

        if(str.equals("+") || str.equals("-")||str.equals("*") || str.equals("/") || str.equals("%"))
            return true;
        else
            return false;





    }





}
