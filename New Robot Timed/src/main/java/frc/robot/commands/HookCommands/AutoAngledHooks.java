package frc.robot.commands.HookCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hooks.AngledHooks;

public class AutoAngledHooks extends CommandBase{
    AngledHooks angledHooks;
    double speed;
    double distance;
    public AutoAngledHooks(AngledHooks angledHooks, double speed, double distance){
        this.angledHooks = angledHooks;
        this.speed = speed;
        this.distance = distance;
        addRequirements(angledHooks);
    }
    @Override
    public void execute() {
        angledHooks.setSpeed(speed);
    }
    @Override
    public boolean isFinished() {
        return angledHooks.getPosition() >= distance;
    }
    @Override
    public void end(boolean interrupted) {
        angledHooks.setSpeed(0);
    }
}
