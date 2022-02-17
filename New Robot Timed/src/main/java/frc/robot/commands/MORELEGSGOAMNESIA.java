package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BRRR;

public class MORELEGSGOAMNESIA extends CommandBase {
  private final BRRR ZOOMYGOAMNESIA;
  private boolean ENDIT;

  public MORELEGSGOAMNESIA(BRRR zoomy) {
    ZOOMYGOAMNESIA = zoomy;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(zoomy);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    ZOOMYGOAMNESIA.AMNESIA();
    ENDIT = true;
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return ENDIT;
  }
}
