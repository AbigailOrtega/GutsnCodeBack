package mx.gnc.as.gutsncode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.gnc.as.gutsncode.dao.Founder;



public interface FounderRepository extends CrudRepository<Founder, Long>{
	List<Founder> findByName(String name);
	List<Founder> findAll();
}
