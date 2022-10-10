package test;

import command.CeilingFan;
import command.CeilingFanMediumCommand;
import command.CeilingFanOffCommand;
import command.Command;
import command.GarageDoor;
import command.GarageDoorDownCommand;
import command.GarageDoorUpCommand;
import command.Light;
import command.LightOffCommand;
import command.LightOnCommand;
import command.MacroCommand;
import command.Stereo;
import command.StereoOffCommand;
import command.StereoOnWithCDCommand;
import remoteControl.RemoteControl;

public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();

		// 장치 설치
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("Garage");
		Stereo stereo = new Stereo("Living Room");

		// 전등용 커맨드 객체
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

		// 선풍기 커맨드 객체
		CeilingFanMediumCommand ceilingFanOn = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		// 문 커맨드 객체
		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

		// 사운드 커맨드 객체
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		// 매크로 커맨드 객체
		Command[] partyOn = { livingRoomLightOn, ceilingFanOn, garageDoorUp, stereoOnWithCD};
		Command[] partyOff = { livingRoomLightOff, ceilingFanOff, garageDoorDown, stereoOff};
		
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
		
		remoteControl.setCommand(6, partyOnMacro, partyOffMacro);
		
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
		remoteControl.setCommand(3, stereoOnWithCD, stereoOff);

		System.out.println(remoteControl);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
			
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
				
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		
		System.out.println(remoteControl);
		
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(6);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(6);
	}
}
