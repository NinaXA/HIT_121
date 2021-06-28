package classwork;

public class UniversalRemote {
public static void main(String[] args){
	System.out.println("Demonstration of Remote...");
	Tv tv=new Tv();
	SetTopBox setTopBox=new SetTopBox();
	NetFlix netFlix=new NetFlix();
	SoundSystem soundSystem=new SoundSystem();
	FatherNewsChannelCommand fncc=new FatherNewsChannelCommand(tv,setTopBox,soundSystem,netFlix);
	MotherSerialCommand msc=new MotherSerialCommand(tv,setTopBox,soundSystem,netFlix);
	MotherOldMovieCommand momc=new MotherOldMovieCommand(tv,setTopBox,soundSystem,netFlix);
	Remote universalRemote=new Remote();
	universalRemote.executeCommand(1);
	universalRemote.setCommand(fncc,0);
	universalRemote.setCommand(momc,1);
	universalRemote.setCommand(msc,2);
	System.out.println("My Father wants to see news channel...");
	universalRemote.executeCommand(0);
	
	
}
}
class Tv{
	public void av1() {
		System.out.println("Tv switched to av1 mode...");
	}
	public void switchOn() {
		System.out.println("Tv switched ON....");
	}
}

class SetTopBox{
	public void newsChannel() {
		System.out.println("NEWS channel displayed...");
	}
	public void serialChannel() {
		System.out.println("Serial channel displayed...");
	}
}
class NetFlix{
	public void movieOld() {
		System.out.println("Old movie started...");
	}
}
class SoundSystem{
	public void lowSound() {
		System.out.println("Volume decreased...");
	}
}

interface Command{
	public void execute();
}
class FatherNewsChannelCommand implements Command{
	Tv tv;SetTopBox setTopBox;SoundSystem soundSystem;NetFlix netFlix;
	public FatherNewsChannelCommand(Tv tv,SetTopBox setTopBox,SoundSystem soundSystem,NetFlix netFlix) {
		this.tv=tv;
		this.setTopBox=setTopBox;
		this.soundSystem=soundSystem;
		this.netFlix=netFlix;
	}
	@Override
	public void execute() {
		System.out.println("Father Tv action started...");
		tv.switchOn();
		tv.av1();
		setTopBox.newsChannel();
		soundSystem.lowSound();
		System.out.println("Dad enjoy watching your NEWS chnnel...");
		
		
	}
	
	
}
class MotherOldMovieCommand implements Command{
	Tv tv;SetTopBox setTopBox;SoundSystem soundSystem;NetFlix netFlix;
	public MotherOldMovieCommand(Tv tv,SetTopBox setTopBox,SoundSystem soundSystem,NetFlix netFlix) {
		this.tv=tv;
		this.setTopBox=setTopBox;
		this.soundSystem=soundSystem;
		this.netFlix=netFlix;
	}
	@Override
	public void execute() {
		System.out.println("Mother old movie command started...");
		tv.switchOn();
		tv.av1();
		setTopBox.newsChannel();
		soundSystem.lowSound();
		System.out.println("Mom enjoy watching your old movie channel...");
		
	}
	
	
}

class MotherSerialCommand implements Command{
	Tv tv;SetTopBox setTopBox;SoundSystem soundSystem;NetFlix netFlix;
	public MotherSerialCommand(Tv tv,SetTopBox setTopBox,SoundSystem soundSystem,NetFlix netFlix) {
		this.tv=tv;
		this.setTopBox=setTopBox;
		this.soundSystem=soundSystem;
		this.netFlix=netFlix;
	}
	@Override
	public void execute() {
		System.out.println("Mother serial command started...");
		tv.switchOn();
		tv.av1();
		setTopBox.serialChannel();
		System.out.println("Mom enjoy watching your serial channel...");
		
	}
	
	
}
class DummyCommand implements Command{
	@Override
	public void execute() {
		System.out.println("I am a dummy button...");
		
	}
}
class Remote{
	Command command[]=new Command[5];
	public Remote() {
		for(int i=0;i<command.length;i++) {
			command[i]=new DummyCommand();
		}
	}
	public void setCommand(Command command,int slot) {
		this.command[slot]=command;
	}
	public void executeCommand(int slot) {
		command[slot].execute();
	}
}


