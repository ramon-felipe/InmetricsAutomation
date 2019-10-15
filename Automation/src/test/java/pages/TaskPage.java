package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.BasePage;
import enums.TagValues;
import helper.TempVarHelper;

public class TaskPage extends BasePage {

	public TaskPage ClickOnAddTaskButton() {
		dsl.ClickOnButton("+ Add a task");
		
		return this;
	}
	
	private TaskPage SelectDateLimite(String dateLimit) {
		final String TODAY = "TODAY";

		if(dateLimit.equalsIgnoreCase(TODAY)) dsl.ClickOnButton(dateLimit);
		dsl.ClickOnButton("Ok");
		
		return this;
	}
	
	private TaskPage SelectTimeLimit(String timeLimit) {
		String hour = getHourTimeLimit(timeLimit);
		String minute = getMinuteTimeLimit(timeLimit);

		dsl.Click("//div[contains(@class, 'clockpicker-dial clockpicker-hours')]/div[@class='clockpicker-tick'][text()='" + hour + "']");
		dsl.Click("//div[contains(@class, 'clockpicker-dial clockpicker-minutes')]/div[@class='clockpicker-tick'][text()='" + minute + "']");
		dsl.ClickOnButton("OK");
		
		return this;
	}
	
	private TaskPage InputTaskMoreDetails(String desc) {
		dsl.SendKeys(By.xpath("//textarea[@name='text']"), desc);
		
		return this;
	}
	
	private TaskPage SelectIsTaskDoneValue(String option) {
		if(option.startsWith(TagValues.RANDOM.getTagValue())) {
			int index = Integer.parseInt(dsl.javaFaker.regexify(option.replace(TagValues.RANDOM.getTagValue(), "")));
			dsl.SelectComboOption("(//select[@name='done']/option)["+ index +"]");
		}else {
			dsl.SelectComboOption("//select[@name='done']/option[text()='" + option + "']");
		}
		
		return this;
	}
	
	private TaskPage ClickOnSaveButton() {
		dsl.ClickOnButton("Save");
		
		return this;
	}
	
	public TaskPage FillNewTaskFields(String title,String dateLimit,String timeLimit,String desc,String isDone) {
		if(startsWithRandomTag(title)) title = getRandomValue(title);
		
		TempVarHelper.taskTitle = title;
		dsl.SendKeys(By.xpath("//input[@name='title']"), title + Keys.TAB);
		
		SelectDateLimite(dateLimit)
		.InputTaskMoreDetails(desc + (Keys.SHIFT) + (Keys.TAB))
		.SelectTimeLimit(timeLimit)
		.SelectIsTaskDoneValue(isDone);		
		
		return this;
	}
	
	private String getHourTimeLimit(String dateLimit) {
		int timeSeparatorIndex = dateLimit.indexOf(":");
		
		return dateLimit.substring(0, timeSeparatorIndex);
	}
	
	private String getMinuteTimeLimit(String dateLimit) {
		int timeSeparatorIndex = dateLimit.indexOf(":");
		
		return dateLimit.substring(timeSeparatorIndex+1, dateLimit.length());
	}
	
	public TaskPage CreateNewTask(String title,String dateLimit,String timeLimit,String desc,String isDone) {
		new HomePage()
		.ClickOnAddSomeTaskButton()
		.ClickOnAddTaskButton()
		.FillNewTaskFields(title,dateLimit,timeLimit,desc,isDone)
		.ClickOnSaveButton();
		
		return this;
	}
	
	public String GetTaskTitle() {
		return dsl.GetElementText(By.xpath("(//span[@class='title'])[last()]"));
	}
}
