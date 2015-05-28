import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.sql.Connection;

//import javax.swing.JLabel;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JPasswordField;
import javax.swing.JButton;


public class Login {
    public static int loginC=0;
    int sell=1;
	private JFrame frame;
	String name;
	String password;
	String warning=null;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Label label = new Label("洗浴中心计费系统");
		label.setBounds(140, 21, 134, 25);
		frame.getContentPane().add(label);
		
		final TextField textField = new TextField();
		textField.setBounds(106, 75, 193, 31);
		frame.getContentPane().add(textField);
		
		final Label label_4 = new Label(warning);
		label_4.setBounds(316, 75, 106, 25);
		frame.getContentPane().add(label_4);
		
		Button button = new Button("会员登陆");
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				name=textField.getText();
				char[] a=passwordField.getPassword();
				String pass=new String(a);
				ConnectAccess ca=new ConnectAccess();  
				try {
					ca.ConnectAccessFile(name,pass);
				} catch (Exception e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
				if(ConnectAccess.correct==0){
					warning="输入错误";
					label_4.setText(warning);
				}
				else{
				loginC=1;
				try {
					Calculation window = new Calculation();
					window.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(34, 175, 126, 50);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("直接结账");
		button_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loginC=0;
				try {
					Calculation window = new Calculation();
					window.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(246, 175, 126, 50);
		frame.getContentPane().add(button_1);
		
		Label label_1 = new Label("会员卡号");
		label_1.setBounds(34, 75, 77, 25);
		frame.getContentPane().add(label_1);
		
		final Label label_2 = new Label("总营业额为  元");
		label_2.setBounds(34, 260, 193, 67);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("密码");
		label_3.setBounds(34, 131, 62, 25);
		frame.getContentPane().add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(106, 131, 193, 24);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("查看总营业额");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ConnectAccess ca=new ConnectAccess();  
				try {
					sell=ca.seal();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				label_2.setText("总营业额为"+sell+"元");
			}
		});
		btnNewButton.setBounds(267, 260, 151, 71);
		frame.getContentPane().add(btnNewButton);
	}
}
