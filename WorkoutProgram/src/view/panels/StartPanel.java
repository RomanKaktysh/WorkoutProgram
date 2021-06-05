package view.panels;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class StartPanel extends JPanel {

	public final String NAME = PanelsName.STARTPANEL.name();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/background.gif"));
		Image background = ii.getImage();
		if (background != null) {
			g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	public StartPanel() {

	}

	public void createPanel(Container container) {

		CardLayout layout = (CardLayout) container.getLayout();
		JPanel gifPanel = new JPanel();
		gifPanel.setLayout(new GridBagLayout());
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/gym.gif"));
		JLabel label = new JLabel(icon);
		gifPanel.add(label);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout());
		JButton exercises = new JButton("Упражнения");
		exercises.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				layout.show(container, PanelsName.EXERCISES.name());

			}
		});
		JButton workoutPrograms = new JButton("Программы");
		workoutPrograms.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				layout.show(container, PanelsName.PROGRAMS.name());

			}
		});
		buttonsPanel.add(exercises);
		buttonsPanel.add(workoutPrograms);
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, gifPanel, buttonsPanel);
		split.setDividerLocation(500);
		split.setOneTouchExpandable(true);
		split.setPreferredSize(new Dimension(750, 550));

		this.setLayout(new GridBagLayout());
		this.add(split);

	}

}
