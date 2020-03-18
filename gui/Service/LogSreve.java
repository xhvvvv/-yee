package Service;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class LogSreve {
	public LogSreve() {
	try(PrintStream Logtxt=new PrintStream("./log.txt")){
	}catch(FileNotFoundException e){
	e.printStackTrace();
	}
	}
}
