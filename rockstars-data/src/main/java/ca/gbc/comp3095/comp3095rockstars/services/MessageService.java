package ca.gbc.comp3095.comp3095rockstars.services;

import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.model.RegistrationForm;
import ca.gbc.comp3095.comp3095rockstars.model.User;

import java.util.Set;


public interface MessageService extends CrudService<Message, Long>{
    Message save(Message message);

    Set<Message> findAllAdmins();
}
