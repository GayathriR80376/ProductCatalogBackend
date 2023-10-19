package capstone.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import capstone.project.dto.WlinePostpaidRequest;
import capstone.project.dto.WlinePostpaidResponse;
import capstone.project.dto.WlinePrepaidRequest;
import capstone.project.dto.WlinePrepaidResponse;
import capstone.project.entity.WlinePostpaid;
import capstone.project.entity.WlinePrepaid;
import capstone.project.repo.SubproductsRepository;
import capstone.project.repo.WlinePostpaidRepository;
import capstone.project.repo.WlinePrepaidRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class WirelineProductService {
	
	private final WlinePrepaidRepository wlineprepaidRepository;
	private final WlinePostpaidRepository wlinePostpaidRepo;
//	private final SubproductsRepository repository;
	
	public void PostPrepaid(WlinePrepaidRequest prepaidRequest)
	{
		WlinePrepaid obj=new WlinePrepaid();
		obj.setPlanValue(prepaidRequest.getPlanValue());
		obj.setPlanValidity(prepaidRequest.getPlanValidity());
		obj.setData(prepaidRequest.getData());
		obj.setCategory(prepaidRequest.getCategory());
		obj.setOtherFeatures(prepaidRequest.getOtherFeatures());
		obj.setSpeed(prepaidRequest.getSpeed());
		obj.setStatus(prepaidRequest.getStatus());
		obj.setAdminName(prepaidRequest.getAdminName());
		obj.setSubscription(prepaidRequest.getSubscription());
		obj.setVoice(prepaidRequest.getVoice());
		wlineprepaidRepository.save(obj);
	}
	
	public List<WlinePrepaidResponse> getPrepaid()
	{
		List<WlinePrepaid> products= wlineprepaidRepository.findAll();
		List<WlinePrepaidResponse> plist=new ArrayList<WlinePrepaidResponse>();
		for(WlinePrepaid p:products)
		{
			plist.add(maptToWlinePrepaidResponse(p));
		}
		return plist;
	}
	
	private WlinePrepaidResponse maptToWlinePrepaidResponse(WlinePrepaid pro) {
		WlinePrepaidResponse ps=WlinePrepaidResponse.builder()
				.id(pro.getId())
				.planValue(pro.getPlanValue())
				.planValidity(pro.getPlanValidity())
				.speed(pro.getSpeed())
				.data(pro.getData())
				.voice(pro.getVoice())
				.subscription(pro.getSubscription())
				.otherFeatures(pro.getOtherFeatures())
				.category(pro.getCategory())
				.adminName(pro.getAdminName())
				.status(pro.getStatus())
				.build();
		return ps;
	}
 
/*  ***************************************************************************************
     -------------------------------postpaid----------------------------------------------
    ***************************************************************************************  */
	public void PostPostpaid(WlinePostpaidRequest postpaidRequest)
	{
		WlinePostpaid obj=new WlinePostpaid();
		obj.setPlanValue(postpaidRequest.getPlanValue());
		obj.setPlanValidity(postpaidRequest.getPlanValidity());
		obj.setData(postpaidRequest.getData());
		obj.setCategory(postpaidRequest.getCategory());
		obj.setOtherFeatures(postpaidRequest.getOtherFeatures());
		obj.setSpeed(postpaidRequest.getSpeed());
		obj.setStatus(postpaidRequest.getStatus());
		obj.setAdminName(postpaidRequest.getAdminName());
		obj.setSubscription(postpaidRequest.getSubscription());
		obj.setVoice(postpaidRequest.getVoice());
		wlinePostpaidRepo.save(obj);
	}
	
	public List<WlinePostpaidResponse> getPostpaid()
	{
		List<WlinePostpaid> products= wlinePostpaidRepo.findAll();
		List<WlinePostpaidResponse> plist=new ArrayList<WlinePostpaidResponse>();
		for(WlinePostpaid p:products)
		{
			plist.add(maptToWlinePostpaidResponse(p));
		}
		return plist;
	}
	
	private WlinePostpaidResponse maptToWlinePostpaidResponse(WlinePostpaid pro) {
		WlinePostpaidResponse ps=WlinePostpaidResponse.builder()
				.id(pro.getId())
				.planValue(pro.getPlanValue())
				.planValidity(pro.getPlanValidity())
				.speed(pro.getSpeed())
				.data(pro.getData())
				.voice(pro.getVoice())
				.subscription(pro.getSubscription())
				.otherFeatures(pro.getOtherFeatures())
				.category(pro.getCategory())
				.adminName(pro.getAdminName())
				.status(pro.getStatus())
				.build();
		return ps;
	}
}
