package com.naveenautomation.Browsers;

public enum Browsers {
	
	GOOGLE_CHROME("chrome"),
	EDGE("edge"),
	FIREFOX("firefox"),
	OPERA("opera");
	
	String name;

	private Browsers(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}