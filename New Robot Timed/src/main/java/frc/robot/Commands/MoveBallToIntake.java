package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.TunnelSub;

public class MoveBallToIntake extends CommandBase{
    TunnelSub tunnelSub;
    double speed;
    public MoveBallToIntake(TunnelSub tunnelSub, double speed){
        this.tunnelSub = tunnelSub;
        this.speed = speed;
        addRequirements(tunnelSub);
    }
    @Override
    public void execute() {
        tunnelSub.setSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        tunnelSub.setSpeed(0);
    }
}
