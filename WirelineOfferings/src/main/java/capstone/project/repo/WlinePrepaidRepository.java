package capstone.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import capstone.project.entity.Subscription;
import capstone.project.entity.WlinePrepaid;

public interface WlinePrepaidRepository extends JpaRepository<WlinePrepaid, Integer> {
	
//	List<Subscription> findbySubscriptions();
}
