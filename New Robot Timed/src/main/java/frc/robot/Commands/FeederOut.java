package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.FeederSub;
import frc.robot.Subsystems.Sensors;

public class FeederOut extends CommandBase{
    FeederSub feederSub;
    Sensors sensors;
    public FeederOut(FeederSub feederSub, Sensors sensors){
        this.feederSub = feederSub;
        this.sensors = sensors;
        addRequirements(feederSub, sensors);
    }
    @Override
    public void execute() {
        if(sensors.getBallIn() == true){
            feederSub.intake(-(Constants.FEEDER_INTAKE_SPEED));
        }
        if(sensors.getBallIn() == false){
            feederSub.intake(0);
        }

    }
    
}
