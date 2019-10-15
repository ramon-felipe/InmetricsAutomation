package enums;

public enum TagValues {
	RANDOM("<RANDOM>"), EMPTY("<EMPTY>"), IGNORE("<IGNORE>");
	
	private String tagValue;
	
	TagValues(String tagValue){
		this.tagValue= tagValue;	
	}
	
	public String getTagValue() {
		return tagValue;
	}
}
