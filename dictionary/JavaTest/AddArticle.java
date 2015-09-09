package JavaTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class AddArticle extends JFrame {

	private JTextArea ntranslate;
	private JTextArea narticle;
	public AddArticle() {
		super();
		setTitle("增加名篇");
		getContentPane().setLayout(null);
		setBounds(100, 100, 487, 386);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JLabel label = new JLabel();
		label.setText("英文原版");
		label.setBounds(10, 5, 66, 18);
		getContentPane().add(label);

		narticle = new JTextArea();
		narticle.setBorder(new LineBorder(Color.black, 1, false));
		narticle.setBounds(10, 30, 459, 124);
		getContentPane().add(narticle);

		final JLabel label_1 = new JLabel();
		label_1.setText("中文翻译");
		label_1.setBounds(10, 160, 66, 18);
		getContentPane().add(label_1);

		ntranslate = new JTextArea();
		ntranslate.setBorder(new LineBorder(Color.black, 1, false));
		ntranslate.setBounds(10, 184, 459, 115);
		getContentPane().add(ntranslate);

		final JSeparator separator = new JSeparator();
		separator.setBounds(10, 315, 459, 20);
		getContentPane().add(separator);
		//增加名篇
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Data data = new Data();
				try {
					data.OpenConn();
					String sql="INSERT INTO ArticleList(article,translate)" +
					"VALUES('"+narticle.getText()+"','"+ntranslate.getText()+"')";
					data.executeUpdate(sql);
					JOptionPane.showMessageDialog(AddWord.Frame, "成功添加名篇，谢谢使用！");
					setVisible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setText("确定");
		button.setBounds(245, 320, 82, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setText("取消");
		button_1.setBounds(347, 320, 82, 28);
		getContentPane().add(button_1);
		//
	}

}
