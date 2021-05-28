package com.project.shareMed.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.shareMed.DAO.MedRequestDAO;
import com.project.shareMed.DAO.PartyDAO;
import com.project.shareMed.DAO.ProductDao;
import com.project.shareMed.entites.Donation;
import com.project.shareMed.entites.MedRequest;
import com.project.shareMed.entites.Party;
import com.project.shareMed.entites.Product;
import com.project.shareMed.model.EmailConfig;

@Service
public class MedRequestImpl implements MedRequestService {
	
	@Autowired
	MedRequestDAO medRequestDao;
	
	@Autowired
	PartyDAO partyDao;
	
	@Autowired
    ProductDao productDao;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public EmailConfig emailConfig;
	
	@Override
	public MedRequest createMedRequest(MedRequest medRequest) {
//		long partyId = medRequest.getPartyId();
//		Party party = partyDao.findById(partyId);
//		String email = party.getEmail();
//		System.out.println("Email Id is " +email);
//		
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		simpleMailMessage.setFrom(emailConfig.getUserName());
//		simpleMailMessage.setTo(email);
//		simpleMailMessage.setSubject("Thank You for you Donation");
//		simpleMailMessage.setText("We recived your request for "+medRequest.getNumberOfDoses()+" dose of "+medRequest.getMedicationName() +" medications.We will reach you shortly to deliver the medications");
//		
//		javaMailSender.send(simpleMailMessage);
//		
//		System.out.println("Mail Sent....");
		
		return medRequestDao.save(medRequest);
	}

	@Override
	public List<MedRequest> getPendingRequests() {
		List<MedRequest> requestList = medRequestDao.findAllByRequestStatus("requested");
		return requestList;
	}

	@Override
	public Map<String, Object> getMedReqDetailInfo(int medReqId) {
		Map<String, Object> medRequestDetailMap = new HashMap<String, Object>();
		MedRequest medRequest = medRequestDao.findByMedRequestId(Long.valueOf(medReqId));
		
		if(medRequest != null) {
			medRequestDetailMap.put("medRequest", medRequest);
			
			int productId = medRequest.getProductId();
			Product product = productDao.findByProductId(productId);
			if(product != null) {
				medRequestDetailMap.put("product", product);
			}
			
			int partyId = medRequest.getPartyId();
			Party party = partyDao.findById(partyId);
			if(party!= null) {
				medRequestDetailMap.put("party", party);
			}
			
		}
		return medRequestDetailMap;
	}
	
	
}
