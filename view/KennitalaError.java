package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class KennitalaError extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KennitalaError dialog = new KennitalaError();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KennitalaError() {
		setTitle("Warning");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 204, 204));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(KennitalaError.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
			lblNewLabel_1.setBounds(92, 81, 32, 63);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Booking unsuccessful.");
			lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
			lblNewLabel.setBounds(136, 93, 235, 16);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblSomethingIsWrong = new JLabel("Kennitala can only be a number");
		lblSomethingIsWrong.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblSomethingIsWrong.setBounds(134, 110, 237, 16);
		contentPanel.add(lblSomethingIsWrong);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(204, 204, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Verdana", Font.PLAIN, 13));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false); 
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
