package propets.dao.lfconverter;

import org.springframework.data.mongodb.repository.MongoRepository;

import propets.model.lfconverter.LostFound;

public interface LostAndFoundRepository extends MongoRepository<LostFound, String> {

}
