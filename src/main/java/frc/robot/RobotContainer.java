// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.JoystickDrive;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.drive.GyroIOPigeon2;
import frc.robot.subsystems.drive.ModuleIOSparkMax;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private Drive drive;
  private GyroIOPigeon2 gyroIO;
  private ModuleIOSparkMax fl;
  private ModuleIOSparkMax fr;
  private ModuleIOSparkMax bl;
  private ModuleIOSparkMax br;
  private JoystickDrive joystickDrive;
  private XboxController xboxController;
  public RobotContainer() {
    xboxController = new XboxController(0);
    gyroIO = new GyroIOPigeon2();
    fl = new ModuleIOSparkMax(1);
    fr = new ModuleIOSparkMax(2);
    bl = new ModuleIOSparkMax(3);
    br = new ModuleIOSparkMax(4);
    drive = new Drive(gyroIO,fl,fr,bl,br);
    joystickDrive = new JoystickDrive(drive,xboxController::getLeftY,xboxController::getLeftX,xboxController::getRightX);
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
