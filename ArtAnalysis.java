import java.util.ArrayList;

public class ArtAnalysis {

	private ArrayList<Artwork> aws;
	//private ArrayList<Artwork> aaws;
	
	public ArtAnalysis(ArrayList<Artwork> aws) {
		this.aws = aws;
		//this.aaws = aaws;
	}

	public ArrayList<String> getTitle(String author) {		
		ArrayList<String> ts = new ArrayList<String>();
		for(Artwork aw:aws) {
			if(author.equals(aw.getAuthor())) {
				//aaws.add(aw);
				ts.add(aw.getTitle());
			}
		}	
		return ts;
	}
	
	public ArrayList<String> getInfo(String title) {		
		ArrayList<String> info = new ArrayList<String>();
		for(Artwork aw:aws) {
			if(title.equals(aw.getTitle())) {
				info.add(aw.getLocation());
				info.add(aw.getDate());
				info.add(aw.getSchool());
				info.add(aw.getTechnique());
				info.add(aw.getType());
				info.add(aw.getUrl());
				info.add(aw.getLifespan());
				info.add(aw.getForm());
			}
		}	
		return info;
	}
	
	
	

}
