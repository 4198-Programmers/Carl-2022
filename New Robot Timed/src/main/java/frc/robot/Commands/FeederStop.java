package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.FeederSub;

public class FeederStop extends CommandBase{
    FeederSub feederSub;
    boolean youdone;
    public FeederStop(FeederSub feederSub){
        this.feederSub = feederSub;
        addRequirements(feederSub);
    }
    @Override
    public void initialize() {
        youdone = false;
    }
    @Override
    public void execute() {
        feederSub.takeIn(0);
        youdone = true;
    }
    @Override
    public boolean isFinished() {
        return(youdone == true);
    }
}