package com.micro.notificationservice.repositories;


import com.micro.notificationservice.entities.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends MongoRepository<Notification, String> {
}