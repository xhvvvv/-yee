package Log;
import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import Bootstrap.Bootstrap;
import Util.CreatFile;
 
public class Log4j {
	static Logger logger = Logger.getLogger(Bootstrap.class);
    public Log4j ()throws InterruptedException {
    	File file =new File("D:\\confine\\log.txt");
    	boolean consequence=CreatFile.createFile(file);
    	if(consequence) {
	    	String a=file.getAbsolutePath();
	        PropertyConfigurator.configure(a);
	        for (int i = 0; i < 5000; i++) {
	            logger.trace("跟踪信息");
	            logger.debug("调试信息");
	            logger.info("输出信息");
	            logger.warn("警告信息");
	            logger.error("错误信息");
	            logger.fatal("致命信息");
	            Thread.sleep(1000);
	        }
    	}
    }
}