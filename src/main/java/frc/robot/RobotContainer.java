// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.HopperClose;
import frc.robot.commands.ControlDrive;
import frc.robot.commands.ControlExtend;
import frc.robot.commands.ControlIntake;
import frc.robot.commands.ControlPivotOne;
import frc.robot.commands.ControlPivotTwo;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GrabPositionTeleop;
import frc.robot.commands.GroundJunctionTeleop;
import frc.robot.commands.GrabPositionTeleop;
import frc.robot.commands.ConeHighJunctionTeleop;
import frc.robot.commands.HomePositionTeleop;
import frc.robot.commands.HopperGrabCone;
import frc.robot.commands.MiddleJunctionTeleop;
import frc.robot.commands.OmniIn;
import frc.robot.commands.OmniOut;
import frc.robot.commands.ClawOpen;
import frc.robot.commands.HopperOpen;
import frc.robot.commands.IntakeCube;
import frc.robot.commands.ClawClose;
import frc.robot.commands.CubeHighJunctionTeleop;
import frc.robot.commands.HopperGrabCone;
import frc.robot.commands.HopperGrabCube;
import frc.robot.commands.Autos.*;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Slidingomi;
import frc.robot.subsystems.pneumatics;
import frc.robot.subsystems.ArmExtend;
import frc.robot.subsystems.ArmPivotOne;
import frc.robot.subsystems.ArmPivotTwo;
import frc.robot.subsystems.Claw;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static DriveTrain drive = new DriveTrain();
  public static ArmExtend extend = new ArmExtend();
  public static ArmPivotOne pivotOne = new ArmPivotOne();
  public static ArmPivotTwo pivotTwo = new ArmPivotTwo();
  public static Intake intake = new Intake();
  public static Gyro gyro= new Gyro();
  public static pneumatics comp = new pneumatics();
  public static Claw claw = new Claw();
  public static Hopper hopper = new Hopper();
  public static Slidingomi omni = new Slidingomi();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(Constants.kDriverControllerPort);

  public static XboxController driveController = new XboxController(Constants.XBOX_CONTROLLER_PORT_0);
  public static XboxController OpController = new XboxController(Constants.XBOX_CONTROLLER_PORT_1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
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

    // WHERE TO PUT THE AUTOS TO BE SELECTED
    m_chooser.setDefaultOption("Cone High Auto", new Auto1_Cone_High_Junction());
    m_chooser.addOption("Ground Junction Over Lip ", new Auto3_Ground_Junction_Lip());
    m_chooser.addOption("Cube Middle Charge Station", new Auto2_Cube_Middle_Charge_station());
    m_chooser.addOption("Cube Middle Boogie", new Auto4_Cube_Middle_Boogie());


    SmartDashboard.putData("Auto Mode: ", m_chooser);

    drive.setDefaultCommand(new ControlDrive());
    pivotOne.setDefaultCommand(new ControlPivotOne());
    pivotTwo.setDefaultCommand(new ControlPivotTwo());
    intake.setDefaultCommand(new ControlIntake());
    extend.setDefaultCommand(new ControlExtend());
    
    JoystickButton DraButton = new JoystickButton(driveController, 1);
    JoystickButton DrbButton = new JoystickButton(driveController, 2);
    JoystickButton DrxButton = new JoystickButton(driveController, 3);
    JoystickButton DryButton = new JoystickButton(driveController, 4);
    JoystickButton DrLbumper = new JoystickButton(driveController, 5);
    JoystickButton DrRbumper = new JoystickButton(driveController, 6);
    

   
    JoystickButton OpaButton = new JoystickButton(OpController, 1);
    JoystickButton OpbButton = new JoystickButton(OpController, 2);
    JoystickButton OpxButton = new JoystickButton(OpController, 3);
    JoystickButton OpyButton = new JoystickButton(OpController, 4);
    JoystickButton OpLbumper = new JoystickButton(OpController, 5);
    JoystickButton OpRbumper = new JoystickButton(OpController, 6);
    JoystickButton OpbackButton = new JoystickButton(OpController, 7);
    JoystickButton OpstartButton = new JoystickButton(OpController, 8);
    JoystickButton OpleftjoyButton = new JoystickButton(OpController, 9);
    JoystickButton OprightjoyButton = new JoystickButton(OpController, 10);
    
    //Op Buttons
    OpaButton.onTrue(new GrabPositionTeleop()); 
    OpaButton.onFalse(new ControlPivotOne()); 
    OpbButton.onTrue(new CubeHighJunctionTeleop());
    OpbButton.onFalse(new ControlPivotOne());
    OpxButton.onTrue(new MiddleJunctionTeleop()); 
    OpxButton.onFalse(new ControlPivotOne());
    OpyButton.onTrue(new ConeHighJunctionTeleop()); 
    OpyButton.onFalse(new ControlPivotOne());
    OpleftjoyButton.onTrue(new GroundJunctionTeleop()); 
    OpleftjoyButton.onFalse(new ControlPivotOne());
    OprightjoyButton.onTrue(new HomePositionTeleop()); 
    OprightjoyButton.onFalse(new ControlPivotOne());
    OpbackButton.onTrue(new HopperGrabCube());
    OpbackButton.onFalse(new ControlPivotOne());
    OpstartButton.onTrue(new HopperGrabCone()); //////for testing
    OpstartButton.onFalse(new ControlPivotOne());

    OpLbumper.onTrue(new ClawOpen());
    OpRbumper.onTrue(new ClawClose());
    

    //driver buttons
    DraButton.toggleOnTrue(new AutoLevel());
    DraButton.toggleOnFalse(new ControlDrive());
    // DrbButton.toggleOnTrue(new Intakegrabposition());
    // DrbButton.toggleOnFalse(new ControlDrive());
    DrxButton.onTrue(new HopperOpen());
    DryButton.onTrue(new HopperClose());

    DrLbumper.onTrue(new OmniIn());
    DrRbumper.onTrue(new OmniOut());

    DrbButton.onTrue(new IntakeCube());
    DrbButton.onFalse(new ControlIntake());
  

    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_chooser.getSelected();
  }

public static double getLeftX(XboxController controller){
  if(controller.getLeftX()<0.1 && controller.getLeftX()>-0.1){
    return 0.0;
  }else{
    return controller.getLeftX();
  }
}

public static double getLeftY(XboxController controller){
  if(controller.getLeftY()<0.1 && controller.getLeftY()>-0.1){
    return 0.0;
  }else{
    return controller.getLeftY();
  }
}

public static double getRightX(XboxController controller){
  if(controller.getRightX()<0.1 && controller.getRightX()>-0.1){
    return 0.0;
  }else{
    return controller.getRightX();
  }
}

public static double getRightY(XboxController controller){
  if(controller.getRightY()<0.1 && controller.getRightY()>-0.1){
    return 0.0;
  }else{
    return controller.getRightY();
  }
  
}


}
