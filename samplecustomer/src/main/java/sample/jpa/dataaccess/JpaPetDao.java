package sample.jpa.dataaccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sample.jpa.business.domain.Pet;
import sample.jpa.business.service.PetDao;

public class JpaPetDao implements PetDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Pet findById(int petId) {
		return em.find(Pet.class, petId);
	}

	@Override
	public List<Pet> findAll() {
		return em.createQuery("from Pet").getResultList();
	}

}
