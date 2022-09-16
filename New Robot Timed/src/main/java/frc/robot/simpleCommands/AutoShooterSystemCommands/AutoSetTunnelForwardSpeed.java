package frc.robot.simpleCommands.AutoShooterSystemCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Sensors;
import frc.robot.subsystems.Tunnel;

public class AutoSetTunnelForwardSpeed extends CommandBase{
    Tunnel tunnel;
    Sensors sensors;
    public AutoSetTunnelForwardSpeed(Tunnel tunnel){
        this.tunnel = tunnel;
        addRequirements(tunnel);
    }
    @Override
    public void execute() {
        tunnel.setTunnelSpeed(Constants.INTERNAL_FEEDER_SPEED);
    }
    @Override
    public boolean isFinished() {
        return sensors.hasoutSensorSeenBall();
    }
    @Override
    public void end(boolean interrupted) {
        sensors.forgetOuttakeBall();
        tunnel.setTunnelSpeed(Constants.FREEZE);
    }
}