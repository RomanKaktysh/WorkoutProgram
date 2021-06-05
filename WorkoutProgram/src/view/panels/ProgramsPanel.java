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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import controller.Controller;
import model.Program;

public class ProgramsPanel extends JPanel {

	public final String NAME = PanelsName.PROGRAMS.name();
	private final static Logger LOGGER = Logger.getLogger(ProgramsPanel.class);

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/background.gif"));
		Image background = ii.getImage();
		if (background != null) {
			g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	public ProgramsPanel() {
		super();

	}

	public void createrPanel(Container container, Controller controller) {

		CardLayout layout = (CardLayout) container.getLayout();
		File file = new File("Programs.txt");
		DefaultListModel<Program> model = new DefaultListModel<>();
		try {
			ObjectInputStream ins = new ObjectInputStream(new FileInputStream(file));
			List<Program> programs = (ArrayList<Program>) ins.readObject();

			for (Program program : programs) {
				model.addElement(program);
			}
			ins.close();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		JList<Program> list = new JList<Program>(model);
		list.setPreferredSize(new Dimension(250, 50));
		JTextArea text = new JTextArea(20, 20);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(list), new JScrollPane(text));

		JPanel buttonPanel = new JPanel();
		JButton select = new JButton("Выбрать");
		select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Выберите программу из списка");
					return;
				}
				text.setText(list.getSelectedValue().showExercises());

			}
		});

		JButton back = new JButton("Назад");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				layout.show(container, PanelsName.STARTPANEL.toString());

			}
		});
		JButton update = new JButton("Обновить");
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!model.isEmpty()) {
					for (int i = 0; i < model.getSize(); i++) {
						if (controller.getProgram() != null) {
							if (model.get(i).equals(controller.getProgram())) {
								return;
							} else {
								model.addElement(controller.getProgram());
							}
						}
					}

				}
				if (model.isEmpty()) {
					model.addElement(controller.getProgram());
				}
			}
		});
		buttonPanel.add(select);
		buttonPanel.add(update);
		buttonPanel.add(back);
		buttonPanel.setLayout(new GridLayout());
		JSplitPane mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, split, buttonPanel);
		mainSplit.setPreferredSize(new Dimension(600, 380));
		this.setLayout(new GridBagLayout());
		this.add(mainSplit);
	}

}
