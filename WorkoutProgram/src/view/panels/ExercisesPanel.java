package view.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controller.Controller;
import model.Exercise;
import model.MuscleGroup;

public class ExercisesPanel extends JPanel {

	public final String NAME = PanelsName.EXERCISES.name();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/background.gif"));
		Image background = ii.getImage();
		if (background != null) {
			g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	public ExercisesPanel() {
		super();
	}

	public void createPanel(Container container, Controller controller) {
		CardLayout layout = (CardLayout) container.getLayout();

//		 Creating left JSplit
//		 Creating JTreePanel

		JPanel treePanel = new JPanel();
		treePanel.setLayout(new GridLayout(1, 2));
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Упражения");
		DefaultMutableTreeNode[] nodes = new DefaultMutableTreeNode[controller.getPoolExercises().getMuscleGroups()
				.size()];

		for (int i = 0; i < controller.getPoolExercises().getMuscleGroups().size(); i++) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(
					controller.getPoolExercises().getMuscleGroups().get(i), true);
			root.add(nodes[i] = node);
		}

		for (int i = 0; i < controller.getPoolExercises().getMuscleGroups().size(); i++) {
			List<Exercise> exercises = controller.getPoolExercises().getMuscleGroups().get(i).getExercises();
			for (int j = 0; j < exercises.size(); j++) {
				nodes[i].add(new DefaultMutableTreeNode(exercises.get(j), false));
			}
		}

		DefaultTreeModel model = new DefaultTreeModel(root, true);
		JTree tree = new JTree(model);
		tree.setRootVisible(true);
		JScrollPane scroll = new JScrollPane(tree);
		JPanel buttonTreePanel = new JPanel();
		JButton select = new JButton("Просмотр");
		buttonTreePanel.add(select);
		buttonTreePanel.setLayout(new GridLayout(1, 2));
		JSplitPane treeSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scroll, buttonTreePanel);
		treeSplit.setDividerLocation(365);
		treePanel.add(treeSplit);

//		 Creating JListPanel

		JPanel listPanel = new JPanel();
		listPanel.setLayout(new GridLayout());
		DefaultListModel<Exercise> listModel = new DefaultListModel<>();
		JList<Exercise> list = new JList<>(listModel);
		list.setPreferredSize(new Dimension(250, 150));
		listPanel.setBackground(Color.WHITE);
		JPanel jlistPanel = new JPanel();
		jlistPanel.setPreferredSize(new Dimension(10, 10));
		JLabel listLabel = new JLabel("Список выбранных упражнений");
		jlistPanel.add(listLabel);
		jlistPanel.add(new JScrollPane(list));
		JPanel buttonsListPanel = new JPanel();
//		buttonsListPanel.setLayout(new GridLayout());
		JButton remove = new JButton("Удалить из списка");
		JButton showExerciseInList = new JButton("Просмотр упражнения из списка");
		buttonsListPanel.add(showExerciseInList);
		buttonsListPanel.add(remove);
		JSplitPane listSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jlistPanel, buttonsListPanel);
		listSplit.setDividerLocation(180);
		listPanel.add(listSplit);
		JSplitPane leftSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, treePanel, new JScrollPane(listPanel));

//		 Creating right JSplit

		JPanel imagesPanel = new JPanel();
		imagesPanel.setBackground(Color.WHITE);
		imagesPanel.setLayout(new GridBagLayout());
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/noSelect.gif"));
		label.setIcon(icon);
		imagesPanel.add(label);

		JPanel exerciseDescriptionPanel = new JPanel();
		exerciseDescriptionPanel.setLayout(new GridBagLayout());
		JTextArea exerciseDescription = new JTextArea(10, 10);
		exerciseDescription.setLineWrap(true);
		exerciseDescription.setWrapStyleWord(true);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));

//		Add a buttons action listeners

		JButton add = new JButton("Добавить в список");
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tree.getLastSelectedPathComponent() == null) {
					JOptionPane.showMessageDialog(null, "Не выбрано упражнение");
					return;
				}
				DefaultMutableTreeNode obj = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (obj.getUserObject() instanceof MuscleGroup) {
					JOptionPane.showMessageDialog(null, "Необходимо выбрать упражнение");
					return;
				} else if (obj.getUserObject() instanceof Exercise) {
					Exercise exercise = (Exercise) obj.getUserObject();
					for (int i = 0; i < listModel.getSize(); i++) {
						if (listModel.get(i).equals(exercise)) {
							JOptionPane.showMessageDialog(null, "Уже есть в списке");
							return;
						}
					}
					listModel.addElement(exercise);
					controller.getSelectedExercises().add(exercise);
				}

			}
		});

		JButton back = new JButton("Назад");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				layout.show(container, PanelsName.STARTPANEL.name());

			}
		});

		JButton createProgram = new JButton("Создать программу");

		createProgram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (controller.getSelectedExercises().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Для создания программы тренеровок, необходимо добавить упражнение");
					return;
				}
				if (listModel.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Для создания программы тренеровок, необходимо добавить упражнение");
					return;
				} else {
					JPanel panel = new JPanel();
					JLabel label = new JLabel("Введите название вашей программы");
					JTextField text = new JTextField(10);
					panel.add(label);
					panel.add(text);
					JOptionPane.showMessageDialog(null, panel);
					if (text.getText() == null) {
						JOptionPane.showMessageDialog(null, "Некорректное название");
						return;
					}
					controller.createProgram(text.getText());
					JOptionPane.showMessageDialog(null, "Программа создана");
					listModel.clear();
				}

			}
		});

		select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tree.getLastSelectedPathComponent() == null) {
					JOptionPane.showMessageDialog(null, "Не выбрано упражнение");
					return;
				}
				DefaultMutableTreeNode obj = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (obj.getUserObject() instanceof MuscleGroup) {
					JOptionPane.showMessageDialog(null, "Необходимо выбрать упражнение");
					return;
				} else if (obj.getUserObject() instanceof Exercise) {
					Exercise exercise = (Exercise) obj.getUserObject();
					label.setIcon(exercise.getIcon());
					exerciseDescription.setText(exercise.getInfo());
				}

			}
		});

		showExerciseInList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (list.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Не выбрано упражнение");
					return;
				}
				label.setIcon(list.getSelectedValue().getIcon());
				exerciseDescription.setText(list.getSelectedValue().getInfo());

			}
		});

		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Не выбрано упражнение");
					return;
				}
				controller.getSelectedExercises().remove(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());

			}
		});

		buttonPanel.add(add);
		buttonPanel.add(createProgram);
		buttonPanel.add(back);
		JSplitPane infoSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(exerciseDescription),
				buttonPanel);
		infoSplit.setDividerLocation(290);
		JSplitPane rightSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, imagesPanel, infoSplit);

//		Creating main JSplit

		JPanel panel = new JPanel();
		JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(leftSplit),
				new JScrollPane(rightSplit));
		mainSplit.setPreferredSize(new Dimension(900, 650));
		mainSplit.setDividerLocation(400);
		this.setLayout(new GridBagLayout());
		panel.add(mainSplit);
		this.add(panel);
	}

}
