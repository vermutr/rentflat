package com.pk.rentflat.controller.dto.directMessage;

import com.pk.rentflat.controller.dto.customers.CustomerDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectMessageResponse {

    private Integer id;

    private CustomerDetailsResponse ownerId;

    private String email;

    private String phoneNumber;

    private String message;
}
