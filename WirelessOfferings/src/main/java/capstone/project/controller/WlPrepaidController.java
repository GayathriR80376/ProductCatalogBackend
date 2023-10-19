package capstone.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.project.dto.WlPostpaidRequest;
import capstone.project.dto.WlPostpaidResponse;
import capstone.project.dto.WlPrepaidRequest;
import capstone.project.dto.WlPrepaidResponse;
import capstone.project.entity.WlPostpaid;
import capstone.project.entity.Wlprepaid;
import capstone.project.repo.WlPostpaidRepository;
import capstone.project.repo.WlPrepaidRepository;
import capstone.project.service.WlPrepaidService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequestMapping("/Wireless")
public class WlPrepaidController {
	
	private final WlPrepaidService service;
	private final WlPostpaidRepository postpaidRepository;
	private final WlPrepaidRepository prepaidRepository;
	
	
	@PostMapping("/addprepaid")
	public String addProduct(@RequestBody WlPrepaidRequest wlprepaid)
	{
		System.out.println("Checking");
		System.out.println(wlprepaid);
		service.postPrepaidProducts(wlprepaid);
		return "PRepaid Added Successful";
	}
	@GetMapping("/getPrepaid")
	public List<WlPrepaidResponse> getproducts()
	{
		System.out.println(service.getPrepaidProducts());
		return service.getPrepaidProducts();
	}
	
	 @PostMapping("/editWlessPrePaid")
	    public String editPrepaid(@RequestBody Wlprepaid wlprepaid)
		{
		 prepaidRepository.save(wlprepaid);
			System.out.println(wlprepaid);
			return "prepaid edited successs";
		}
	    @PostMapping("/deleteWlessPrePaid")
	    public String deletePrepaid(@RequestBody Wlprepaid wlprepaid)
		{
	    	prepaidRepository.delete(wlprepaid);
			System.out.println(wlprepaid);
			return "prepaid Deleted successs";
		}
	
	
	
	
	
	
//	****************************************************************************************
//  ---------------------------postpaid Service-----------------------------------------------
//	************************************************************************************
 
	
	
	@PostMapping("/addPostpaid")
	public String addPostpaid(@RequestBody WlPostpaidRequest wlPostpaidRequest)
	{
		service.postPostpaidProducts(wlPostpaidRequest);
		System.out.println(wlPostpaidRequest);
		
		return "postpaid added successs";
	}
	
	@GetMapping("/getPostpaid")
	public List<WlPostpaidResponse> getPostpaidProducts()
	{
		return service.getPostpaidProducts();
	}
    @PostMapping("/editWlessPostPaid")
    public String editPostpaid(@RequestBody WlPostpaid wlPostpaid)
	{
    	postpaidRepository.save(wlPostpaid);
		System.out.println(wlPostpaid);
		return "postpaid added successs";
	}
    @PostMapping("/deleteWlessPostPaid")
    public String deletePostpaid(@RequestBody WlPostpaid wlPostpaid)
	{
    	postpaidRepository.delete(wlPostpaid);
		System.out.println(wlPostpaid);
		return "postpaid added successs";
	}
}
