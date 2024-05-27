package com.workplace.customer;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerApiService {

	private List<Payload> payload=  Arrays.asList(
			new Payload("13244667", "gghhhd", "zcbvmvnfz", "lmzldvmzl"),
			new Payload("13244667", "gghhhd", "zcbvmvnfz", "lmzldvmzl"),
			new Payload("13244667", "gghhhd", "zcbvmvnfz", "lmzldvmzl"),
			new Payload("13244667", "gghhhd", "zcbvmvnfz", "lmzldvmzl")
			
			);
	public List<Payload> getAllPayload(){
		return payload;
	}
}
