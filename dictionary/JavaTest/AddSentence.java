package JavaTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class AddSentence extends JFrame {

	private JTextArea nchinese;
	private JTextArea nenglish;
	public AddSentence() {
		super();
		setTitle("��������");
		getContentPane().setLayout(null);
		setBounds(100, 100, 302, 396);

		final JLabel label = new JLabel();
		label.setText("Ӣ��ԭ�䣺");
		label.setBounds(10, 10, 66, 18);
		getContentPane().add(label);

		nenglish = new JTextArea();
		nenglish.setBorder(new LineBorder(Color.black, 1, false));
		nenglish.setBounds(10, 40, 274, 118);
		getContentPane().add(nenglish);

		final JLabel label_1 = new JLabel();
		label_1.setText("���Ľ��ͣ�");
		label_1.setBounds(10, 176, 66, 18);
		getContentPane().add(label_1);

		nchinese = new JTextArea();
		nchinese.setBorder(new LineBorder(Color.black, 1, false));
		nchinese.setBounds(10, 208, 274, 108);
		getContentPane().add(nchinese);
		//��������
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Data data = new Data();
				try {
					data.OpenConn();
					String sql="INSERT INTO SentenceList(english,chinese)" +
					"VALUES('"+nenglish.getText()+"','"+nchinese.getText()+"')";
					data.executeUpdate(sql);
					JOptionPane.showMessageDialog(AddWord.Frame, "�ɹ�������䣬ллʹ�ã�");
					setVisible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setText("����");
		button.setBounds(113, 325, 77, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setText("ȡ��");
		button_1.setBounds(207, 325, 77, 28);
		getContentPane().add(button_1);
		
	}

}
