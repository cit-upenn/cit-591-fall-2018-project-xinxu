package main;

import java.util.ArrayList;

/**
 * This class creates ArrayList<Artwork> and implements getTitle()/getInfo()
 * methods.
 * 
 * @author keqin zhou
 *
 */
public class ArtAnalysis {
	// construct ArrayList<Artwork>
	private ArrayList<Artwork> aws;

	public ArtAnalysis(ArrayList<Artwork> aws) {
		this.aws = aws;

	}

	/**
	 * method that pass in the String author and return ArrayList<String> of artwork
	 * titles by the author
	 * 
	 * @param author: finds the artwork of this author
	 * 
	 */
	public ArrayList<String> getTitle(String author) {
		ArrayList<String> ts = new ArrayList<String>();
		for (Artwork aw : aws) {
			if (author.equals(aw.getAuthor())) {
				ts.add(aw.getTitle());
			}
		}
		return ts;
	}

	/**
	 * method that pass in the String title and return ArrayList<String> of
	 * information related to this title
	 * 
	 * @param title: finds the information of this title
	 * 
	 */
	public ArrayList<String> getInfo(String title) {
		ArrayList<String> info = new ArrayList<String>();
		for (Artwork aw : aws) {
			if (title.equals(aw.getTitle())) {
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
