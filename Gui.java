import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Artwork Searcher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("Enter Artist");
		JTextField tf = new JTextField(9);
		JButton button = new JButton("Search");
		panel.add(label);
		panel.add(tf);
		panel.add(button);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
}
