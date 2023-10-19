package capstone.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import capstone.project.entity.AdminCredentials;

public interface SuperAdminRepository extends JpaRepository<AdminCredentials, Integer> {

	AdminCredentials findByEmail(String email);
	

}
