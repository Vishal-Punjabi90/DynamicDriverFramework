import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import PackageCommonFunction.Utilitycommonfunction;

//import TestClassPackage.PostTC1;

public class DriverClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {


		
		ArrayList<String> testCaseRun=Utilitycommonfunction.readdataexcel("Test_runner","Testcasenametoexecute");
		int count=testCaseRun.size();
		System.out.println(count);
		for (int i=1; i<count;i++)
		{
			String testCaseName=testCaseRun.get(i);
			
			Class<?> testClassName=Class.forName("PackageTestClass."+testCaseName);
			
			Method executeMethod = testClassName.getDeclaredMethod("execute");
			
			executeMethod.setAccessible(true);
			
			Object instanceOfTestClass=testClassName.getDeclaredConstructor().newInstance();
			executeMethod.invoke(instanceOfTestClass);
	}
	}
}
