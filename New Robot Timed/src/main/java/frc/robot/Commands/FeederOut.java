package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.FeederSub;

public class FeederOut extends CommandBase{
    FeederSub feederSub;
    public FeederOut(FeederSub feederSub){
        this.feederSub = feederSub;
        addRequirements(feederSub);
    }
    @Override
    public void execute() {
        feederSub.takeIn(-(Constants.FEEDER_INTAKE_SPEED));
    }
    
}
