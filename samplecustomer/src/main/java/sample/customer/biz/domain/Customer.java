package sample.customer.biz.domain;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

	private int id;

	private String name;

	private String emailAddress;

	private Date birthday;

	private Integer favoriteNumber;

	public boolean isNgEmail() {
		if(emailAddress == null) {
			return false;
		}

		//ドメイン名が「ng.foo.baz」であれば使用不可のアドレスとみなす
		return emailAddress.matches(".*@ng.foo.baz");
	}

	public Customer() {}

	public Customer(String name, String emailAddress,
			Date birthday, Integer favoriteNumber) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.birthday = birthday;
		this.favoriteNumber = favoriteNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getFavoriteNumber() {
		return favoriteNumber;
	}

	public void setFavoriteNumber(Integer favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}

}
