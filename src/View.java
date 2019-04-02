import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
	
	// Chúng ta sẽ xây dựng ứng dụng theo mind map 
	
	//Khai báo các biến
	Model model;
	
	private JPanel mainPane;
	private JPanel contentPane;
	
	private JButton[][] buttons;
	private JButton button;
	
	private JLabel label;
	
	private int[][] vals;
	private int generation = 1;
	//Hàm dựng 
	
	View() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		
		model = new Model();
		
		mainPane = new JPanel(new BorderLayout());
		contentPane = new JPanel(new GridLayout(10,10));
		label = new JLabel("Thế hệ thứ " + String.valueOf(generation), JLabel.CENTER);
		button = new JButton("Thế hệ tiếp theo");
		initButtons();
		mainPane.add(label, BorderLayout.NORTH);
		mainPane.add(contentPane);
		mainPane.add(button, BorderLayout.SOUTH);
		
		add(mainPane);
	}
	
	void initButtons () {
		buttons = new JButton[10][10];
		vals = model.getValsFromFile("./src/0.txt");
		for (int i = 0; i < buttons.length; i++)
			for (int j = 0; j < buttons.length; j++) {
				// Khởi tạo và gán giá trị cho button tương ứng với vals
				buttons[i][j] = new JButton(vals[i][j] == 1 ? "#" : "");
				// Thêm button vào contentPane
				contentPane.add(buttons[i][j]);
			}
	}
	
	void update(int[][] newVals) {
		vals = newVals;
		updateLabel();
		for (int i = 0; i < vals.length; i++) 
			for (int j = 0; j < vals.length; j++) 
				buttons[i][j].setText(vals[i][j] == 1 ? "#" : "");
	}
	
	void addButtonEvent(ActionListener ac) {
		button.addActionListener(ac);
	}
	
	void updateLabel() {
		label.setText("Thế hệ thứ " + String.valueOf(++generation));
	}
	
	int[][] getVals() {
		return vals;
	}
}
