import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://www.maybank2u.com.my/')
WebUI.delay(5)


WebDriver driver = DriverFactory.getWebDriver()

if(WebUI.waitForElementPresent(link_Personal, 5)) {
	WebUI.click(link_Personal)

}else if(WebUI.waitForElementPresent(link_personal2, 5)) {
	WebUI.click(link_personal2)

}else {
	KeywordUtil.logInfo("Personal link is not present in specified time")
}

if(WebUI.waitForElementPresent(link_Business, 10)) {

	String xpath_business = findTestObject('Object Repository/OR_HomePage/link_Business').findPropertyValue('xpath').toString()
	WebElement btn_business = driver.findElement(By.xpath(xpath_business))
	JavascriptExecutor js=(JavascriptExecutor) driver;
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_business);
	WebUI.back()
}else if(WebUI.waitForElementPresent(link_Business2, 5)) {

	String xpath_business2 = findTestObject('Object Repository/OR_HomePage/link_Business2').findPropertyValue('xpath').toString()
	WebElement btn_business2 = driver.findElement(By.xpath(xpath_business2))
	JavascriptExecutor js=(JavascriptExecutor) driver;
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_business2);
	WebUI.back()
}else {
	KeywordUtil.logInfo("Business link is not present in specified time")
}

if(WebUI.waitForElementPresent(link_Help, 10)) {
	WebUI.click(link_Help)
	WebUI.back()
}else {
	KeywordUtil.logInfo("Help link is not present in specified time")
}
if(WebUI.waitForElementPresent(link_Apply, 10)) {
	WebUI.click(link_Apply)
	if(WebUI.verifyMatch("Apply Online Now", ApplyOnline, true)) {
		KeywordUtil.logInfo("User on Apply Online Page")


		if(WebUI.waitForElementPresent(btn_applyNow, 10)) {
			WebUI.click(btn_applyNow)
			KeywordUtil.logInfo("Clicked on Apply Button")

			if(WebUI.verifyMatch("Applying for Zest-i",text_iZest, true)) {
				if(WebUI.waitForElementPresent(btn_Title, 10)) {
					WebUI.click(btn_Title)
					KeywordUtil.logInfo("Title dropdown Clicked ")

					String xpath_Tilte = findTestObject('Object Repository/OR_HomePage/value_title').findPropertyValue('xpath').toString()
					WebElement Title = driver.findElement(By.xpath(xpath_Tilte))
					WebUI.delay(2)
					JavascriptExecutor js=(JavascriptExecutor) driver;
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", Title);
					if(WebUI.waitForElementPresent(input_Name, 10)) {
						WebUI.click(input_Name)
						WebUI.setText(input_Name, Name_Value)

						if(WebUI.waitForElementPresent(dropdown_IdType, 10)) {
							WebUI.click(dropdown_IdType)
							KeywordUtil.logInfo("Title dropdown Clicked ")
							String xpath_IDType = findTestObject('Object Repository/OR_HomePage/value_IDType').findPropertyValue('xpath').toString()
							WebElement IDType = driver.findElement(By.xpath(xpath_IDType))
							WebUI.delay(2)
							
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", IDType);
						}else {
							KeywordUtil.markFailed("ID Type not present")
						}
					}else {
						KeywordUtil.markFailed("Name not present")
					}
				}else {
					KeywordUtil.markFailed("Title not present")
				}

			}else {
				KeywordUtil.markFailed("User is not on Apply Now Page")
			}

		}else {
			KeywordUtil.markFailed("Apply Now button is not present in specified time")
		}
	}else {
		KeywordUtil.markFailed("User is not on Apply Online Page")
	}

}else {
	KeywordUtil.markFailed("Apply link is not present in specified time")
}