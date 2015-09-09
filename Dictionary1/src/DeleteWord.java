
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteWord extends JFrame {

	private JTextField dword;
	public DeleteWord() {
		super();
		setTitle("删除单词");
		getContentPane().setLayout(null);
		setBounds(100, 100, 293, 197);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JLabel label = new JLabel();
		label.setText("请输入你要删除的词：");
		label.setBounds(10, 32, 156, 18);
		getContentPane().add(label);

		dword = new JTextField();
		dword.setBounds(10, 73, 236, 22);
		getContentPane().add(dword);
		//删除单词
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Data data = new Data();
				try {
					data.OpenConn();
					String sql="delete * from WordList where word = '"+dword.getText()+"'";
					data.executeUpdate(sql);
					JOptionPane.showMessageDialog(AddWord.Frame, "成功删除单词，谢谢使用！");
					setVisible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setText("确定");
		button.setBounds(60, 125, 85, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.setText("删除");
		button_1.setBounds(179, 125, 85, 28);
		getContentPane().add(button_1);
		//
	}

}
