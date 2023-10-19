package capstone.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import capstone.project.dto.BusinessRequest;
import capstone.project.dto.BusinessResponse;
import capstone.project.entity.Business;
import capstone.project.repository.BusinessRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusinessService {
	private final BusinessRepository businessRepository;
	
	
	public List<BusinessResponse> getPlans()
	{
		
		List<Business> blist=businessRepository.findAll();
		List<BusinessResponse>  list= new ArrayList<>();
		for(Business b : blist)
		{
			list.add(mapToBusinessResponsePlan(b));
		}
		
		return list;
	}
	private BusinessResponse mapToBusinessResponsePlan(Business businessResponse)
	{
		BusinessResponse obj= new BusinessResponse();
		obj.setId(businessResponse.getId());
		obj.setPlan(businessResponse.getPlan());
		obj.setHighSpeedInt(businessResponse.getHighSpeedInt());
		obj.setConferencing(businessResponse.getConferencing());
		obj.setDevices(businessResponse.getDevices());
		obj.setProductivity(businessResponse.getProductivity());
		obj.setData(businessResponse.getData());
		obj.setPayType(businessResponse.getPayType());
		obj.setOffer(businessResponse.getOffer());
		obj.setAdminName(businessResponse.getAdminName());
		obj.setStatus(businessResponse.getStatus());
		obj.setVoice(businessResponse.getVoice());
		return obj;
	}

	public void postPlan(BusinessRequest businessRequest)
	{
		Business obj= new Business();
		obj.setPlan(businessRequest.getPlan());
		obj.setHighSpeedInt(businessRequest.getHighSpeedInt());
		obj.setConferencing(businessRequest.getConferencing());
		obj.setDevices(businessRequest.getDevices());
		obj.setProductivity(businessRequest.getProductivity());
		obj.setData(businessRequest.getData());
		obj.setPayType(businessRequest.getPayType());
		obj.setOffer(businessRequest.getOffer());
		obj.setAdminName(businessRequest.getAdminName());
		obj.setStatus(businessRequest.getStatus());
		obj.setVoice(businessRequest.getVoice());
		businessRepository.save(obj);
		
	}
}
