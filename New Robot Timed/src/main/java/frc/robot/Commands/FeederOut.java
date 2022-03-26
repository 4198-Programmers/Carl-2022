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
        if(sensors.isBallInFeed()){
            feederSub.intake(-(Constants.FEEDER_INTAKE_SPEED));
        }
        else{
            feederSub.intake(0);
        }
    }
    @Override
    public boolean isFinished() {
        return !sensors.isBallInFeed();
    }
}
