package com.pk.rentflat.controller.dto.directMessage;


import com.pk.rentflat.converter.directMessage.DirectMessageConverter;
import com.pk.rentflat.model.DirectMessage;
import com.pk.rentflat.service.directMessage.DirectMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/direct_messages")
@CrossOrigin(origins = "*")
public class DirectMessageController {

    private final DirectMessageService directMessageService;

    @GetMapping
    public DirectMessageResponse getDirectMessagesByEmail(String email) {
        return DirectMessageConverter.convertDirectMessageToDirectMessageResponse(directMessageService.getDirectMessageByEmail(email));
    }

    @GetMapping
    public List<DirectMessageResponse> getAllDirectMessages() {
        return DirectMessageConverter.convertDirectMessageToDirectMessageResponseList(directMessageService.getAllDirectMessages());
    }

    @PostMapping
    public DirectMessageResponse saveDirectMessage(DirectMessage directMessage) {
        return DirectMessageConverter.convertDirectMessageToDirectMessageResponse(directMessageService.saveDirectMessage(directMessage));
    }

    @DeleteMapping
    void deleteDirectMessageById(Integer id) {
        directMessageService.deleteDirectMessageById(id);
    }

    @PutMapping
    public DirectMessageResponse updateDirectMessageByEmail(DirectMessage directMessage, Integer id) {
        return DirectMessageConverter.convertDirectMessageToDirectMessageResponse(directMessageService.updateDirectMessageById(directMessage, id));
    }
}
