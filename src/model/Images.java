package model;
// Generated Dec 6, 2020, 11:16:30 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Images generated by hbm2java
 */
@Entity
@Table(name = "IMAGES", schema = "dbo", catalog = "Website_UploadImages")
public class Images implements java.io.Serializable {

	private Integer imageId;
	private Albums albums;
	private Tags tags;
	private Users users;
	private String imageUrl;
	private Date imagedate;
	private String imageCaption;
	private String imageLocation;
	private Integer vote;
	private Set<Shared> shareds = new HashSet<Shared>(0);

	public Images() {
	}

	public Images(Albums albums, Tags tags, Users users, String imageUrl, Date imagedate, String imageCaption,
			String imageLocation, Integer vote, Set<Shared> shareds) {
		this.albums = albums;
		this.tags = tags;
		this.users = users;
		this.imageUrl = imageUrl;
		this.imagedate = imagedate;
		this.imageCaption = imageCaption;
		this.imageLocation = imageLocation;
		this.vote = vote;
		this.shareds = shareds;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ImageID", unique = true, nullable = false)
	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AlbumID")
	public Albums getAlbums() {
		return this.albums;
	}

	public void setAlbums(Albums albums) {
		this.albums = albums;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TagID")
	public Tags getTags() {
		return this.tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "ImageUrl", length = 50)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Imagedate", length = 10)
	public Date getImagedate() {
		return this.imagedate;
	}

	public void setImagedate(Date imagedate) {
		this.imagedate = imagedate;
	}

	@Column(name = "ImageCaption")
	public String getImageCaption() {
		return this.imageCaption;
	}

	public void setImageCaption(String imageCaption) {
		this.imageCaption = imageCaption;
	}

	@Column(name = "ImageLocation")
	public String getImageLocation() {
		return this.imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	@Column(name = "Vote")
	public Integer getVote() {
		return this.vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "images")
	public Set<Shared> getShareds() {
		return this.shareds;
	}

	public void setShareds(Set<Shared> shareds) {
		this.shareds = shareds;
	}

}
