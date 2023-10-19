package capstone.project.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import capstone.project.entity.AdminCredentials;
import capstone.project.entity.CredentialsStatus;
import capstone.project.repository.SuperAdminRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final SuperAdminRepository superAdminRepo;
	
	public ResponseEntity<CredentialsStatus> ValidateUser(String email, String password,String username) {

	    AdminCredentials user = superAdminRepo.findByEmail(email);

	System.out.println(user.getEmail()+" "+user.getPassWord());

	    if (user != null && user.getPassWord() != null && user.getPassWord().equals(password)) {

	        // User authentication successful

	        CredentialsStatus response = new CredentialsStatus("success", user);

	        return ResponseEntity.ok(response);

	    } else {

	        // User authentication failed

	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new CredentialsStatus(email, null));

	    }

	}

}
