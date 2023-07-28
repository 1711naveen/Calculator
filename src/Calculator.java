import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    JButton jButton0, jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9;
    JButton jButton_add, jButton_sub, jButton_div, jButton_mul, jButton_eq, jButton_clear, jButton_dot;
    JPanel jPanel, jPanel1, jPanel2;
    JTextField jTextField, answer;
    String s_operand1, s_operand2, s_operator;

    public MyFrame() {
        super("Calculator Project");

        s_operand1 = "";
        s_operand2 = "";
        s_operator = "";

        jButton0 = new JButton("0");
        jButton1 = new JButton("1");
        jButton2 = new JButton("2");
        jButton3 = new JButton("3");
        jButton4 = new JButton("4");
        jButton5 = new JButton("5");
        jButton6 = new JButton("6");
        jButton7 = new JButton("7");
        jButton8 = new JButton("8");
        jButton9 = new JButton("9");

        jButton_add = new JButton("+");
        jButton_sub = new JButton("-");
        jButton_mul = new JButton("*");
        jButton_div = new JButton("/");

        jButton_eq = new JButton("=");
        jButton_dot = new JButton(".");
        jButton_clear = new JButton("Clear console");

        jTextField = new JTextField("--------------------------------", 20);
        jTextField.setEditable(false);
        answer = new JTextField("Answer will be here", 20);
        answer.setEditable(false);

        jPanel1 = new JPanel(new GridLayout(2, 1, 5, 5));
        jPanel1.add(jTextField);
        jPanel1.add(answer);

        jPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jPanel2.add(jButton_clear);


        jPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        jPanel.add(jButton7);
        jPanel.add(jButton8);
        jPanel.add(jButton9);
        jPanel.add(jButton_mul);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
        jPanel.add(jButton6);
        jPanel.add(jButton_sub);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton_add);
        jPanel.add(jButton_dot);
        jPanel.add(jButton0);
        jPanel.add(jButton_div);
        jPanel.add(jButton_eq);
        jPanel.setBackground(Color.BLUE);

        jButton0.addActionListener(this);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        jButton6.addActionListener(this);
        jButton7.addActionListener(this);
        jButton8.addActionListener(this);
        jButton9.addActionListener(this);
        jButton_add.addActionListener(this);
        jButton_sub.addActionListener(this);
        jButton_dot.addActionListener(this);
        jButton_mul.addActionListener(this);
        jButton_div.addActionListener(this);
        jButton_eq.addActionListener(this);
        jButton_clear.addActionListener(this);

        setLayout(new GridLayout(3, 1, 10, 10));
        add(jPanel1);
        add(jPanel2);
        add(jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if ((action.charAt(0) >= '0' && action.charAt(0) <= '9') || action.charAt(0) == '.') {
            if (s_operator.equals("")) {
                s_operand1 = s_operand1 + action;
            } else {
                s_operand2 = s_operand2 + action;
            }
            jTextField.setText(s_operand1 + s_operator + s_operand2);
        }

        else if (action.equals(jButton_clear.getText())) {
            s_operand1 = s_operator = s_operand2 = "";
            jTextField.setText("");
            answer.setText("Answer will be here");
        }

        else if (action.charAt(0) == '=') {
            double ans;

            if (s_operator.equals("+"))
                ans = (Double.parseDouble(s_operand1) + Double.parseDouble(s_operand2));
            else if (s_operator.equals("-"))
                ans = (Double.parseDouble(s_operand1) - Double.parseDouble(s_operand2));
            else if (s_operator.equals("/"))
                ans = (Double.parseDouble(s_operand1) / Double.parseDouble(s_operand2));
            else
                ans = (Double.parseDouble(s_operand1) * Double.parseDouble(s_operand2));

            jTextField.setText(s_operand1 + s_operator + s_operand2);
            answer.setText(ans + "");

            s_operand1 = Double.toString(ans);
            s_operator = s_operand2 = "";
        }

        else {
            if (s_operator.equals("") || s_operand2.equals(""))
                s_operator = action;

            else {
                double ans;

                if (s_operator.equals("+"))
                    ans = (Double.parseDouble(s_operand1) + Double.parseDouble(s_operand2));
                else if (s_operator.equals("-"))
                    ans = (Double.parseDouble(s_operand1) - Double.parseDouble(s_operand2));
                else if (s_operator.equals("/"))
                    ans = (Double.parseDouble(s_operand1) / Double.parseDouble(s_operand2));
                else
                    ans = (Double.parseDouble(s_operand1) * Double.parseDouble(s_operand2));

                s_operand1 = Double.toString(ans);

                s_operator = action;

                s_operand2 = "";
            }
            jTextField.setText(s_operand1 + s_operator + s_operand2);
        }
    }
}

public class Calculator {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setSize(400, 400);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


