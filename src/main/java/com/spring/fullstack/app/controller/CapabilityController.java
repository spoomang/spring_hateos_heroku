package com.spring.fullstack.app.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fullstack.app.domain.Capability;
import com.spring.fullstack.app.service.CapabilityService;

@RestController
@CrossOrigin
@RequestMapping("/dashboard")
@Validated
public class CapabilityController {

	private CapabilityService service;

	public CapabilityController(CapabilityService service) {
		this.service = service;
	}

	@GetMapping("")
	public CollectionModel<?> getCapabilities() {
		List<Capability> capabilities = service.getAllCapabilities();
		return CollectionModel.of(capabilities);
	}

	@GetMapping("/{id}")
	public EntityModel<?> getCapability(@PathVariable Long id) {
		Capability capability = service.getCapabilityById(id);
		return EntityModel.of(capability, linkTo(methodOn(CapabilityController.class).getCapability(id)).withSelfRel());
	}

	@PostMapping("")
	public Object createCapability(@Valid @RequestBody Capability capability, BindingResult result) {
		
		Capability newCapability = service.saveCapability(capability);

		return EntityModel.of(newCapability,
				linkTo(methodOn(CapabilityController.class).getCapability(capability.getId())).withSelfRel());
	}
}
