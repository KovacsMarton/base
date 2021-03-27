package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

import java.util.concurrent.TimeUnit;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;


	private int speedLimit = 0;
	private int TIME_IN_SECONDS = 1;

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public int getSpeedLimit(){return this.speedLimit;}
	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) throws InterruptedException {
		this.step = joystickPosition;
/*
if(referenceSpeed < speedLimit){
		while(referenceSpeed != speedLimit){
			if(referenceSpeed == speedLimit)
				break;
			followSpeed();
			Thread.sleep(TIME_IN_SECONDS*1000);
		}}
*/

	}

}
