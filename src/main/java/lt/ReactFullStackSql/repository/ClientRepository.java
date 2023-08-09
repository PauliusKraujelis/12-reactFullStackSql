package lt.ReactFullStackSql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.ReactFullStackSql.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}
