package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.FeederSub;
import frc.robot.Subsystems.Sensors;

public class WaitForBallToEnterIntake extends CommandBase{
    FeederSub feederSub;
    Sensors sensors;
    public WaitForBallToEnterIntake(FeederSub feederSub, Sensors sensors){
        this.sensors = sensors;
        this.feederSub = feederSub;
        addRequirements(feederSub);
    }
    @Override
    public boolean isFinished() {
        return(sensors.isBallInFeed());
    }
    @Override
    public void end(boolean interrupted) {
        feederSub.intake(0);
    }
}
