package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretArmMotor;

public class TurretArmDown extends CommandBase {

    private TurretArmMotor turretArmMotor;

    public TurretArmDown(TurretArmMotor turretArmMotor) {

        this.turretArmMotor = turretArmMotor;
        addRequirements(turretArmMotor);

    }

    @Override
    public void execute() {
        turretArmMotor.turretArmMotorActivate(-0.5);
    }

}