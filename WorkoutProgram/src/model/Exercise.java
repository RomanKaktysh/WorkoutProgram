package model;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Exercise implements Serializable {

	private static final long serialVersionUID = -8633122977268898708L;
	private String name;
	private ImageIcon icon;
	private String info;
	private MuscleGroup muscleGroup;
	private boolean isBasicExercise;

//  Constructors

	public Exercise() {
		super();
	}

	public Exercise(String name, ImageIcon icon, String info, MuscleGroup muscleGroup, boolean isBasicExercise) {
		super();
		this.name = name;
		this.icon = icon;
		this.info = info;
		this.muscleGroup = muscleGroup;
		this.isBasicExercise = isBasicExercise;
	}

	public Exercise(String name, ImageIcon icon, String info, boolean isBasicExercise) {
		super();
		this.name = name;
		this.icon = icon;
		this.info = info;
		this.isBasicExercise = isBasicExercise;
	}

	public Exercise(String name, boolean isBasicExercise) {
		super();
		this.name = name;
		this.isBasicExercise = isBasicExercise;
	}

	public Exercise(String name, boolean isBasicExercise, MuscleGroup muscleGroup) {
		super();
		this.name = name;
		this.isBasicExercise = isBasicExercise;
		this.muscleGroup = muscleGroup;
	}

	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public MuscleGroup getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(MuscleGroup muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public boolean isBasicExercise() {
		return isBasicExercise;
	}

	public void setBasicExercise(boolean isBasicExercise) {
		this.isBasicExercise = isBasicExercise;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
