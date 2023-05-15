package com.pk.rentflat.converter.directMessage;

import com.pk.rentflat.controller.dto.directMessage.DirectMessageResponse;
import com.pk.rentflat.converter.customerdetails.CustomerDetailsConverter;
import com.pk.rentflat.model.DirectMessage;

import java.util.List;

public class DirectMessageConverter {

    private DirectMessageConverter() {

    }

    public static DirectMessageResponse convertDirectMessageToDirectMessageResponse(DirectMessage directMessage) {
        DirectMessageResponse directMessageResponse = new DirectMessageResponse();
        directMessageResponse.setId(directMessageResponse.getId());
        directMessageResponse.setEmail(directMessageResponse.getEmail());
        directMessageResponse.setPhoneNumber(directMessageResponse.getPhoneNumber());
        directMessageResponse.setMessage(directMessageResponse.getMessage());
        directMessageResponse.setOwnerId(
                CustomerDetailsConverter.convertCustomerDetailsToCustomerDetailsResponse(directMessage.getCustomerDetails())
        );

        return directMessageResponse;
    }

    public static List<DirectMessageResponse> convertDirectMessageToDirectMessageResponseList(List<DirectMessage> directMessageList) {
        return directMessageList.stream()
                .map(DirectMessageConverter::convertDirectMessageToDirectMessageResponse)
                .toList();
    }
}
