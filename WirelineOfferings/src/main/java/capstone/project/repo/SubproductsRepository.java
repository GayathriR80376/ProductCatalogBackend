package capstone.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import capstone.project.entity.Subscription;

public interface SubproductsRepository extends JpaRepository<Subscription, Integer> {

}
