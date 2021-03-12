package ca.gbc.comp3095.comp3095rockstars.services;

import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Set<Message> findAllAdmins(){
        Set<Message> messages = new HashSet<>(messageRepository.findAll());

        Set<Message> clientMessages = new java.util.HashSet<>(Collections.emptySet());

        for (Message message:messages) {
            if(message.getToWho().equals("admin@isp.net")){
                clientMessages.add(message);
            }
        }
        return clientMessages;
    }


    @Override
    public Set<Message> findAll() {
        Set<Message> messages = new HashSet<>(messageRepository.findAll());
        return messages;
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Message object) {
        messageRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        messageRepository.deleteById(aLong);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
