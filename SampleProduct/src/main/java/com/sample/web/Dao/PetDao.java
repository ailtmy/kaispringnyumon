package com.sample.web.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.web.domain.Pet;

@Repository
public interface PetDao extends JpaRepository<Pet, Integer> {

	List<Pet> findByPetName(String petName);
	List<Pet> findByPetNameAndPriceLessThanEqual(String petName, int price);

//	//検索系
//	@Query("select p from Pet p where p.owner.ownerName = ?1")
//	List<Pet> findByOwnerName(String ownerName);
//
//	@Query("select p from Pet p where p.owner.ownerId = :ownerId")
//	List<Pet> findByOwnerId(@Param("ownerId") Integer ownerId);
//
//	//更新系
//	@Modifying
//	@Query("update Pet p set p.price = ?1 where p.petName = ?2")
//	int updatePetPrice(Integer price, String petName); //戻り値更新されたエンティティ数
}
