public class Review 
{
	private String movieID;
	private int reviewRating;
	private String reviewContent; 
	
	public Review(String id, int rating, String review) {
		this.movieID = id;
		this.reviewRating = rating;
		this.reviewContent = review;
	}

	public String getMovieID() {
		return movieID;
	}

	public int getReviewRating() {
		return reviewRating;
	}
		
	public String getReviewContent() {
		return reviewContent;
	}

	public void setMovieID(String id) {
		movieID = id;
	}
	
	public void setReviewRating(int rating) {
		reviewRating = rating;
	}

	public void setReviewText(String review) {
		reviewContent = review;
	}

}
