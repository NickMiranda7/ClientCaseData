package com.nick.ClientCaseData.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.ClientCaseData.models.Client;
import com.nick.ClientCaseData.models.Member;
import com.nick.ClientCaseData.repositories.MemberRepository;

@Service
public class MemberService {
	@Autowired
	public MemberRepository memberRepo;
	
	//Get All
	public List<Member> getAllMembers(){
		return this.memberRepo.findAll();
	}
	
	//Get One
	public Member findById(Long id) {
		return this.memberRepo.findById(id).orElse(null);
	}
	
	// Create
	public Member createMember(Member newMember) {
		return this.memberRepo.save(newMember);
	}
	
	// Update 
	public Member updateMember(Member updatedMember) {
		return this.memberRepo.save(updatedMember);
	}
	
	// Delete
	public void deleteMember(Long id) {
		this.memberRepo.deleteById(id);
	}

	public List<Member> membersNotAdded(Client client){
		return this.memberRepo.findByClientNotContains(client);
	}
}
