package aspects;

import java.io.FileWriter;
import java.io.IOException;

public aspect StorageAspect {
	pointcut mehtodLogger(): call(void com.Lab2.ServiceDB.*(..));
	
	void around(): mehtodLogger()
	{
		try(FileWriter fw = new FileWriter("story.txt",true))
		{
			Long start = System.nanoTime();
			proceed();
			Long total = System.nanoTime() - start;
			fw.write("Running time of the method "+ thisJoinPointStaticPart.getSignature().getName() +"() " + 
			total.toString()+" ns.\n");
		}
		catch(IOException ex)
		{
			proceed();
			System.out.println("Can't open log file");
		}
	}
}
