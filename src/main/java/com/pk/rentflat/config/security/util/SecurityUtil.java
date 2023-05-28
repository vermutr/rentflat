package com.pk.rentflat.config.security.util;


import com.pk.rentflat.model.Customers;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    private SecurityUtil() {

    }

    public static Integer getCustomerId() {
        return ((Customers) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

}
