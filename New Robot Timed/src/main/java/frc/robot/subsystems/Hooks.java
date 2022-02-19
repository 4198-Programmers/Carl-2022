package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hooks extends SubsystemBase{
    private CANSparkMax vertHookRight = new CANSparkMax(Constants.VERT_RIGHT_HOOK, MotorType.kBrushless);
    private CANSparkMax vertHookLeft = new CANSparkMax(Constants.VERT_LEFT_HOOK, MotorType.kBrushless);
    private CANSparkMax angledHookRight = new CANSparkMax(Constants.ANGLED_RIGHT_HOOK, MotorType.kBrushless);
    private CANSparkMax angledHookLeft = new CANSparkMax(Constants.ANGLED_LEFT_HOOK, MotorType.kBrushless);
    private RelativeEncoder vertHookRightEnc = vertHookRight.getEncoder();
    private RelativeEncoder vertHookLeftEnc = vertHookLeft.getEncoder();
    private RelativeEncoder angledHookRightEnc = angledHookRight.getEncoder();
    private RelativeEncoder angledHookLeftEnc = angledHookLeft.getEncoder();
    public Hooks(){
        double conversionFactor = 1/Constants.WHEEL_CONVERSION_FACTOR;
        vertHookRightEnc.setPosition(conversionFactor);
        vertHookLeftEnc.setPosition(conversionFactor);
        angledHookRightEnc.setPosition(conversionFactor);
        angledHookLeftEnc.setPosition(conversionFactor);
    }
    public void resetPositionHooks(){
        vertHookRightEnc.setPosition(0d);
        vertHookLeftEnc.setPosition(0d);
        angledHookRightEnc.setPosition(0d);
        angledHookLeftEnc.setPosition(0d);
    }
    public double currentPositionVertHooks(){
        double hookEncCurrentPosition = vertHookRightEnc.getPosition();
        hookEncCurrentPosition += vertHookLeftEnc.getPosition();
        return hookEncCurrentPosition/2d;
    }
    public double currentPositionAngledHooks(){
        double hookEncCurrentPosition = angledHookRightEnc.getPosition();
        hookEncCurrentPosition += angledHookLeftEnc.getPosition();
        return hookEncCurrentPosition/2d;
    }
    MotorControllerGroup vertHook = new MotorControllerGroup(vertHookRight, vertHookLeft);
    MotorControllerGroup angledHook = new MotorControllerGroup(angledHookRight, angledHookLeft);
    public void vertHookExtend(double vert){
        vertHook.set(vert);
    }
    public void angledHookMove(double angled){
        angledHook.set(angled);
    }
}
