package capstone.project.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.project.entity.AdminCredentials;
import capstone.project.entity.CredentialsStatus;
import capstone.project.repository.SuperAdminRepository;
import capstone.project.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/SuperAdmin")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class SuperAdminController {
	private final SuperAdminRepository adminRepository;
	private final UserService service;
	
	
	@GetMapping("/getAdmins")
	public List<AdminCredentials> getAdmins()
	{
		System.out.println(adminRepository.findAll());
		return adminRepository.findAll();
		
	}
	
	@PostMapping("/postAdmins")
	public String addAdmins(@RequestBody AdminCredentials adminCredentials)
	{
		adminCredentials.setUserId(UUID.randomUUID().toString());
		adminRepository.save(adminCredentials);
//		adminCredentials.setUserId(UUID.randomUUID().toString());//uuid generate unique id for order number
		return "Admin Added in database Successfully";
	}
	@PostMapping("/credentialsValidate")
	public ResponseEntity<CredentialsStatus> getcrdentialsStatus(@RequestBody Map<String,String> credentials)
	{
		String email = credentials.get("email");

	    String password = credentials.get("password");
	    String userid=credentials.get("userid");
	    return service.ValidateUser(email, password,userid);
		
		
	}

}
