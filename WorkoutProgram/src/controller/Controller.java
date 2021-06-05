package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.Exercise;
import model.PoolExercises;
import model.Program;

public class Controller {

	private PoolExercises poolExercises;
	private List<Exercise> selectedExercises;
	private Program program;
	private final static Logger LOGGER = Logger.getLogger(Controller.class);

	public Controller() {
		super();
		List<Exercise> selectedExercises = new ArrayList<Exercise>();
		this.selectedExercises = selectedExercises;

	}

	public void createProgram(String str) {
		Program program = new Program(str);
		for (int i = 0; i < selectedExercises.size(); i++) {
			program.getExercises().add(selectedExercises.get(i));
		}
		selectedExercises.clear();

		File file = new File("Programs.txt");
		try {
			ObjectInputStream ins = new ObjectInputStream(new FileInputStream(file));
			List<Program> programs = (ArrayList<Program>) ins.readObject();
			programs.add(program);
			ins.close();
		} catch (IOException e) {
			LOGGER.error("Проблемы с чтением в file" + e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Проблемы с чтением file" + e);
		}

		try {
			ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
			ous.writeObject(program);
			ous.close();
		} catch (IOException e) {
			LOGGER.error("Проблемы с записью в file" + e);
		}

		this.setProgram(program);

	}

	public PoolExercises getPoolExercises() {
		return poolExercises;
	}

	public void setPoolExercises(PoolExercises poolExercises) {
		this.poolExercises = poolExercises;
	}

	public List<Exercise> getSelectedExercises() {
		return selectedExercises;
	}

	public void setSelectedExercises(List<Exercise> selectedExercises) {
		this.selectedExercises = selectedExercises;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

}
