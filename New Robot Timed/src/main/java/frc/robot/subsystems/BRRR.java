package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Joystick;

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
        frontLEncoder.setPosition(0);
        backLEncoder.setPosition(0);
        frontREncoder.setPosition(0);
        backREncoder.setPosition(0);
    }

    public double LOCAIONCRISIS() {
        double WHYHERE = Math.abs(frontLEncoder.getPosition()); 
        WHYHERE += Math.abs(frontREncoder.getPosition());
        WHYHERE += Math.abs(backLEncoder.getPosition());
        WHYHERE += Math.abs(backREncoder.getPosition());
        return WHYHERE / (4d * GUDNumbers.WHEEL_SIZE_CRISIS);
    }

    public void GOGOGOBRRR(double OneDirection, double OtherDirection) {
        MORELEGS.arcadeDrive(GUDNumbers.WHEEL_GO_ZOOM * OneDirection, GUDNumbers.WHEEL_GO_ZOOM * OtherDirection);
    }
    public void GOGOGOBZZZ(double OneDirection, double OtherDirection) {
        MORELEGS.arcadeDrive(GUDNumbers.WHEEL_GO_ZOOM_ZOOM * OneDirection, GUDNumbers.WHEEL_GO_ZOOM_ZOOM * OtherDirection);
    }


}
