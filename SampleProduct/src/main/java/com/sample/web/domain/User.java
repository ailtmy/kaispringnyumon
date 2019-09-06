package com.sample.web.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@NotNull
	@Size(max = 20)
	private String name;

	@NotNull
	@Size(max = 100)
	private String address;

	@NotNull
	@Pattern(regexp = ".+@.+", message = "{errors.emailAddress}")
	private String emailAddress;
}
