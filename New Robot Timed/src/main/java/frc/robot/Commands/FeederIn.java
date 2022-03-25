package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.FeederSub;

public class FeederIn extends CommandBase{
    FeederSub feederSub;
    public FeederIn(FeederSub feederSub){
        this.feederSub = feederSub;
        addRequirements(feederSub);
    }
    @Override
    public void execute() {
        feederSub.intake(Constants.FEEDER_INTAKE_SPEED);
    }
    
}