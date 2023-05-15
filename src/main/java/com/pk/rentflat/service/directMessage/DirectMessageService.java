package com.pk.rentflat.service.directMessage;

import com.pk.rentflat.model.DirectMessage;

import java.util.List;

public interface DirectMessageService {

    DirectMessage getDirectMessageByEmail(String email);
}
