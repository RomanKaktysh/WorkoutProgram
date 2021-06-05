package view;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import controller.Controller;
import view.panels.ExercisesPanel;
import view.panels.PanelsName;
import view.panels.ProgramsPanel;
import view.panels.StartPanel;

public class AppFrame extends JFrame {

	public AppFrame() {
	}

	public AppFrame(String title) {
		super(title);
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	public void createFrame(Controller controller) {

		Container container = this.getContentPane();
		container.setLayout(new CardLayout());
		CardLayout layout = (CardLayout) container.getLayout();
		StartPanel startPanel = new StartPanel();
		startPanel.createPanel(container);
		ProgramsPanel programsPanel = new ProgramsPanel();
		programsPanel.createrPanel(container, controller);
		ExercisesPanel exercisesPanel = new ExercisesPanel();
		exercisesPanel.createPanel(container, controller);
		this.add(startPanel, startPanel.NAME);
		this.add(exercisesPanel, PanelsName.EXERCISES.name());
		this.add(programsPanel, programsPanel.NAME);
		layout.show(container, startPanel.NAME);

	}

}
