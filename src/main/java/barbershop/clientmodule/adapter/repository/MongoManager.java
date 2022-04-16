package barbershop.clientmodule.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import barbershop.clientmodule.adapter.repository.model.ClientRecord;

@Repository
public interface MongoManager extends MongoRepository<ClientRecord, String> {

}
