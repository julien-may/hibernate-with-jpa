package ch.olmero.hibernatewithjpa.controller;

import ch.olmero.hibernatewithjpa.domain.Client;
import ch.olmero.hibernatewithjpa.repository.ClientRepository;
import ch.olmero.hibernatewithjpa.repository.ProductDao;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	private final ClientRepository clientRepository;
	private final ProductDao productDao;

	public ClientController(ClientRepository clientRepository, ProductDao productDao) {
		this.clientRepository = clientRepository;
		this.productDao = productDao;
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	@Transactional
	public void gna() {
		final Iterable<Client> all = this.clientRepository.findAll();
		this.productDao.getByName("test");
	}
}
