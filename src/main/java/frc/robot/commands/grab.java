package frc.robot.command;

public class grab extends SubsystemBase 
{
    CANSparkMax Bottom = new CANSparkMax(Constants.BOTTOM_ID, MotorType.kBrushless);
    CANSparkMax Leg = new CANSparkMax(Constants.LEG_ID, MotorType.kBrushless);
    CANSparkMax Arm = new CANSparkMax(Constants.ARM_ID, MotorType.kBrushless);
    CANSparkMax Hand = new CANSparkMax(Constants.HAND_ID, MotorType.kBrushless);

    private RelativeEncoder encoderBottom = Bottom.getEncoder();
    private RelativeEncoder encoderLeg = Leg.getEncoder();
    private RelativeEncoder encoderArm = Arm.Encoder();
    private RelativeEncoder encoderHand = Hand.encoder();
}

public grab(){
    encoderBottom.setPositionConversionFactor(constants.CONVERSION);
    encoderLeg.setPositionConversionFactor(constants.CONVERSION);
    encoderArm.setPositionConversionFactor(constants.CONVERSION);
    encoderHand.setPositionConversionFactor(constants.CONVERSION);

}

public void resetposition(){}

