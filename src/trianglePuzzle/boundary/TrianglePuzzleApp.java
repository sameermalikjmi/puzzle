package trianglePuzzle.boundary;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import trianglePuzzle.controller.ResetController;
import trianglePuzzle.controller.SelectUnselectNodeController;
import trianglePuzzle.controller.SwapEdgeController;
import trianglePuzzle.controller.UnselectAllNodesController;
import trianglePuzzle.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TrianglePuzzleApp extends JFrame {

	private JPanel contentPane;
    Model model;
	PuzzlePanel panel;
	JButton  swapEdgeBtn, resetPuzzleBtn,unSelectAllNodesBtn;
	JLabel   playerScore, playerMoves;
	JTextField winMsg;
	
	public JTextField getWinMsg() {
		return winMsg;
	}


	public void setWinMsg(JTextField winMsg) {
		this.winMsg = winMsg;
	}


	public JButton getSwapEdgeBtn() {
		return swapEdgeBtn;
	}


	public JButton getResetPuzzleBtn() {
		return resetPuzzleBtn;
	}


	public JButton getUnSelectAllNodesBtn() {
		return unSelectAllNodesBtn;
	}


	public JLabel getPlayerScore() {
		return playerScore;
	}


	public JLabel getPlayerMoves() {
		return playerMoves;
	}


	public PuzzlePanel getPanel() {
		return panel;
	}


	public void setPanel(PuzzlePanel panel) {
		this.panel = panel;
	}
	public TrianglePuzzleApp(Model model) {
		 this.model =model;
		setTitle("Triangle Puzzle App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel scoreBoardLabel = new JLabel("Score");
		JLabel numberOfMoversVariable = new JLabel("Moves");
		 swapEdgeBtn = new JButton("Swap Adjacent Edges");
		
		 resetPuzzleBtn = new JButton("Reset");
		
		 unSelectAllNodesBtn = new JButton("Unselect All Nodes");
		
		
		
		 playerScore = new JLabel("0");
		
		 playerMoves = new JLabel("0");
		
		panel = new PuzzlePanel(model);
		winMsg = new JTextField();
		winMsg.setText("Congratulations You WON");
		winMsg.setColumns(10);
		winMsg.setVisible(false);
		
		panel.addMouseListener(new MouseAdapter() { 
			
			
			@Override
			
			public void mousePressed(MouseEvent me) {
				new SelectUnselectNodeController (model, TrianglePuzzleApp.this).process(me.getPoint());
			}
		});
		
		unSelectAllNodesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UnselectAllNodesController(model, TrianglePuzzleApp.this).unselectAll();
				
			}
		});
		unSelectAllNodesBtn.setEnabled(false);
		swapEdgeBtn.setEnabled(false);
		swapEdgeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SwapEdgeController(model, TrianglePuzzleApp.this).swapEdges();
				
			}
		});
		resetPuzzleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, TrianglePuzzleApp.this).reset();
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(swapEdgeBtn)
									.addGap(18)
									.addComponent(unSelectAllNodesBtn))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(scoreBoardLabel)
									.addGap(18)
									.addComponent(playerScore, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(resetPuzzleBtn)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(numberOfMoversVariable)
											.addGap(33)
											.addComponent(playerMoves, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(winMsg, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(winMsg, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(swapEdgeBtn)
						.addComponent(unSelectAllNodesBtn))
					.addGap(42)
					.addComponent(resetPuzzleBtn)
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scoreBoardLabel)
						.addComponent(numberOfMoversVariable)
						.addComponent(playerScore)
						.addComponent(playerMoves))
					.addGap(64))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
