package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private int joystickMoveCount;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) throws InterruptedException {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
		joystickMoveCount++;
		//this.controller.followSpeed(); //  előző feladat része volt, kikommentezem



		if(joystickPosition > 0 ){
			while(controller.getReferenceSpeed() != controller.getSpeedLimit()){
				controller.followSpeed();
				Thread.sleep(1000);
			}
		}
		else if(joystickPosition  < 0){
			while(controller.getReferenceSpeed() != 0){
				controller.followSpeed();
				Thread.sleep(1000);
			}
		}



	}


	public int getJoystickMoveCount() {
		return joystickMoveCount;
	}


}
