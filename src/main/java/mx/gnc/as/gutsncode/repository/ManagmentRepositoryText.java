package mx.gnc.as.gutsncode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gnc.as.gutsncode.dao.Post;
import mx.gnc.as.gutsncode.dao.Text;

@Repository
public interface ManagmentRepositoryText extends CrudRepository<Text, Long> {

}
