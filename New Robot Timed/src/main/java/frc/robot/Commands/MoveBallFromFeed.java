package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Sensors;
import frc.robot.Subsystems.TunnelSub;

public class MoveBallFromFeed extends CommandBase{
    TunnelSub tunnelSub;
    Sensors sensors;
    public MoveBallFromFeed(TunnelSub tunnelSub){
        this.tunnelSub = tunnelSub;
        addRequirements(tunnelSub);
    }
    @Override
    public void execute() {
        if(sensors.isBallInFeed()){
            tunnelSub.setSpeed(Constants.TUNNEL_SPEED);
        }
        else {
            tunnelSub.setSpeed(0);
        }
    }
    @Override
    public boolean isFinished() {
        return(!sensors.isBallInFeed());
    }
}
