public class Review 
{
	private int movieID;
	private int reviewRating;
	private String reviewContent; 
	
	public Review(int id, int rating, String review) {
		this.movieID = id;
		this.reviewRating = rating;
		this.reviewContent = review;
	}

	public int getMovieID() {
		return movieID;
	}

	public int getReviewRating() {
		return reviewRating;
	}
		
	public String getReviewContent() {
		return reviewContent;
	}

	public void setMovieID(int id) {
		movieID = id;
	}
	
	public void setReviewRating(int rating) {
		reviewRating = rating;
	}

	public void setReviewText(String review) {
		reviewContent = review;
	}

}
