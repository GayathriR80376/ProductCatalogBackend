package capstone.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import capstone.project.entity.Business;

public interface BusinessRepository extends JpaRepository<Business, Integer> {

}
