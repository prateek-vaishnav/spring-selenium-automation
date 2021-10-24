package com.prateekv.testing.springseleniumautomation.window;

import com.prateekv.testing.springseleniumautomation.SpringBaseTestNGTest;
import com.prateekv.testing.springseleniumautomation.kelvin.service.WindowSwitchService;
import com.prateekv.testing.springseleniumautomation.page.window.MainPage;
import com.prateekv.testing.springseleniumautomation.page.window.PageA;
import com.prateekv.testing.springseleniumautomation.page.window.PageB;
import com.prateekv.testing.springseleniumautomation.page.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WindowSwitchTest extends SpringBaseTestNGTest {

	@Autowired
	private MainPage mainPage;

	@Autowired
	private PageA pageA;

	@Autowired
	private PageB pageB;

	@Autowired
	private PageC pageC;

	@BeforeClass
	public void setup(){
		this.mainPage.goTo();
		this.mainPage.isAt();
		this.mainPage.launchAllWindows();
	}

	@Test(dataProvider = "getData")
	public void windowSwitchTest(int index){
		this.pageA.addToArea(index + "\n");
		this.pageB.addToArea((index *2) +"\n");
		this.pageC.addToArea((index* 3) +"\n");
	}

	@DataProvider
	public Object[] getData(){
		return new Object[]{
				3,
				4,
				1,
				5,
				6,
				2
		};
	}
}
