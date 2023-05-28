package com.pk.rentflat.service.directMessage;

import com.pk.rentflat.controller.dto.directMessage.DirectMessageResponse;
import com.pk.rentflat.model.DirectMessage;

import java.util.List;

public interface DirectMessageService {

    DirectMessage getDirectMessageByEmail(String email);

    List<DirectMessage> getAllDirectMessages();

    DirectMessage saveDirectMessage(DirectMessage directMessage);

    void deleteDirectMessageById(Integer id);

    DirectMessage updateDirectMessageById(DirectMessage directMessage, Integer id);
}
