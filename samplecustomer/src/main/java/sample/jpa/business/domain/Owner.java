package sample.jpa.business.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Owner {

	@Id
	private Integer ownerId;
	private String OwnerName;

	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
}
