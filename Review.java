import java.io.*;
/**
 * Represents review object for movie.
 * Contains review information such as content and ratings for movie.
 */
public class Review implements Serializable
{
	/**
	 * Rating of review.
	 */
	private int reviewRating;
	/**
	 * Content of review.
	 */
	private String reviewContent; 
	/**
	 * Constructor for Review object.
	 * @param rating Review rating.
	 * @param content Review content.
	 */
	public Review(int rating, String content) {
		this.reviewRating = rating;
		this.reviewContent = content;
	}
	/**
	 * Retrieves review rating.
	 * @return review rating.
	 */
	public int getReviewRating() {
		return reviewRating;
	}
	/**
	 * Retrieves review content.
	 * @return review content.
	 */
	public String getReviewContent() {
		return reviewContent;
	}
	/**
	 * Sets review rating.
	 * @param rating Review rating.
	 */
	public void setReviewRating(int rating) {
		reviewRating = rating;
	}
	/**
	 * Sets review content.
	 * @param content Review content.
	 */
	public void setReviewContent(String content) {
		reviewContent = content;
	}

}
