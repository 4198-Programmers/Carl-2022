package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensors extends SubsystemBase{
    DigitalInput intakeSensor = new DigitalInput(0);
    DigitalInput flyWheelSensor =  new DigitalInput(1);

    public boolean intakeSensorSeesBall(){
        return();
    }
}
