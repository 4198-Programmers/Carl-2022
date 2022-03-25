package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.TunnelSub;

public class TunnelStop extends CommandBase{
    TunnelSub tunnelSub;
    boolean youdone;
    public TunnelStop(TunnelSub tunnelSub){
        this.tunnelSub = tunnelSub;
        addRequirements(tunnelSub);
    }
    @Override
    public void initialize() {
        youdone = false;
    }
    @Override
    public void execute() {
        tunnelSub.tunnelSpeed(0);
        youdone = true;
    }
    @Override
    public boolean isFinished() {
        return(youdone == true);
    }
}
