
public class Material {
	
	protected String title;
	protected String description;
	protected String text;
	protected String url;
	protected boolean number;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Material(String title, String description, String text, String url) {
		super();
		this.title = title;
		this.description = description;
		this.text = text;
		this.url = url;
	}
	
	

}
