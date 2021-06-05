package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Program implements Serializable {

	private static final long serialVersionUID = 8616351499408132360L;
	private List<Exercise> exercises;
	private String name;

	public Program(List<Exercise> trainigDays, String name) {
		super();
		this.exercises = trainigDays;
		this.name = name;
	}

	public Program(String name) {
		super();
		this.name = name;
		List<Exercise> exercises = new ArrayList<>();
		this.exercises = exercises;

	}

	public Program() {
		super();
		List<Exercise> exercises = new ArrayList<>();
		this.exercises = exercises;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}

	public String showExercises() {
		StringBuilder builder = new StringBuilder();

		builder.append("\n");
		builder.append(
				"Перед тем как приступить к тренировке необходимо размяться. В общем разминка занимает 10-15 мин.Пренебрежение разминкой травмоопасно.");
		builder.append("\n");
		builder.append("\n");
		int j = 1;
		builder.append("День " + j);
		builder.append("\n");
		builder.append("Упражнения на мышцы пресса");
		builder.append("\n");
		for (int i = 0; i < exercises.size(); i++) {
			if (i != 0 && i % 6 == 0) {
				builder.append("\n");
				j++;
				builder.append("День " + j);
				builder.append("\n");
				builder.append("Упражнения на мышцы пресса");
				builder.append("\n");

			}
			builder.append(exercises.get(i).toString());
			builder.append("\n");
		}
		builder.append("\n");
		builder.append(
				"Каждое упражнение делать по 3 подхода(1х12 повторений,2х10 повторений,3х8 повторений,).Вес снарядов подбирается индивидуально.");
		return builder.toString();
	}

}
