package com.pk.rentflat.service.directMessage.impl;

import com.pk.rentflat.model.DirectMessage;
import com.pk.rentflat.repository.DirectMessageRepository;
import com.pk.rentflat.service.directMessage.DirectMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectMessageImpl implements DirectMessageService {

    private final DirectMessageRepository directMessageRepository;

    @Override
    public DirectMessage getDirectMessageByEmail(String email) {
        return directMessageRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Message not found!"));
    }

    @Override
    public List<DirectMessage> getAllDirectMessages() {
        return directMessageRepository.findAll();
    }

    @Override
    public DirectMessage saveDirectMessage(DirectMessage directMessage) {
        return directMessageRepository.save(directMessage);
    }

    @Override
    public void deleteDirectMessageById(Integer id) {
        directMessageRepository.deleteById(id);
    }
    @Override
    public DirectMessage updateDirectMessageById(DirectMessage directMessage, Integer id) {
        return directMessageRepository.save(directMessage);
    }
}
