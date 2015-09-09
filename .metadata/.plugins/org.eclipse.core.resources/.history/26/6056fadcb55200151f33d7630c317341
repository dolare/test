//import java.util.Map;
import javax.swing.*;

import java.lang.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener{
 
	private int m_Columns=8;       
	private int m_Rows=9;
	
	private int m_PlayerFlag;
	
	private Mode m_PlayMode;
	 
	private Map m_Map;      
	 
	private Table m_Table;  
	 
	private RoundButton[][] m_RoundButton;
	
	private int m_WinFlag=0;
	 
	private JButton m_SetGame;
	 
	private JButton m_StartGame;
	 
	private JButton m_NewGame;
	 
	private JButton m_Exit;  
	 
	private InfoShow m_InfoBoard;
	 
	private UserInfo m_User1Board,m_User2Board;
	
	private SetDialog m_dialog;
	
	
	
	String imagePath = "res/bk.jpg";
	ImagePanel panel;
	
	
	public Game()
	{
		
		InitGame();
	}

	public void InitGame() 
	{
		m_PlayerFlag=1;
		Container container=getContentPane();

		GridLayout tableLayout=new GridLayout(m_Rows,m_Columns);
		
		m_PlayMode=new Mode();
	
		m_Table=new Table(tableLayout);
		//m_Table.setBackground(Color.white);	
		m_InfoBoard=new InfoShow();
		m_RoundButton=new RoundButton[m_Rows][m_Columns];
		
		m_User1Board=new UserInfo("p1",Color.yellow);
		m_User2Board=new UserInfo("p2",Color.red);
		
		m_InfoBoard.SetP1Name(m_User1Board.m_Name);
		m_InfoBoard.SetP2Name(m_User2Board.m_Name);
		
		ImageIcon StartIcon=new ImageIcon("res/start.jpg");
		ImageIcon NewIcon=new ImageIcon("res/new.jpg");
		ImageIcon ExitIcon=new ImageIcon("res/exit.jpg");
		ImageIcon SetIcon=new ImageIcon("res/set.jpg");
		
		m_SetGame=new JButton(SetIcon);
		m_SetGame.addActionListener(this);
		
		m_StartGame=new JButton(StartIcon);
		m_StartGame.addActionListener(this);
		
		m_NewGame=new JButton(NewIcon);
		m_NewGame.addActionListener(this);
		
		m_Exit=new JButton(ExitIcon);
		m_Exit.addActionListener(this);

		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				m_RoundButton[i][j]=new RoundButton();
				
				m_RoundButton[i][j].addActionListener(this);
				
				m_RoundButton[i][j].setEnabled(false);
				
				m_Table.add(m_RoundButton[i][j]);
			}
		}

		panel=new ImagePanel(imagePath);
		
		container.add(m_StartGame);
		container.add(m_NewGame);
		container.add(m_SetGame);
		container.add(m_Exit);
		container.add(m_Table);
		container.add(m_InfoBoard);
		container.add(m_User1Board);
		container.add(m_User2Board);
		container.add(panel);
		container.setLayout(null);
		m_Table.setBounds(20,20,m_Columns*48,m_Rows*48);
		m_InfoBoard.setBounds(420,20,160,80);
			
		m_StartGame.setBounds(20,480,64,64);
		m_NewGame.setBounds(120,480,64,64);
		m_Exit.setBounds(218,480,64,64);
		m_SetGame.setBounds(316,480,64,64);
		
		panel.setBounds(0,0,1280, 620);
	}
	

	public void SetGame() 
	{
		m_dialog=new SetDialog(this,m_PlayMode,m_User1Board,m_User2Board,m_InfoBoard);
		m_dialog.show();

		m_InfoBoard.SetP1Name(m_User1Board.m_Name);
		m_InfoBoard.SetP2Name(m_User2Board.m_Name);
		
	}

	public void StartGame() 
	{
		m_Map=new Map(m_Rows,m_Columns);
		m_InfoBoard.ShowMessage();
		
		
		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				
				m_RoundButton[i][j].setEnabled(true);
				
			}
		}
		m_StartGame.setEnabled(false);
	}
	

	public void StopGame()
	{
		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				
				m_RoundButton[i][j].setEnabled(false);
				
			}
		}
	}

	public void NewGame() 
	{
		m_WinFlag=0;
		m_InfoBoard.EqualFlag=0;
		m_PlayerFlag=1;
		m_InfoBoard.SetPlayerFlag(m_PlayerFlag);
		m_InfoBoard.WinFlag=0;
		m_Map=new Map(m_Rows,m_Columns);
		m_InfoBoard.ShowMessage();
		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				m_RoundButton[i][j].setEnabled(true);
				m_RoundButton[i][j].hitFlag=0;
				m_RoundButton[i][j].setBackground(getBackground());

			}
		}
	}
	
	public void Exit() 
	{
		dispose();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(m_StartGame))
		{
			StartGame();
		}
		
		if (e.getSource().equals(m_SetGame))
		{
			SetGame();
		}
		
		if (e.getSource().equals(m_NewGame))
		{
			NewGame();
		}
		
		if (e.getSource().equals(m_Exit))
		{
			Exit();
		}

		for (int i = 0; i < m_Rows; i++) 
		{
			for (int j = 0; j < m_Columns; j++) 
			{
				if (e.getSource().equals(m_RoundButton[i][j])) 
				{ 
					if (m_PlayMode.PlayMode == 1) 
					{
						System.out.println("mousePressed()");
						if (m_PlayerFlag == 1) 
						{
							if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
							{
								m_RoundButton[m_Map.Place(j)][j]
										.setBackground(m_User1Board.m_Color);
								m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
								
								m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//���õ�ͼ
								
								m_Map.m_Count--;
								
								if(m_Map.IsEqual())
								{
									System.out.println("equal");
									m_InfoBoard.EqualFlag=1;
									m_InfoBoard.ShowEqual();
								}
								
								if(m_Map.IsWin(m_Map.Place(j),j,m_PlayerFlag))
								{
									System.out.println("end");
									m_InfoBoard.ShowWin();
									StopGame();
								}
								
								
								m_Map.AddPlace(j);
								m_PlayerFlag = 2;
								m_InfoBoard.SetPlayerFlag(2);
								m_InfoBoard.ShowMessage();
							}
						} 
						else 
						{
							if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
							{
								m_RoundButton[m_Map.Place(j)][j]
										.setBackground(m_User2Board.m_Color);
								m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
								
								m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//���õ�ͼ
								
								m_Map.m_Count--;
								if(m_Map.IsEqual())
								{
									System.out.println("equal");
									m_InfoBoard.EqualFlag=1;
									m_InfoBoard.ShowEqual();
								}
								
								if(m_Map.IsWin(m_Map.Place(j),j,m_PlayerFlag))
								{
									System.out.println("end");
									m_InfoBoard.ShowWin();
									
									StopGame();
								}
								
								m_Map.AddPlace(j);
								
								m_PlayerFlag = 1;
								m_InfoBoard.SetPlayerFlag(1);
								m_InfoBoard.ShowMessage();
							}
						}
					} 

					else 
					{
  
						if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
						{
							m_RoundButton[m_Map.Place(j)][j]
									.setBackground(m_User1Board.m_Color);
							m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
							
							
							m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//���õ�ͼ

							m_Map.m_Count--;
							if(m_Map.IsEqual())
							{
								System.out.println("equal");
								m_InfoBoard.EqualFlag=1;
								m_InfoBoard.ShowEqual();
							}
							

							if(m_Map.IsWin(m_Map.Place(j),j,m_PlayerFlag))
							{
								System.out.println("end");
								m_WinFlag=1;
								m_InfoBoard.ShowWin();
								StopGame();
							}
							
							m_Map.AddPlace(j);
							
							m_PlayerFlag = 2;
							m_InfoBoard.SetPlayerFlag(2);
							m_InfoBoard.ShowMessage();
						}

						// �������� 
						if (m_WinFlag==0&&m_PlayerFlag == 2) 
						{
							//Thread.currentThread().sleep(500);
							
							int temp = m_Map.ComputerAiPlace();
							
							while (m_RoundButton[m_Map.Place(temp)][temp].hitFlag != 0) {
								temp = m_Map.ComputerPlace();
							}
							

							m_RoundButton[m_Map.Place(temp)][temp]
									.setBackground(m_User2Board.m_Color);
							m_RoundButton[m_Map.Place(temp)][temp].hitFlag = m_PlayerFlag;
							
							
							m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(temp),temp);//���õ�ͼ
							
							
							
							m_Map.m_Count--;
							if(m_Map.IsEqual())//�ж�ƽ��
							{
								System.out.println("equal");
								m_InfoBoard.EqualFlag=1;
								m_InfoBoard.ShowEqual();
							}
							
							if(m_Map.IsWin(m_Map.Place(temp),temp,m_PlayerFlag))
							{
								System.out.println("end");
								m_InfoBoard.ShowWin();
								StopGame();
							}
							
							m_Map.AddPlace(temp);
							
							m_PlayerFlag = 1;							
							m_InfoBoard.SetPlayerFlag(1);
							m_InfoBoard.ShowMessage();
						}

					}
				}

			}
		}
	}

	public static void main(String[] args) 
	{
		Game panel=new Game();
		panel.setTitle("Connect Four by Razieh");
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setSize(1280, 620);
		
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int ScreenWidth=screenSize.width;
		int ScreenHeight=screenSize.height;
		
		int x=(ScreenWidth-panel.getWidth())/2;
		int y=(ScreenHeight-panel.getHeight())/2;
		panel.setLocation(x, y);
		
		panel.setVisible(true);

	}
	 
}


class Mode
{
	public int PlayMode=0;
	
}
 
