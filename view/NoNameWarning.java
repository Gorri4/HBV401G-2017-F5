package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class NoNameWarning extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NoNameWarning dialog = new NoNameWarning();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NoNameWarning() {
		setTitle("Warning");
		setBounds(100, 100, 461, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNameMissingTry = new JLabel("Booking unsuccessful, name missing.");
			lblNameMissingTry.setFont(new Font("Verdana", Font.PLAIN, 13));
			lblNameMissingTry.setBounds(125, 100, 292, 16);
			lblNameMissingTry.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNameMissingTry);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(NoNameWarning.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
			label.setBounds(95, 87, 32, 43);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Verdana", Font.PLAIN, 13));
				okButton.setHorizontalTextPosition(SwingConstants.CENTER);
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
