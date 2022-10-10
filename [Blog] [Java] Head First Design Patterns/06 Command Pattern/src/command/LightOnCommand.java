package command;

public class LightOnCommand implements Command {
	Light light;

	// execute() 메소드가 호출되면 light 객체가 바로 그 요청에 대한 리시버(receiver)가 됨
	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}
	
	@Override
	public void undo() {
		light.off();
	}

}
