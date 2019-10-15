package base;

import static driver.DriverFactory.GetDriver;

import enums.TagValues;

public class BasePage{

	public DSL dsl;
	
	public BasePage() {
		this.dsl = new DSL();
	}
	
	public BasePage GoTo(String url) {
		GetDriver().get(url);
		
		return this;
	}	
	
	protected boolean startsWithRandomTag(String text) {
		return text.startsWith(TagValues.RANDOM.getTagValue());
	}
	
	protected String getRandomValue(String text) {
		return dsl.javaFaker.regexify(text.replace(TagValues.RANDOM.getTagValue(), ""));
	}
	
}
