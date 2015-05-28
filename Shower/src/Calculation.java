import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;

/*import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;*/


public class Calculation {
	Shower shower=new Bath();
	int countA=0;
	int countRu=0; //搓背计数
	int countS=0;
	int countR=0; //玫瑰浴计数
	int countM=0;
	int countSh=0; //是否淋浴
	
	boolean isSelected = false;
	private int price=0;
	private JFrame frame;
    public JFrame getFrame() {
		return frame;
	}
    private String note="";
    public int sum=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculation window = new Calculation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox checkBox = new JCheckBox("淋浴");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isSelected){
					isSelected = false;
				}else{
					isSelected = true;
				}
			}
		});
		
	

		Button button_1 = new Button("搓背");
		button_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				countRu++;
			}
		});
		button_1.setBounds(47, 164, 102, 41);
		frame.getContentPane().add(button_1);
		
		Label label = new Label("选择服务");
		label.setBounds(163, 20, 118, 33);
		frame.getContentPane().add(label);
		
		Button button_2 = new Button("针灸");
		button_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				countA++;
			}
		});
		button_2.setBounds(47, 230, 102, 33);
		frame.getContentPane().add(button_2);
		
		Button button_3 = new Button("牛奶浴");
		button_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				countM++;
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(264, 87, 118, 41);
		frame.getContentPane().add(button_3);
		
		Button button_4 = new Button("硫磺浴");
		button_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				countS++;
			}
		});
		button_4.setBounds(264, 212, 118, 41);
		frame.getContentPane().add(button_4);
		
		Button button_5 = new Button("玫瑰浴");
		button_5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				countR++;
			}
		});
		button_5.setBounds(261, 149, 121, 41);
		frame.getContentPane().add(button_5);
		
		final Label label_1 = new Label("接受的服务为："+note+"     费用共计："+price+"元");
		label_1.setBounds(10, 321, 412, 123);
		frame.getContentPane().add(label_1);
		
		Button button_6 = new Button("结账");
		button_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(isSelected){
					countSh=1;
				}
                if(countSh==0){
                	shower.description="";
                	sum-=10;
				}
				for(;countRu>0;countRu--){
					shower=new Rubbling(shower);
				}
				for(;countA>0;countA--){
					shower=new Acupuncture(shower);
				}
				for(;countS>0;countS--){
					shower=new Sulphur(shower);
				}
				for(;countR>0;countR--){
					shower=new Rose(shower);
				}
				for(;countM>0;countM--){
					shower=new Milk(shower);
				}
				sum+=shower.cost();
				note=shower.getDescription();
				price=Calculate.discount(sum);
				label_1.setText("接受的服务为："+note+"     费用共计："+price+"元   ");
				ConnectAccess ca=new ConnectAccess();
				try {
					ca.add(price);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button_6.setBounds(77, 282, 271, 33);
		frame.getContentPane().add(button_6);
		
		
		checkBox.setBounds(47, 107, 133, 27);
		frame.getContentPane().add(checkBox);
		

	}
}
