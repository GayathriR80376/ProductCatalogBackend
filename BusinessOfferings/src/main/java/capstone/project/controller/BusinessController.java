package capstone.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.project.dto.BusinessRequest;
import capstone.project.dto.BusinessResponse;
import capstone.project.entity.Business;
import capstone.project.repository.BusinessRepository;
import capstone.project.service.BusinessService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/business")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class BusinessController {
	
	private final BusinessService businessService;
	private final BusinessRepository businessRepository;
	
	@PostMapping("/addplan")
	public BusinessRequest postPlans(@RequestBody BusinessRequest businessRequest)
	{
		businessService.postPlan(businessRequest);
		return businessRequest ;
	}
	@GetMapping("/getplan")
	public List<BusinessResponse> postPlans()
	{
		
		return businessService.getPlans();
	}
	@PostMapping("/editBusinessPlans")
	public String editPlans(@RequestBody Business business)
	{
		System.out.println(business);
		businessRepository.save(business);
		return "product Edited successful";
	}
    @PostMapping("/deleteBusinessPlans")
    public Business deletePlan(@RequestBody Business business)
    {
    	businessRepository.delete(business);
    	return business;
    }
}
