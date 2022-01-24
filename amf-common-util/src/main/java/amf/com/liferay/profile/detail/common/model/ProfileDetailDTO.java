package amf.com.liferay.profile.detail.common.model;

import java.util.List;

public class ProfileDetailDTO {

	private long userId;
	private long profileDetailId;
	private String screenName;
	private String firstName;
	private String lastName;
	private boolean male;
	private String birthDate;
	private String aboutMe;
	private String favoriteQuotes;
	private String favoriteMovie;
	private String leastFavoriteMovie;
	private String favoriteActor;
	private String favoriteGenre;
	private List<String> favoriteGenreList;
	private int privacy;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getProfileDetailId() {
		return profileDetailId;
	}
	public void setProfileDetailId(long profileDetailId) {
		this.profileDetailId = profileDetailId;
	}
	public int getPrivacy() {
		return privacy;
	}
	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String getFavoriteQuotes() {
		return favoriteQuotes;
	}
	public void setFavoriteQuotes(String favoriteQuotes) {
		this.favoriteQuotes = favoriteQuotes;
	}
	public String getFavoriteMovie() {
		return favoriteMovie;
	}
	public void setFavoriteMovie(String favoriteMovie) {
		this.favoriteMovie = favoriteMovie;
	}
	public String getLeastFavoriteMovie() {
		return leastFavoriteMovie;
	}
	public void setLeastFavoriteMovie(String leastFavoriteMovie) {
		this.leastFavoriteMovie = leastFavoriteMovie;
	}
	public String getFavoriteActor() {
		return favoriteActor;
	}
	public void setFavoriteActor(String favoriteActor) {
		this.favoriteActor = favoriteActor;
	}
	public String getFavoriteGenre() {
		return favoriteGenre;
	}
	public void setFavoriteGenre(String favoritGenre) {
		this.favoriteGenre = favoritGenre;
	}
	public List<String> getFavoriteGenreList() {
		return favoriteGenreList;
	}
	public void setFavoriteGenreList(List<String> favoriteGenreList) {
		this.favoriteGenreList = favoriteGenreList;
	}

}
