package entities;

//Classe padre
public class MultimediaContent
{
	private String title;
	private int durata;
	
	public MultimediaContent(String title, int durata)
	{
		setTitle(title);
		setDurata(durata);
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}


	
	@Override
	public String toString() {
		return "Title: " + title;
	}
	
	
	
}
