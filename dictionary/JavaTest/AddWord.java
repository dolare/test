package JavaTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class AddWord extends JFrame {

	private JComboBox npartment;
	static JFrame Frame;
	private JTextArea nusage;
	private JTextField ntranslate;
	private JTextField nword;
	
	public AddWord() {
		super();
		
		//将程序的风格设为windows的
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//
		getContentPane().setLayout(null);
		setTitle("增加词库");
		setBounds(100, 100, 362, 400);

		final JLabel label = new JLabel();
		label.setText("新单词：");
		label.setBounds(10, 33, 66, 18);
		getContentPane().add(label);

		nword = new JTextField();
		nword.setBounds(95, 30, 138, 22);
		getContentPane().add(nword);

		final JLabel label_1 = new JLabel();
		label_1.setText("中文解释：");
		label_1.setBounds(10, 80, 66, 18);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("单词用法：");
		label_2.setBounds(10, 132, 66, 18);
		getContentPane().add(label_2);

		ntranslate = new JTextField();
		ntranslate.setBounds(95, 78, 138, 22);
		getContentPane().add(ntranslate);

		nusage = new JTextArea();
		nusage.setBorder(new LineBorder(Color.black, 1, false));
		nusage.setBounds(95, 132, 238, 115);
		getContentPane().add(nusage);
		//添加新词
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Data data = new Data();
				try {
					data.OpenConn();
					String sql="INSERT INTO WordList(word,translate,usage,partment)" +
					"VALUES('"+nword.getText()+"','"+ntranslate.getText()+"','"+nusage.getText()+"'," +
							"'"+npartment.getSelectedItem().toString()+"')";
					data.executeUpdate(sql);
					JOptionPane.showMessageDialog(AddWord.Frame, "成功添加单词，谢谢使用！");
					setVisible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setText("添加");
		button.setBounds(120, 333, 99, 23);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setText("取消");
		button_1.setBounds(234, 333, 99, 23);
		getContentPane().add(button_1);

		final JLabel label_3 = new JLabel();
		label_3.setText("词汇分组：");
		label_3.setBounds(10, 272, 66, 18);
		getContentPane().add(label_3);

		npartment = new JComboBox();
		npartment.setModel(new DefaultComboBoxModel(new String[] {"常用词汇", "四级词汇", "六级词汇", "专用词汇"}));
		npartment.setBounds(95, 268, 138, 27);
		getContentPane().add(npartment);
		
	}

}
