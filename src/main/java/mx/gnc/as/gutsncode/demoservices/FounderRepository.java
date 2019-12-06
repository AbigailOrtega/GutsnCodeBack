package mx.gnc.as.gutsncode.demoservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gnc.as.gutsncode.dao.Founder;

@org.springframework.stereotype.Repository
public interface FounderRepository extends JpaRepository<Founder, Long>{
	
	List<Founder> findByName(String name);
	List<Founder> findAll();
	
}
