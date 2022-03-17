package frc.robot.simplecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngleHooks;
import frc.robot.subsystems.VertHooks;

public class StableHooks extends CommandBase{
    VertHooks grabbersSH;
    AngleHooks angleHooks;

    public StableHooks(VertHooks hookArg, AngleHooks angleHookArg){
        grabbersSH = hookArg;
        angleHooks = angleHookArg;
        addRequirements(grabbersSH, angleHookArg);
    }

    @Override
    public void execute() {
        angleHooks.moveAngledHooks(0);
        grabbersSH.moveVertHooks(0);
    }
}