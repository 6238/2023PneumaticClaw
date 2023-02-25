// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawSubsystem extends SubsystemBase {
  Joystick joystick = new Joystick(0);
  CANSparkMax telescope = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax pulley = new CANSparkMax(1, MotorType.kBrushless);
  public ClawSubsystem() {
    // telescope.setInverted(true);
  }

  public void extendTelescope() {
    telescope.setVoltage(0.5);
  }
  public void retractTelescope() {
    telescope.setVoltage(-0.5);
  }
  public void extendPulley() {
    pulley.setVoltage(0.5);
  }
  public void retractPulley() {
    pulley.setVoltage(-0.5);
  }
  public void stopClaw() {
    telescope.setVoltage(0.0);
    pulley.setVoltage(0.0);
  }
  
}
