package com.pk.rentflat.service.auth;

import com.pk.rentflat.controller.dto.auth.AuthenticationRequest;
import com.pk.rentflat.controller.dto.auth.AuthenticationResponse;
import com.pk.rentflat.controller.dto.auth.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
