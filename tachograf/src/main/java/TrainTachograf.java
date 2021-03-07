import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.List;

public class TrainTachograf {

    List<String> lista = Lists.newArrayList(); // guava szintaxis

    public void save(String date, Integer referenceSpeed, Integer Joystickposition) {
        lista.add(date);
        lista.add(referenceSpeed.toString());
        lista.add(Joystickposition.toString());
    }

}
