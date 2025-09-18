/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author wan wai hoe
 */
public class Assignment1{
    
    static JFrame frameStart, frameMenu, framePrtMode, framePrtDiff, frameScrMode, frameScrDiff, frameLstScr, frameAnsMode;
    static JButton btnStart, btnExit, btnMenuExit, btnScrMode, btnPrtMode, btnAnsMode, btnPrtSudmit, btnPrtExit, btnPrtEz, btnPrtMed, btnPrtHrd,btnScrEz, btnScrMed, btnScrHrd, btnScrSudmit, btnScrExit, btnScrLstExit, btnAnsSudmit, btnAnsExit;
    static ImageIcon imgWelcome, imgAns;
    static JRadioButton plus, minus, multiply, divide;
    static JLabel lblWelcome, lblQuestionPrt, lblQuestionScr, lblScore, lblImgAns, lblAkinator, num1, num2, Answer;
    static JPanel pnlWelcome, pnlPrtQuestion, pnlPrtButtom, pnlScrQuestion, pnlScrButtom, pnlAnsbtm, pnlAnsMiddle, pnlAnsTop, pnlAnsLeft, pnlRdbBtn;
    static JTextField answerPrt, answerScr, inputAns1, inputAns2, inputAnswer;
    static JList lstScr;
    static ButtonGroup rdbGroup;
    static int random, ans, number1, number2,diff, i, score, choose;
    static ArrayList<String>Score = new ArrayList<String>();
    
    public static void main(String[] args) {
        //setValue
        i = 0;
        score = 0;
        choose = 1;
        
        //frame
        frameStart = new JFrame("Welcome !");
        frameStart.setSize(500, 350);
        frameStart.setLayout(new BorderLayout());
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setLocationRelativeTo(null);
        
        frameMenu = new JFrame("Math Game");
        frameMenu.setSize(500, 350);
        frameMenu.setLayout(new GridLayout(4,1));
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setLocationRelativeTo(null);
        
        framePrtMode = new JFrame("Practice Mode");
        framePrtMode.setSize(400, 280);
        framePrtMode.setLayout(new BorderLayout());
        framePrtMode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrtMode.setLocationRelativeTo(null);
        
        framePrtDiff = new JFrame("Choose Difficult");
        framePrtDiff.setSize(500, 350);
        framePrtDiff.setLayout(new GridLayout(3,1));
        framePrtDiff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrtDiff.setLocationRelativeTo(null);
        
        frameScrMode = new JFrame("Scoring Mode");
        frameScrMode.setSize(400, 280);
        frameScrMode.setLayout(new BorderLayout());
        frameScrMode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameScrMode.setLocationRelativeTo(null);
        
        frameScrDiff = new JFrame("Choose Difficult");
        frameScrDiff.setSize(500, 350);
        frameScrDiff.setLayout(new GridLayout(3,1));
        frameScrDiff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameScrDiff.setLocationRelativeTo(null);
        
        frameLstScr = new JFrame("Your Result");
        frameLstScr.setSize(500, 350);
        frameLstScr.setLayout(new BorderLayout());
        frameLstScr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLstScr.setLocationRelativeTo(null);
        
        frameAnsMode = new JFrame("Answer Mode");
        frameAnsMode.setSize(500, 350);
        frameAnsMode.setLayout(new BorderLayout());
        frameAnsMode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAnsMode.setLocationRelativeTo(null);
        
        //panel
        pnlWelcome = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlPrtQuestion = new JPanel (new GridLayout(2,1));               
        pnlPrtButtom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlScrQuestion = new JPanel (new GridLayout(2,1));               
        pnlScrButtom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlAnsbtm = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlAnsTop = new JPanel(new GridLayout(1,2));
        pnlAnsMiddle = new JPanel(new GridLayout(4,2));
        pnlAnsLeft = new JPanel(new GridLayout(4,1));
        pnlRdbBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        //TextField
        answerPrt = new JTextField(20);
        answerScr = new JTextField(20);
        inputAns1 = new JTextField(20);
        inputAns2 = new JTextField(20);
        inputAnswer = new JTextField(20);
        
        //image
        imgWelcome = new ImageIcon("Image/welcom.jpg");
        imgAns = new ImageIcon("Image/akinator.png");
        
        //label
        lblWelcome = new JLabel(imgWelcome);
        lblQuestionPrt = new JLabel();
        lblQuestionScr = new JLabel();
        lblScore = new JLabel("You Dont have any score");
        lblImgAns = new JLabel(imgAns);
        lblAkinator = new JLabel ("HI, give me a question i will answer it");
        num1 = new JLabel ("First Number: ");
        num2 = new JLabel ("Second Number: ");
        Answer = new JLabel("Answer: ");
        
        //List
        lstScr = new JList();
        
        //button
        btnStart = new JButton ("Start Game");
        btnStart.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               frameMenu.setVisible(true);
               frameStart.setVisible(false);
           }
        });       
        btnExit = new JButton ("Exit");
        btnExit.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        //Practice Mode
        btnPrtMode = new JButton("Practice Mode");
        btnPrtMode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                framePrtDiff.setVisible(true);
                frameMenu.setVisible(false);
            }
        });        
        
        btnPrtEz = new JButton("Easy");
        btnPrtEz.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                random = getRandomNumber(1,2);
                diff=1;
                if(random == 1){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 + number2;
                    lblQuestionPrt.setText(number1+" + "+number2);
                }else{
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 - number2;
                    lblQuestionPrt.setText(number1+" - "+number2);
                }
                framePrtDiff.setVisible(false);
                framePrtMode.setVisible(true);
            }
        });
        btnPrtMed = new JButton("Medium");
        btnPrtMed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                random = getRandomNumber(1,3);
                diff=2;
                if(random == 1){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 + number2;
                    lblQuestionPrt.setText(number1+" + "+number2);
                }else if(random ==2){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 - number2;
                    lblQuestionPrt.setText(number1+" - "+number2);
                }else{
                    number1 = getRandomNumber(1,12);
                    number2 = getRandomNumber(1,12);
                    ans = number1 * number2;
                    lblQuestionPrt.setText(number1+" x "+number2);
                }
                framePrtDiff.setVisible(false);
                framePrtMode.setVisible(true);
            }
        });      
        btnPrtHrd = new JButton("Hard");
        btnPrtHrd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                random = getRandomNumber(1,4);
                diff=3;
                if(random == 1){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 + number2;
                    lblQuestionPrt.setText(number1+" + "+number2);
                }else if(random ==2){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 - number2;
                    lblQuestionPrt.setText(number1+" - "+number2);
                }else if(random==3){
                    number1 = getRandomNumber(1,12);
                    number2 = getRandomNumber(1,12);
                    ans = number1 * number2;
                    lblQuestionPrt.setText(number1+" x "+number2);
                }else{
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,10);
                    ans = number1 / number2;
                    lblQuestionPrt.setText(number1+" / "+number2);
                }
                
                framePrtDiff.setVisible(false);
                framePrtMode.setVisible(true);
            }
        });
        
        btnPrtSudmit = new JButton ("Sudmit");
        btnPrtSudmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(Integer.parseInt(answerPrt.getText())==ans){
                    JOptionPane.showMessageDialog(null, "Well Done! You answer was Correct it is "+answerPrt.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "oh no, You answer was wrong the correct answer is "+ans+" batter luck next time!");
                }
                answerPrt.setText("");
                if(diff==1){
                    btnPrtEz.doClick();
                }else if(diff==2){
                    btnPrtMed.doClick();
                }else if(diff==3){
                    btnPrtHrd.doClick();
                }        
            }
        });
        btnPrtExit = new JButton ("Exit");
        btnPrtExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                framePrtMode.setVisible(false);
                framePrtDiff.setVisible(false);
                frameMenu.setVisible(true);
            }
        });
        
        //Scoring Mode
        btnScrMode = new JButton("Scoring Mode");
        btnScrMode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frameScrDiff.setVisible(true);
                frameMenu.setVisible(false);
            }
        }); 
        
        btnScrEz = new JButton("Easy");
        btnScrEz.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                random = getRandomNumber(1,2);
                diff=1;
                
                if(random == 1){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 + number2;
                    lblQuestionScr.setText(number1+" + "+number2);
                }else{
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 - number2;
                    lblQuestionScr.setText(number1+" - "+number2);
                }
                
                frameScrDiff.setVisible(false);
                frameScrMode.setVisible(true);
            }
        });
        btnScrMed = new JButton("Medium");
        btnScrMed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                random = getRandomNumber(1,3);
                diff=2;
                
                if(random == 1){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 + number2;
                    lblQuestionScr.setText(number1+" + "+number2);
                }else if(random ==2){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 - number2;
                    lblQuestionScr.setText(number1+" - "+number2);
                }else{
                    number1 = getRandomNumber(1,12);
                    number2 = getRandomNumber(1,12);
                    ans = number1 * number2;
                    lblQuestionScr.setText(number1+" x "+number2);
                }
                frameScrDiff.setVisible(false);
                frameScrMode.setVisible(true);
            }
        });
        btnScrHrd = new JButton("Hard");
        btnScrHrd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                random = getRandomNumber(1,4);
                diff=3;

                if(random == 1){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 + number2;
                    lblQuestionScr.setText(number1+" + "+number2);
                }else if(random ==2){
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,100);
                    ans = number1 - number2;
                    lblQuestionScr.setText(number1+" - "+number2);
                }else if(random==3){
                    number1 = getRandomNumber(1,12);
                    number2 = getRandomNumber(1,12);
                    ans = number1 * number2;
                    lblQuestionScr.setText(number1+" x "+number2);
                }else{
                    number1 = getRandomNumber(1,100);
                    number2 = getRandomNumber(1,10);
                    ans = number1 / number2;
                    lblQuestionScr.setText(number1+" / "+number2);
                }
                
                frameScrDiff.setVisible(false);
                frameScrMode.setVisible(true);
            }
        });
        
        btnScrSudmit = new JButton ("Sudmit");
        btnScrSudmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(i >= 9){
                    frameScrMode.setVisible(false);
                    frameLstScr.setVisible(true);
                }
                
                if(Integer.parseInt(answerScr.getText())==ans){
                    score+=1;
                    lblScore.setText("Your Score is ="+score);
                    Score.add("Question "+(i+1)+" Correct, Your Answer Was "+answerScr.getText());
                    lstScr.setListData(Score.toArray());
                }else{
                    Score.add("Question "+(i+1)+" Wrong, Your Answer Was "+answerScr.getText()+" The Correct Answer is "+ans);
                    lstScr.setListData(Score.toArray());
                }
 
                i++;
                
                answerScr.setText("");
                
                if(diff==1 && i <= 9){
                    btnScrEz.doClick();
                }else if(diff==2 && i <= 9){
                    btnScrMed.doClick();                   
                }else if(diff==3 && i <= 9){
                    btnScrHrd.doClick();        
                }
            }
        });
        btnScrExit = new JButton ("Exit");
        btnScrExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                i = 0;
                Score.removeAll(Score);
                frameScrMode.setVisible(false);
                frameScrDiff.setVisible(false);
                frameMenu.setVisible(true);
            }
        });        
        btnScrLstExit = new JButton("Exit");
        btnScrLstExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                i = 0;
                lblScore.setText("You Dont have any score");
                Score.removeAll(Score);
                frameLstScr.setVisible(false);
                frameMenu.setVisible(true);
            }
        });
        
        //Answer Mode
        btnAnsMode = new JButton("Answer Mode");
        btnAnsMode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frameAnsMode.setVisible(true);
                frameMenu.setVisible(false);
            }
        });
        
        plus = new JRadioButton("+");
        minus = new JRadioButton("-");
        multiply = new JRadioButton("x");
        divide = new JRadioButton("/");
        
        rdbGroup = new ButtonGroup();
        rdbGroup.add(plus);
        rdbGroup.add(minus);
        rdbGroup.add(multiply);
        rdbGroup.add(divide);
        
        btnAnsSudmit = new JButton("Sudmit");
        btnAnsSudmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(plus.isSelected()==true){
                    int number1 = Integer.parseInt(inputAns1.getText());
                    int number2 = Integer.parseInt(inputAns2.getText());
                    ans = number1 + number2;
                }else if(minus.isSelected() == true){
                    int number1 = Integer.parseInt(inputAns1.getText());
                    int number2 = Integer.parseInt(inputAns2.getText());
                    ans = number1 - number2;
                }else if(multiply.isSelected() == true){
                    int number1 = Integer.parseInt(inputAns1.getText());
                    int number2 = Integer.parseInt(inputAns2.getText());
                    ans = number1 * number2;
                }else if(divide.isSelected()==true){
                    int number1 = Integer.parseInt(inputAns1.getText());
                    int number2 = Integer.parseInt(inputAns2.getText());
                    ans = number1 / number2;
                }
                JOptionPane.showMessageDialog(null, "Hmmm... I think the answer is "+ans+" And the answer you give are "+inputAnswer.getText());
                inputAns1.setText("");
                inputAns2.setText("");
                inputAnswer.setText("");
            }
        });
        
        btnAnsExit = new JButton("Exit");
        btnAnsExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frameAnsMode.setVisible(false);
                frameMenu.setVisible(true);
            }
        });
        
        
        //Menu
        btnMenuExit = new JButton("Exit");
        btnMenuExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        //add
        pnlWelcome.add(btnStart);
        pnlWelcome.add(btnExit);
        
        pnlPrtQuestion.add(lblQuestionPrt);
        pnlPrtQuestion.add(answerPrt);
        pnlPrtButtom.add(btnPrtSudmit);
        pnlPrtButtom.add(btnPrtExit);
        
        pnlScrQuestion.add(lblQuestionScr);
        pnlScrQuestion.add(answerScr);
        pnlScrButtom.add(btnScrSudmit);
        pnlScrButtom.add(btnScrExit);
        
        pnlAnsTop.add(lblImgAns);
        pnlAnsTop.add(lblAkinator);
        pnlAnsMiddle.add(num1);
        pnlAnsMiddle.add(inputAns1);
        pnlAnsMiddle.add(num2);
        pnlAnsMiddle.add(inputAns2);
        pnlAnsMiddle.add(Answer);
        pnlAnsMiddle.add(inputAnswer);
        pnlAnsMiddle.add(pnlRdbBtn);
        pnlRdbBtn.add(plus);
        pnlRdbBtn.add(minus);
        pnlRdbBtn.add(multiply);
        pnlRdbBtn.add(divide);
        
        framePrtMode.add(pnlPrtQuestion, BorderLayout.CENTER);
        framePrtMode.add(pnlPrtButtom,BorderLayout.SOUTH);
        framePrtDiff.add(btnPrtEz);
        framePrtDiff.add(btnPrtMed);
        framePrtDiff.add(btnPrtHrd);
        
        frameScrMode.add(pnlScrQuestion, BorderLayout.CENTER);
        frameScrMode.add(pnlScrButtom,BorderLayout.SOUTH);
        frameScrDiff.add(btnScrEz);
        frameScrDiff.add(btnScrMed);
        frameScrDiff.add(btnScrHrd);
        frameLstScr.add(lstScr, BorderLayout.CENTER);
        frameLstScr.add(btnScrLstExit, BorderLayout.SOUTH);
        frameLstScr.add(lblScore, BorderLayout.WEST);
        
        frameAnsMode.add(pnlAnsTop, BorderLayout.NORTH);
        frameAnsMode.add(pnlAnsMiddle, BorderLayout.CENTER);
        frameAnsMode.add(pnlAnsbtm, BorderLayout.SOUTH);
        
        pnlAnsbtm.add(btnAnsSudmit);
        pnlAnsbtm.add(btnAnsExit);
        
        frameMenu.add(btnPrtMode);
        frameMenu.add(btnScrMode);
        frameMenu.add(btnAnsMode);
        frameMenu.add(btnMenuExit);
       
        frameStart.add(lblWelcome, BorderLayout.CENTER);
        frameStart.add(pnlWelcome,BorderLayout.SOUTH);
        
        frameStart.setVisible(true);
    }
    
        public static int getRandomNumber(int min, int max){
        int rand = (int)(Math.random()*(max - min+1))+min;
        return rand;
    }  
}
