package com.talan.banking.cashflow;


import java.util.Date;

import org.hibernate.TransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@RestController
public class CashFlowController {

	@Autowired
	private BankRepository repository;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	

	@GetMapping("/cashflow/{accountid}")
	public Account getAccount(@PathVariable int accountid) {
		Account account = repository.findById(accountid);
		return account;
	}
	

	@PostMapping("/cashflow/{accountid}/deposit/{amount}")
	public Account deposit(@PathVariable int accountid, @PathVariable float amount) {

		Account account = repository.findById(accountid);
		float newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
		return repository.saveAndFlush(account);
	}
	
	
	@PostMapping("/cashflow/{accountid}/withdraw/{amount}")
	public Account withdraw(@PathVariable int accountid, @PathVariable float amount) {
		
		Account account = repository.findById(accountid);
		float newBalance = account.getBalance() - amount;
		account.setBalance(newBalance);
		return repository.saveAndFlush(account);
	}
	
	@PostMapping("/cashflow/transfer/from/{payerid}/to/{payeeid}/amount/{amount}")
	public ResponseEntity<Transaction> transfer(@PathVariable int payerid, @PathVariable int payeeid, @PathVariable float amount) throws TransactionException{
		
		Account payer = repository.findById(payerid);
		Account payee = repository.findById(payeeid);
		
		if(payer == null || payee == null){
			throw new TransactionException("Payer or payee not found, try another id.");
		}
		
		float newBalance_payer = payer.getBalance() - amount;
		float newBalance_payee = payee.getBalance() + amount;
		
		payer.setBalance(newBalance_payer);
		payee.setBalance(newBalance_payee);
		repository.save(payer);
		repository.saveAndFlush(payee);
		
		Transaction t = new Transaction();
		t.setPayerid(payerid);
		t.setPayeeid(payeeid);
		t.setAmount(amount);
		t.setDate( new Date() );
		
		HttpEntity<Transaction> request = new HttpEntity<>( t );
		
		RestTemplate response = new RestTemplate();
		return response.postForEntity("http://localhost:8100/transaction/",
				request, Transaction.class);
	}
	

}
