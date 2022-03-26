package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.FeederSub;
import frc.robot.Subsystems.Sensors;

public class FeederIn extends CommandBase{
    FeederSub feederSub;
    Sensors sensors;
    public FeederIn(FeederSub feederSub, Sensors sensors){
        this.feederSub = feederSub;
        this.sensors = sensors;
        addRequirements(feederSub, sensors);
    }
    @Override
    public void execute() {
        if(sensors.getBallIn() == false){
        feederSub.intake(Constants.FEEDER_INTAKE_SPEED);
        }
        else if(sensors.getBallIn() == true){
            feederSub.intake(0);
        }
    }
    
}
