package com.spring.fullstack.app.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.spring.fullstack.app.domain.Capability;
import com.spring.fullstack.app.exception.CapabilityException;
import com.spring.fullstack.app.repository.CapabilityRepository;

@Service
public class CapabilityService {

	CapabilityRepository repository;

	public CapabilityService(CapabilityRepository repository) {
		this.repository = repository;
	}

	public List<Capability> getAllCapabilities() {
		return repository.findAll();
	}

	public Capability getCapabilityById(Long id) {
		return repository.findById(id).orElseThrow(() -> new CapabilityException("The id " + id + " not found"));
	}
	
	public Capability saveCapability(Capability capability) {
		return repository.save(capability);
	}
	
}
