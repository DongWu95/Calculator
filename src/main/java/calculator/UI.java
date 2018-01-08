package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Administrator on 2018/1/6 0006.
 */
public class UI {



//    private  int i =1;

    JFrame frame = new JFrame("Calculator");
    JTextField result_TextField = new JTextField("", 25);
    JButton button_clear = new JButton("C");
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button_Dian = new JButton(".");
    JButton button_jia = new JButton("+");
    JButton button_jian = new JButton("-");
    JButton button_cheng = new JButton("*");
    JButton button_chu = new JButton("/");
    JButton button_yu = new JButton("%");
    JButton button_dy = new JButton("=");
    JButton button_lkuo = new JButton("(");
    JButton button_rkuo = new JButton(")");
    JButton button_back = new JButton("Del");
    Listener_Number listener_number =new Listener_Number();
    Listener_Opterator listener_opterator = new Listener_Opterator();
    Listener_Lkuo   listener_lkuo = new Listener_Lkuo();
    Listener_Rkuo   listener_rkuo = new Listener_Rkuo();
    Listener_Equals listener_equals = new Listener_Equals();
    Listener_Dian   listener_dian = new Listener_Dian();
    Listener_Clear  listener_clear = new Listener_Clear();
    Listener_Back   listener_back  = new Listener_Back();
    Calculator2 calculator= new Calculator2();















    public UI() {


        result_TextField.setHorizontalAlignment(JTextField.RIGHT);

        // 将UI组件添加进容器内
        JPanel pan = new JPanel();


        System.out.println(button0.getText());

        pan.setLayout(new GridLayout(5, 4, 5, 5));
        pan.add(button_lkuo);
        pan.add(button_rkuo);
        pan.add(button_yu);
        pan.add(button_clear);
        pan.add(button7);
        pan.add(button8);
        pan.add(button9);
        pan.add(button_chu);
        pan.add(button4);
        pan.add(button5);
        pan.add(button6);
        pan.add(button_cheng);
        pan.add(button1);
        pan.add(button2);
        pan.add(button3);
        pan.add(button_jian);
        pan.add(button0);
        pan.add(button_Dian);
        pan.add(button_dy);
        pan.add(button_jia);
        pan.add(button_back);
        pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(result_TextField, BorderLayout.WEST);
        pan2.add(button_back,BorderLayout.EAST);





        button0.addActionListener(listener_number);
        button1.addActionListener(listener_number);
        button2.addActionListener(listener_number);
        button3.addActionListener(listener_number);
        button4.addActionListener(listener_number);
        button5.addActionListener(listener_number);
        button6.addActionListener(listener_number);
        button7.addActionListener(listener_number);
        button8.addActionListener(listener_number);
        button9.addActionListener(listener_number);
        button_cheng.addActionListener(listener_opterator);
        button_chu.addActionListener(listener_opterator);
        button_jia.addActionListener(listener_opterator);
        button_jian.addActionListener(listener_opterator);
        button_yu.addActionListener(listener_opterator);
        button_lkuo.addActionListener(listener_lkuo);
        button_rkuo.addActionListener(listener_rkuo);
        button_dy.addActionListener(listener_equals);
        button_Dian.addActionListener(listener_dian);
        button_clear.addActionListener(listener_clear);
        button_back.addActionListener(listener_back);





        frame.setLocation(300, 200);
        // 设置窗体不能调大小
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pan2, BorderLayout.NORTH);
        frame.getContentPane().add(pan, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });






    }











    public static void main(String[] args){



        UI ui = new UI();













    }









    class Listener_Number implements ActionListener {
        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {


            String number = ((JButton)e.getSource()).getText();





            if(calculator.isZero()){


                calculator.deletenumberbuffer();
                calculator.deletelast();


            }



            calculator.addall(number);

            calculator.show(result_TextField);
//                System.out.println(i++);

        }
    }



    class Listener_Opterator implements ActionListener{


        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {


            String opterator = ((JButton)e.getSource()).getText();



            if(e.getSource() == button_jian){

                if(calculator.isNoinput()){


                    calculator.addall(opterator);
                    calculator.show(result_TextField);
                    return;

                }
                else {


                    if(calculator.isLkuo()){

                        calculator.addall(opterator);

                        calculator.show(result_TextField);

                        return;

                    }

                    else {


                            if(!calculator.isNonumber()){


                                calculator.addExpression(1);






                            }



                            calculator.addall2(opterator);


                            calculator.handle_opterator(opterator);


                            calculator.show(result_TextField);

                            return;

                    }



                }



            }

            else{


                if(calculator.isNoinput()){


                    calculator.show(result_TextField);
                    return;

                }

                else {


                    if(!calculator.isNonumber()){


                        calculator.addExpression(1);



                    }


                    calculator.addall2(opterator);
                    calculator.handle_opterator(opterator);
                    calculator.show(result_TextField);

                    return;


                }












            }








//                System.out.println(i++);

        }




    }




    class Listener_Lkuo implements ActionListener{


        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {

            calculator.addlkuo();
            calculator.show(result_TextField);



//                System.out.println(i++);

        }




    }





    class Listener_Rkuo implements ActionListener{


        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {


                if(!calculator.isNonumber()){


                    calculator.addExpression(1);


                }

                calculator.handle_rkuo();

                calculator.addall2(")");

                calculator.show(result_TextField);
//                System.out.println(i++);

        }




    }


    class Listener_Equals implements ActionListener{


        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {

            if(!calculator.isNonumber()){

                calculator.addExpression(1);

            }


            calculator.handle_last();

            calculator.operation();

            calculator.clear();

            calculator.show(result_TextField);


//                System.out.println(i++);

        }




    }


    class Listener_Dian implements ActionListener{


        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {


            if(calculator.isNoinput()){


                calculator.addall("0.");
                calculator.handle_flag(1);
                calculator.show(result_TextField);
                return;

            }

            else {


                calculator.handle_dian();

                calculator.show(result_TextField);





            }


//                System.out.println(i++);

        }




    }







    class Listener_Clear implements ActionListener{


        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {

            calculator.clearall();
            calculator.show(result_TextField);


//                System.out.println(i++);

        }




    }






    class Listener_Back implements ActionListener{


        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {






            if(calculator.isNoinput()){

                calculator.show(result_TextField);
                return;

            }
            else {



                if(calculator.isOpterator()){


                    if(calculator.isJian()){


                        if(calculator.isNumberJian()){


                            calculator.clear1();
                            calculator.show(result_TextField);
                            return;



                        }

                        else {


                            if(!calculator.isOpreratorexpression()){


                                calculator.clear2();
                                calculator.show(result_TextField);

                                return;






                            }
                            else {




                                calculator.clear3();
                                calculator.show(result_TextField);
                                return;




                            }





                        }









                    }


                    else {


                            if(!calculator.isOpreratorexpression()){


                                calculator.clear2();
                                calculator.show(result_TextField);

                                return;

                            }

                            else {



                                calculator.clear3();
                                calculator.show(result_TextField);
                                return;




                            }




                    }




                }

                else if(calculator.isLkuo()){


                    calculator.clear2();
                    calculator.show(result_TextField);
                    return;



                }


                else if(calculator.isRkuo()){



                    calculator.clear4();
                    calculator.show(result_TextField);
                    return;




                }


                else {


                    if(calculator.isDian()){


                        calculator.handle_flag(0);



                    }


                    calculator.clear1();

                    calculator.show(result_TextField);

                    return;




                }







            }






        }




    }








}
