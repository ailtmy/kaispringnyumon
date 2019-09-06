package com.sample.web.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class PetDaoImpl implements PetDaoCustome {

	@Override
	public void foo() {
		System.out.println("foo!");
	}

}
