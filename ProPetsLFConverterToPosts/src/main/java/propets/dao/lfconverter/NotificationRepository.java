package propets.dao.lfconverter;

import org.springframework.data.mongodb.repository.MongoRepository;

import propets.model.lfconverter.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {

}
