package frc.robot.hookcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleHooks;

public class ResetAngleHooks extends CommandBase{
    AngleHooks angleHooks;
    boolean done;

    public ResetAngleHooks(AngleHooks angleHooksSub){
        angleHooks = angleHooksSub;
        addRequirements(angleHooks);
    }

    @Override
    public void initialize() {
        done = false;
    }
    
    @Override
    public void execute() {
        angleHooks.resetAngleHooks();
        done = true;
    }

    @Override
    public boolean isFinished() {
        return done;
    }

}
