package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.FeederSub;

public class Feeder extends CommandBase{
    FeederSub feederSub;
    public Feeder(FeederSub feederSub)){
        this.feederSub = feederSub;
        addRequirements(feederSub);
    }
    
}
