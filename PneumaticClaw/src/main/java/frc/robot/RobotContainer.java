// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.ClawSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Joystick joystick = new Joystick(0);
  private final ClawSubsystem claw = new ClawSubsystem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(joystick, 5).whileTrue(Commands.run(() -> claw.extendTelescope(), claw)).whileFalse(Commands.run(()->claw.stopClaw(), claw));;
    new JoystickButton(joystick, 3).whileTrue(Commands.run(() -> claw.retractTelescope(), claw)).whileFalse(Commands.run(()->claw.stopClaw(), claw));;
    new JoystickButton(joystick, 6).whileTrue(Commands.run(() -> claw.extendPulley(), claw)).whileFalse(Commands.run(()->claw.stopClaw(), claw));;
    new JoystickButton(joystick, 4).whileTrue(Commands.run(() -> claw.retractPulley(), claw)).whileFalse(Commands.run(()->claw.stopClaw(), claw));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
