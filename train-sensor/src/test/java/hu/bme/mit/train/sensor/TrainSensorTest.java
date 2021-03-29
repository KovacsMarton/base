package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockController;
    TrainUser mockUser;
    TrainSensor sensor;

    @Before
    public void before()  {
         mockUser = mock(TrainUser.class);
         mockController = mock(TrainController.class);
         sensor = new TrainSensorImpl(mockController,mockUser);

    }

    @Test
    public void AlarmTooHigh() {
        // TODO Delete this and add test cases based on the issues
        sensor.overrideSpeedLimit(1000);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void AlarmTooLow() {
        // TODO Delete this and add test cases based on the issues
        sensor.overrideSpeedLimit(-50);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void Interval() {

        sensor.overrideSpeedLimit(0);
        sensor.overrideSpeedLimit(500);
        verify(mockUser, times(0)).setAlarmState(true);
    }

    @Test
    public void LimitIncrease() {
        sensor.overrideSpeedLimit(120);
        verify(mockUser, times(0)).setAlarmState(true);
    }



}
