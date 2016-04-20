package org.teonit.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.teonit.library.domain.Organization;
import org.teonit.library.repositories.OrganizationRepository;

@RestController
@RequestMapping("organization")
public class OrganizationController {

	@Autowired
	OrganizationRepository organizationRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public void createOrganizatoin(@RequestBody Organization organization) {
		organizationRepository.save(organization);
	}
	
	@RequestMapping
	public List<Organization> getAllOrganizations() {
		List<Organization> records = (List<Organization>) organizationRepository.findAll();
		for(Organization item : records) {
			System.out.println(item);
		}
		return records;
	}
	
	@RequestMapping(path = "{name}", method=RequestMethod.DELETE)
	public void deleteLanguage(@PathVariable("name") String name) {
		Organization entity = organizationRepository.findByName(name);
		if(entity != null) {
			organizationRepository.delete(entity);
		}
	}

}
