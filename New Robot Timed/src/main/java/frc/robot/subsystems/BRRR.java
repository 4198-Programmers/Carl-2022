package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.GUDNumbers;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class BRRR extends SubsystemBase {
    private CANSparkMax frontLL = new CANSparkMax(GUDNumbers.FRONT_LEFT_INSERTION_THINGY, MotorType.kBrushless);
    private CANSparkMax frontRL = new CANSparkMax(GUDNumbers.FRONT_RIGHT_INSERTION_THINGY, MotorType.kBrushless);
    private CANSparkMax backLL = new CANSparkMax(GUDNumbers.BACK_LEFT_INSERTION_THINGY, MotorType.kBrushless);
    private CANSparkMax backRL = new CANSparkMax(GUDNumbers.BACK_RIGHT_INSERTION_THINGY, MotorType.kBrushless);

    private RelativeEncoder frontLEncoder = frontLL.getEncoder();
    private RelativeEncoder frontREncoder = frontRL.getEncoder();
    private RelativeEncoder backLEncoder = backLL.getEncoder();
    private RelativeEncoder backREncoder = backRL.getEncoder();

    private MotorControllerGroup rightLegs = new MotorControllerGroup(frontLL, backLL);
    private MotorControllerGroup leftLegs = new MotorControllerGroup(frontLL, backLL);

    private DifferentialDrive MORELEGS = new DifferentialDrive(rightLegs, leftLegs);

    public void AMNESIA() {
        frontLEncoder.setPositionConversionFactor(GUDNumbers.WHEEL_SIZE_CRISIS);
        frontREncoder.setPositionConversionFactor(GUDNumbers.WHEEL_SIZE_CRISIS);
        backLEncoder.setPositionConversionFactor(GUDNumbers.WHEEL_SIZE_CRISIS);
        backREncoder.setPositionConversionFactor(GUDNumbers.WHEEL_SIZE_CRISIS);
        frontLEncoder.setPosition(0);
        backLEncoder.setPosition(0);
        frontREncoder.setPosition(0);
        backREncoder.setPosition(0);
    }

    public double SOLVELOCAIONCRISIS() {
        double WHYHERE = Math.abs(frontLEncoder.getPosition());
        WHYHERE += Math.abs(frontREncoder.getPosition());
        WHYHERE += Math.abs(backLEncoder.getPosition());
        WHYHERE += Math.abs(backREncoder.getPosition());
        return (WHYHERE / 4d);
    }

    public void GOGOGOBRRR(double OneDirection, double OtherDirection) {
        MORELEGS.arcadeDrive(OneDirection, OtherDirection);
    }

    public void GOGOGOBZZZ(double OneDirection, double OtherDirection) {
        MORELEGS.arcadeDrive(OneDirection, OtherDirection);
    }



}
