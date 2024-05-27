package MavenPakage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPExp {

	Object[][] data;
	@DataProvider(name="data")
	public Object[][] dp()
	{
		data=new Object[3][2];
		data[0][0]="tani";
		data[0][1]="tani111";
		
		data[1][0]="pooja";
		data[1][1]="pooja123";
		
		data[2][0]="priya";
		data[2][1]="priya111";
		return data;
	}
	@Test(dataProvider = "data")
	public void login(String un,String pwd)
	{
		System.out.println(un+"\t"+pwd);
		
	}
}
