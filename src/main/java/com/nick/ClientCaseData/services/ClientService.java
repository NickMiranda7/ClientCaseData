package com.nick.ClientCaseData.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.ClientCaseData.models.Client;
import com.nick.ClientCaseData.models.Member;
import com.nick.ClientCaseData.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepo;
	
	//Get All
	public List<Client> getAllClients(){
		return this.clientRepo.findAll();
	}
	
	//Get One
	public Client findById(Long id) {
		return this.clientRepo.findById(id).orElse(null);
	}
	
	// Create
	public Client createClient(Client newClient) {
		return this.clientRepo.save(newClient);
	}
	
	// Update 
	public Client updateClient(Client updatedClient) {
		return this.clientRepo.save(updatedClient);
	}
	
	// Delete
	public void deleteClient(Long id) {
		this.clientRepo.deleteById(id);
	}

	public List<Client> clientsNotAdded(Member member){
		return this.clientRepo.findByMembersNotContains(member);
	}
	public List<Client> searchForClientByName(String name) {
		return this.clientRepo.findByNameContaining(name);
	}
	public List<Client> searchForClientByCaseNumber(String caseNumber) {
		return this.clientRepo.findByCaseNumberContaining(caseNumber);
	}
}
