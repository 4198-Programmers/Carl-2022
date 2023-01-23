package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PincherMotor extends SubsystemBase {

    private CANSparkMax pincherMotor = new CANSparkMax(Constants.PINCHER_MOTOR_ID, MotorType.kBrushless);

    public PincherMotor() {

        pincherMotor.setOpenLoopRampRate(0.1);

    }

    public void pincherMotorActivate(double speed) {
        pincherMotor.set(speed);
    }

}
