/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {

  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick; 
  private static Joystick stick;
  private static int leftfrontDeviceID = 1;
  private static int leftrearDeviceID = 2;
  private static int rightfrontDeviceID = 3;
  private static int rightrearDeviceID = 4;

  private CANSparkMax leftrearmotor;
  private CANSparkMax leftfrontmotor;
  private CANSparkMax rightrearmotor;
  private CANSparkMax rightfrontmotor;
  
  static double rightside;
  static double leftside;

  @Override
  public void robotInit() {
      
    leftrearmotor = new CANSparkMax(leftrearDeviceID, MotorType.kBrushless);
    leftfrontmotor = new CANSparkMax(leftfrontDeviceID, MotorType.kBrushless);
    rightfrontmotor = new CANSparkMax(rightrearDeviceID, MotorType.kBrushless);
    rightrearmotor = new CANSparkMax(rightfrontDeviceID, MotorType.kBrushless);

    //protected double m_maxOutput;

    //rightside = new (rightfrontmotor, rightrearmotor); 
    
    m_myRobot = new DifferentialDrive(leftfrontmotor, rightfrontmotor);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
    
 
    Joystick stick;
    Joystick driveStick = new Joystick(0);
    
    //m_myRobot.arcadeDrive(, );
    
    
  }
  @Override
  public void teleopPeriodic() {
    
    //m_myRobot.arcadeDrive(stick.geRawAxisY(1), stick.getRawAxis(5));
    leftrearmotor.setInverted(true);
    leftfrontmotor.setInverted(true);
    m_myRobot.arcadeDrive(stick.getRawAxis(0),stick.getRawAxis(1));
    //If one were to use a different controller other than an Xbox One Elite Controller, they might have to change the (x,y) values for the getRawAxis(); value(s).
    /*
    if (stick.getRawButton(1)) {
        System.out.println("'1' button is pressed: Piston moves forward");
    } else if (stick.getRawButton(2)) {
        System.out.println("'2' button is pressed: Piston moves backward");
    */
  }
  public void AutonomousPeriodic() {

  }
}