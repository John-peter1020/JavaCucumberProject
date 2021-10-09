package base;

public enum APIResources {
	LatestRates("/v1/latest");

	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
}
