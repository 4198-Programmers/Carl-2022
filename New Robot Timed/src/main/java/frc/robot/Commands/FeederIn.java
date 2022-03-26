package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.FeederSub;
import frc.robot.Subsystems.Sensors;

public class FeederIn extends CommandBase{
    FeederSub feederSub;
    Sensors sensors;
    public FeederIn(FeederSub feederSub){
        this.feederSub = feederSub;
        addRequirements(feederSub);
    }
    @Override
    public void execute() {
        if(!sensors.isBallInFeed()){
        feederSub.intake(Constants.FEEDER_INTAKE_SPEED);
        }
        else{
            feederSub.intake(0);
        }
    }
    @Override
    public boolean isFinished() {
        return(sensors.isBallInFeed());
    }
    
}
