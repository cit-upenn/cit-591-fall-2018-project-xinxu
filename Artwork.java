
public class Artwork {
	
	private String author;
	private String lifespan;
	private String title;
	private String date;
	private String technique;
	private String location;
	private String url;
	private String form;
	private String type;
	private String school;
	private String timeframe;
	
	public Artwork(String author, String lifespan, String title, String date, String technique, String location, String url, String form, String type,String school, String timeframe) {
		this.author = author;
		this.lifespan = lifespan;
		this.title = title;
		this.date = date;
		this.technique = technique;
		this.location = location;
		this.url = url;
		this.form = form;
		this.type = type;
		this.school = school;
		this.timeframe = timeframe;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(String timeframe) {
		this.timeframe = timeframe;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLifespan() {
		return lifespan;
	}

	public void setLifespan(String lifespan) {
		this.lifespan = lifespan;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	

}
