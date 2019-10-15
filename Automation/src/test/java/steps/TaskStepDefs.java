package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TempVarHelper;
import pages.TaskPage;

public class TaskStepDefs {
	private TaskPage taskPage = new TaskPage();
	
	@And("^I create a new task (.*), (.*), (.*), (.*), (.*)$")
	public void CreateNewTask(String title,String dateLimit,String  timeLimit,String desc,String isDone) {
		taskPage.CreateNewTask(title, dateLimit, timeLimit, desc, isDone);
	}
	
	@Then("^I validate the task created$")
	public void ValidateTaskCreated() {
		assertThat(TempVarHelper.taskTitle, equalToIgnoringCase(taskPage.GetTaskTitle()));
	}
}
