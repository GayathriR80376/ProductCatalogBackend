package capstone.project.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.project.dto.WlinePostpaidRequest;
import capstone.project.dto.WlinePostpaidResponse;
import capstone.project.dto.WlinePrepaidRequest;
import capstone.project.dto.WlinePrepaidResponse;
import capstone.project.entity.EmailEntity;
import capstone.project.entity.Subscription;
import capstone.project.entity.WlinePostpaid;
import capstone.project.entity.WlinePrepaid;
import capstone.project.repo.SubproductsRepository;
import capstone.project.repo.WlinePostpaidRepository;
import capstone.project.repo.WlinePrepaidRepository;
import capstone.project.service.MailService;
import capstone.project.service.WirelineProductService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequestMapping("/Wireline")
public class WirelineController {
	private final WirelineProductService productService;
	private final WlinePrepaidRepository prepaidRepository;
	private final WlinePostpaidRepository postpaidRepository;
	private final MailService mailService;
	
	
	@PostMapping("/addprepaid")
	public String addWlinePrepaid(@RequestBody WlinePrepaidRequest wlinePrepaidRequest)
	{
		System.out.println("Checking");
		System.out.println(wlinePrepaidRequest);
//		prepaidRepository.save(wlinePrepaid);
//		productService.postPrepaid(wlinePrepaid);
		productService.PostPrepaid(wlinePrepaidRequest);
		return "PRepaid Added Successful";
	}
	@CrossOrigin(originPatterns = "http://localhost:4200")
	@GetMapping("/getprepaid")
	public List<WlinePrepaidResponse> getWlinePrepaid()
	{
		System.out.println("inside");
		System.out.println(productService.getPrepaid());
		return productService.getPrepaid();
	}
	
	 @PostMapping("/editWlinePrePaid")
	    public String editPrepaid(@RequestBody WlinePrepaid wlineprepaid)
		{
		 prepaidRepository.save(wlineprepaid);
			System.out.println(wlineprepaid);
			return "prepaid edited successs";
		}
	    @PostMapping("/deleteWlinePrePaid")
	    public String deletePrepaid(@RequestBody WlinePrepaid wlineprepaid)
		{
	    	prepaidRepository.delete(wlineprepaid);
			System.out.println(wlineprepaid);
			return "prepaid Deleted successs";
		}
	
	
	
    
    /*	
    @CrossOrigin(originPatterns = "http://localhost:4200")
	@GetMapping("/getSubproducts")
	public List<Subscription> getSubproducts()
	{
		return repository.findAll();
	}
             */	
//  ***************************************************************************************
//  -------------------------------postpaid----------------------------------------------
//  ***************************************************************************************
	
	@PostMapping("/addpostpaid")
	public String addWlinePostpaid(@RequestBody WlinePostpaidRequest wlinePostpaidRequest)
	{
		System.out.println("Checking");
		System.out.println(wlinePostpaidRequest);
//		wlinePostpaidRepo.save(wlinePostpaid);
//		productService.postPrepaid(wlinePrepaid);
		productService.PostPostpaid(wlinePostpaidRequest);
		return "PRepaid Added Successful";
	}
	
	@GetMapping("/getpostpaid")
	public List<WlinePostpaidResponse> getWlinePostpaid()
	{
		System.out.println("inside");
		System.out.println(productService.getPostpaid());
		return productService.getPostpaid();
	}
	
	
	@PostMapping("/editWlinePostPaid")
    public String editPostpaid(@RequestBody WlinePostpaid wlinepostpaid)
	{
		postpaidRepository.save(wlinepostpaid);
		System.out.println(wlinepostpaid);
		return "prepaid edited successs";
	}
    @PostMapping("/deleteWlinePostPaid")
    public String deletePostpaid(@RequestBody WlinePostpaid wlinepostpaid)
	{
    	postpaidRepository.delete(wlinepostpaid);
		System.out.println(wlinepostpaid);
		return "prepaid Deleted successs";
	}
    
    
    
    
    
    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/email/{customerId}")

    public ResponseEntity<EmailEntity> sendEmail(@PathVariable Integer customerId) throws MessagingException {

        WlinePostpaid customer = postpaidRepository.findById(customerId).orElse(null);

        if (customer == null) {

            //return ResponseEntity.badRequest().body("Customer not found with ID: " + customerId);

            return new ResponseEntity<EmailEntity>(new EmailEntity("Customer not found with ID: " + customerId),HttpStatus.OK);

//        	return new ResponseEntity<String>("Customer not found");
        }

 

        // Send email using emailService

        String emailContent = "Dear " + customer.getAdminName() + ",\n\n"

                + "This is a reminder that your outstanding bill of $"

                + customer.getStatus() + " is due today. "

                + "Please make the payment as soon as possible. "

                + "Thank you for your cooperation.";

        mailService.sendEmail(customer.getAdminName(), "Subject: Your Invoice", emailContent);

 

        //return ResponseEntity.ok("Email sent successfully to customer with ID: " + customerId);

        return new ResponseEntity<EmailEntity>(new EmailEntity("Email sent successfully to customer with ID:"+ customerId),HttpStatus.OK);

    }
	
	
}
