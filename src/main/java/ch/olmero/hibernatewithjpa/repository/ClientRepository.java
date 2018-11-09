package ch.olmero.hibernatewithjpa.repository;

import ch.olmero.hibernatewithjpa.domain.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {
}
