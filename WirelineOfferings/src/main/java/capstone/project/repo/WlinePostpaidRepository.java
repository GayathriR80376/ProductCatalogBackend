package capstone.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import capstone.project.entity.WlinePostpaid;
import java.util.List;
import java.util.Optional;


public interface WlinePostpaidRepository extends JpaRepository<WlinePostpaid, Integer> {
	

}
