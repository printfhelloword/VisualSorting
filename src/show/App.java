package show;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;


public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;   //最顶层JPanel
	

	//存放画图功能容器
	public JPanel panelSort3;
	public JPanel panelSort2;
	public JPanel panelSort1;

	public static Menu menu;	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {

		App app = new App();
		menu=new Menu(app);
	}

	/**
	 * Create the frame.
	 */
	public App() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1200, 850);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		panelSort3 = new JPanel();
		panelSort2 = new JPanel();
		panelSort1 = new JPanel();
		panel.add(panelSort1);
		panel.add(panelSort2);
		panel.add(panelSort3);
		/* 插入排序 */
		panelSort1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSort1.setLayout(new BoxLayout(panelSort1, BoxLayout.X_AXIS));
		/* 希尔排序 */
		panelSort2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSort2.setLayout(new BoxLayout(panelSort2, BoxLayout.X_AXIS));
		/* 快速排序 */
		panelSort3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSort3.setLayout(new BorderLayout(0, 0));
		/* 表头容器 表头字体 颜色 大小设置*/
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new GridLayout(3, 1, 10, 0));
		
		JLabel lblNewLabel = new JLabel("  插入排序  ");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 30));
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  希尔排序  ");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 30));
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  快速排序  ");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 30));
		panel_3.add(lblNewLabel_2);
		
		/* 按钮容器 */
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		//单选按钮
		JLabel orderLable = new JLabel("排序顺序：");
		JRadioButton rb1=new JRadioButton(" 顺序",true);
		rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setOrder(false);
			}
		});
		JRadioButton rb2=new JRadioButton(" 倒序");
		rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setOrder(true);
			}
		});
		JLabel arrayLable = new JLabel("  选择数组：");
		JRadioButton rb3=new JRadioButton(" 顺序数组",true);
		rb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setRand(false);
				menu.setData();
				menu.prepareDraw();
			}
		});
		JRadioButton rb4=new JRadioButton(" 随机数组");
		rb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setRand(true);
				menu.setData();
				menu.prepareDraw();
			}
		});
		//单选按钮分组
		ButtonGroup group1=new ButtonGroup();
		group1.add(rb1);
		group1.add(rb2);
		ButtonGroup group2=new ButtonGroup();
		group2.add(rb3);
		group2.add(rb4);
		//向按钮容器添加组件
		panel_2.add(orderLable);
		panel_2.add(rb1);
		panel_2.add(rb2);
		panel_2.add(arrayLable);
		panel_2.add(rb3);
		panel_2.add(rb4);
		
		JButton btnNewButton_3 = new JButton("打乱数组");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setShuffle();
				menu.prepareDraw();
			}
		});
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("开始排序");
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnNewButton.setEnabled(false);  // 禁用按钮
			menu.start();
			btnNewButton.setEnabled(true);   // 开启按钮功能
			}
		});
		

		
		JButton btnNewButton_2 = new JButton("排序时间");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double[] time=menu.getSortTime();
				JOptionPane.showMessageDialog(null, "插入排序用时："+time[0]+"ms\n希尔排序用时："+time[1]+"ms\n快速排序用时："+time[2]+"ms", " 排序时间",1);
			}
		});
		panel_2.add(btnNewButton_2);
		//添加其他按钮
		
		
		setVisible(true);     //设置窗口可见
		setResizable(false); //禁止改变大小
	}

}
