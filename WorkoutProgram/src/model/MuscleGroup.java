package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MuscleGroup implements Serializable {

	private static final long serialVersionUID = 9143965866856565856L;
	private String name;
	private List<Exercise> exercises;

//  Constructors

	public MuscleGroup() {
		super();
		List<Exercise> exercises = new ArrayList<>();
		this.exercises = exercises;
	}

	public MuscleGroup(String name, List<Exercise> exercises, boolean isLargeMuscleGroup,
			MuscleGroup compatibleMuscleGroup) {
		super();
		this.name = name;
		this.exercises = exercises;

	}

	public MuscleGroup(String name, boolean isLargeMuscleGroup) {
		super();
		this.name = name;
		List<Exercise> exercises = new ArrayList<>();
		this.exercises = exercises;
	}

	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}

}
