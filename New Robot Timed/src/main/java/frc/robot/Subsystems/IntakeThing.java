package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class IntakeThing extends SubsystemBase {

    private CANSparkMax intake = new CANSparkMax(Constants.INTAKE_MOTOR_ID, MotorType.kBrushless);

    public void intakeSpeed(double speed){

        intake.set(speed);

    }

    public double getIntakeSpeed(){

        System.out.println("Intake Speed:" + intake.get());
        return(intake.get());

    }
    
}
