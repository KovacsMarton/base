package hu.bme.mit.train.sensor;

//import com.google.common.collect.HashBasedTable;
//import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {
	//Table<String, String, Integer> universityCourseSeatTable
			//= HashBasedTable.create();
	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}




	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);

		if(speedLimit > 500 || speedLimit < 0 || speedLimit < 0.5 * controller.getReferenceSpeed())
			this.user.setAlarmState(true);
	}

}
