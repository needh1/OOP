import java.io.*;

public class Review implements Serializable
{
	private int reviewRating;
	private String reviewContent; 
	
	public Review(int rating, String content) {
		this.reviewRating = rating;
		this.reviewContent = content;
	}

	public int getReviewRating() {
		return reviewRating;
	}
		
	public String getReviewContent() {
		return reviewContent;
	}
	
	public void setReviewRating(int rating) {
		reviewRating = rating;
	}

	public void setReviewText(String content) {
		reviewContent = content;
	}

}
