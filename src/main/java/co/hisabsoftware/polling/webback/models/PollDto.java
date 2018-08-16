package co.hisabsoftware.polling.webback.models;

public class PollDto {
	private int id;
	private String text;
	
	
	public PollDto(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
