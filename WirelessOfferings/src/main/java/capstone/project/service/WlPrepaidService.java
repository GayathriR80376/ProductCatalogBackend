package capstone.project.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import capstone.project.dto.WlPostpaidRequest;
import capstone.project.dto.WlPostpaidResponse;
import capstone.project.dto.WlPrepaidRequest;
import capstone.project.dto.WlPrepaidResponse;
import capstone.project.entity.WlPostpaid;
import capstone.project.entity.Wlprepaid;
import capstone.project.repo.WlPostpaidRepository;
import capstone.project.repo.WlPrepaidRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WlPrepaidService {
	private final WlPrepaidRepository repo;
	private final WlPostpaidRepository postpaidRepository;
	
//	  ****************************************************************************************
//    ---------------------------prepaid Service-----------------------------------------------
//	************************************************************************************
	
	public List<WlPrepaidResponse> getPrepaidProducts()
	{
		List<Wlprepaid> products= repo.findAll();
		List<WlPrepaidResponse> plist=new ArrayList<WlPrepaidResponse>();
		for(Wlprepaid p:products)
		{
			plist.add(maptToWlPrepaidResponse(p));
		}
		return plist;
	}
	public void postPrepaidProducts(WlPrepaidRequest prepaidRequest)
	{
		Wlprepaid obj=new Wlprepaid();
		obj.setPlanValue(prepaidRequest.getPlanValue());
		obj.setPlanvalidity(prepaidRequest.getPlanvalidity());
		obj.setDataperday(prepaidRequest.getDataperday());
		obj.setTotaldata(prepaidRequest.getTotaldata());
		obj.setVoice(prepaidRequest.getVoice());
		obj.setSms(prepaidRequest.getSms());
		obj.setSubscriptions(prepaidRequest.getSubscriptions());
		obj.setAdminName(prepaidRequest.getAdminName());
		obj.setStatus(prepaidRequest.getStatus());
		repo.save(obj);
	}
	
	private WlPrepaidResponse maptToWlPrepaidResponse(Wlprepaid pro) {
		WlPrepaidResponse ps=WlPrepaidResponse.builder()
				.id(pro.getId())
				.planValue(pro.getPlanValue())
				.planvalidity(pro.getPlanvalidity())
				.totaldata(pro.getTotaldata())
				.dataperday(pro.getDataperday())
				.voice(pro.getVoice())
				.sms(pro.getSms())
				.subscriptions(pro.getSubscriptions())
				.adminName(pro.getAdminName())
				.status(pro.getStatus())
				.build();
		return ps;
	}
	
//	    ****************************************************************************************
//        ---------------------------postpaid Service-----------------------------------------------
//		************************************************************************************
       
	 
	public void postPostpaidProducts(WlPostpaidRequest wlPostpaidRequest)
	{
		WlPostpaid obj=new WlPostpaid();
		obj.setPlanValue(wlPostpaidRequest.getPlanValue());
		obj.setPlanValidity(wlPostpaidRequest.getPlanValidity());
		obj.setTotalData(wlPostpaidRequest.getTotalData());
		obj.setVoice(wlPostpaidRequest.getVoice());
		obj.setSms(wlPostpaidRequest.getSms());
		obj.setAddOnFamilySims(wlPostpaidRequest.getAddOnFamilySims());
		obj.setFamilySimData(wlPostpaidRequest.getFamilySimData());
		obj.setSubscriptions(wlPostpaidRequest.getSubscriptions());
		obj.setStatus(wlPostpaidRequest.getStatus());
		obj.setAdminName(wlPostpaidRequest.getAdminName());
		postpaidRepository.save(obj);
		
	}
	
	
	public List<WlPostpaidResponse> getPostpaidProducts()
	{
		List<WlPostpaid> products= postpaidRepository.findAll();
		List<WlPostpaidResponse> plist=new ArrayList<WlPostpaidResponse>();
		for(WlPostpaid p:products)
		{
			plist.add(maptToWlPostpaidResponse(p));
		}
		return plist;
	}
	private WlPostpaidResponse maptToWlPostpaidResponse(WlPostpaid pro) {
		WlPostpaidResponse ps=WlPostpaidResponse.builder()
				.id(pro.getId())
				.planValue(pro.getPlanValue())
				.planValidity(pro.getPlanValidity())
				.totalData(pro.getTotalData())
				.sms(pro.getSms())
				.voice(pro.getVoice())
				.addOnFamilySims(pro.getAddOnFamilySims())
				.familySimData(pro.getFamilySimData())
				.adminName(pro.getAdminName())
				.subscriptions(pro.getSubscriptions())
				.status(pro.getStatus())
				.build();
		        return ps;
	}
	
	
}
