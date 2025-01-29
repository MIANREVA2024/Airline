package com.reyestech24.Airline.Config;

import com.reyestech24.Airline.facade.encryptions.Base64System;
import com.reyestech24.Airline.facade.encryptions.BcryptSystem;
import com.reyestech24.Airline.facade.encryptions.EncryptionFacade;
import com.reyestech24.Airline.facade.encryptions.IEncryptFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeansConfiguration {

    @Bean
    public BcryptSystem bcryptSystem() {
        return new BcryptSystem(new BCryptPasswordEncoder());
    }

    @Bean
    public Base64System base64System() {
        return new Base64System();
    }

    public IEncryptFacade encryptFacade() {
        return new EncryptionFacade(new BCryptPasswordEncoder(), base64System());
    }

}