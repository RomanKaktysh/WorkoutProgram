package main;

import controller.Controller;
import model.PoolExercises;
import view.AppFrame;

public class Runner {

	public static void main(String[] args) {

		Controller controller = new Controller();
		PoolExercises poolExercises = new PoolExercises();
		poolExercises.createExercises();
		controller.setPoolExercises(poolExercises);
		AppFrame frame = new AppFrame("Workout Program");
		frame.createFrame(controller);
		frame.setVisible(true);

	}

}
