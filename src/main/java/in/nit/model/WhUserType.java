package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "whusertab")
public class WhUserType {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer userId;
	@Column(name = "utype")
	private String userType;
	@Column(name = "ucode")
	private String userCode;
	@Column(name = "ufor")
	private String userFor;
 	@Column(name = "uemail")
	private String userEmail;
	@Column(name = "ucontact")
	private Long userContact;
	@Column(name = "uidtype")
	private String userIdType;
	@Column(name = "uidnum")
	private Long userIdNumber;

	public WhUserType() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserContact() {
		return userContact;
	}

	public void setUserContact(Long userContact) {
		this.userContact = userContact;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public Long getUserIdNumber() {
		return userIdNumber;
	}

	public void setUserIdNumber(Long userIdNumber) {
		this.userIdNumber = userIdNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userFor="
				+ userFor + ", userEmail=" + userEmail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", userIdNumber=" + userIdNumber + "]";
	}




}
