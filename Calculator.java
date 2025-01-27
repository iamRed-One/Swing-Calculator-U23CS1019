import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField textBox;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addBtn, subBtn, mulBtn, divBtn, decBtn, equalBtn, delBtn, clrBtn;
	JPanel panel;

	double num1 = 0;	
	double num2 = 0;	
	double result = 0;	
	String operator;

	Font myFont = new Font("Helvetica", Font.BOLD, 30);

	Calculator() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 532);
		frame.setLayout(null);
		frame.setResizable(false);

		textBox = new JTextField();
		textBox.setBounds(18, 18, 300, 65);
		textBox.setFont(myFont);
		textBox.setEditable(false);
		textBox.setHorizontalAlignment(JTextField.RIGHT);

		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("x");
		divBtn = new JButton("÷");
		decBtn = new JButton(".");
		equalBtn = new JButton("=");
		delBtn = new JButton("D");
		clrBtn = new JButton("C");

		functionButtons[0] = addBtn;
		functionButtons[1] = subBtn;
		functionButtons[2] = mulBtn;
		functionButtons[3] = divBtn;
		functionButtons[4] = decBtn;
		functionButtons[5] = equalBtn;
		functionButtons[6] = delBtn;
		functionButtons[7] = clrBtn;

		for(int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            

            functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            functionButtons[i].setBorderPainted(false);
            functionButtons[i].setContentAreaFilled(false);
        }

		 for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            numberButtons[i].setBorderPainted(false);
            numberButtons[i].setContentAreaFilled(false);
        }

		delBtn.setBounds(172, 94, 68, 50);
        clrBtn.setBounds(248, 94, 68, 50);

        panel = new JPanel();
        panel.setBounds(18, 150, 300, 320);
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(addBtn);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(equalBtn);
        panel.add(divBtn);

        frame.add(panel);

        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(textBox);
        frame.setVisible(true);	
	}

	public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

	public void actionPerformed(ActionEvent e) {

        for(int i = 0 ;i < 10; i++) {

            if(e.getSource() == numberButtons[i]) {
                textBox.setText(textBox.getText().concat(String.valueOf(i)));
            }

        }

        if(e.getSource() == decBtn) {
            String temp = textBox.getText();

            if (!temp.contains(".")) {
                textBox.setText(temp + ".");
            }
			
        }

        if(e.getSource() == addBtn) {
            num1 = Double.parseDouble(textBox.getText());
            operator = "+";
            textBox.setText("");
        }

        if(e.getSource() == subBtn) {
            num1 = Double.parseDouble(textBox.getText());
            operator = "-";
            textBox.setText("");
        }

        if(e.getSource() == mulBtn) {
            num1 = Double.parseDouble(textBox.getText());
            operator = "×";
            textBox.setText("");
        }

        if(e.getSource() == divBtn) {
            num1 = Double.parseDouble(textBox.getText());
            operator = "÷";
            textBox.setText("");
        }

        if(e.getSource() == equalBtn) {
            num2 = Double.parseDouble(textBox.getText());

            switch(operator) {
                case"+":
                    result = num1 + num2;
                    break;
                case"-":
                    result = num1 - num2;
                    break;
                case"×":
                    result = num1 * num2;
                    break;
                case"÷":
                    result = num1 / num2;
                    break;
            }
			
            textBox.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrBtn) {
            textBox.setText("");
        }

        if (e.getSource() == delBtn) {
            String string = textBox.getText();

            if (!string.isEmpty()) {
                StringBuilder sb = new StringBuilder(string);
                sb.deleteCharAt(sb.length() - 1);
                textBox.setText(sb.toString());
            }

        }
    }

}
