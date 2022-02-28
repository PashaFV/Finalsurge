package models;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountFactory {

    static Faker faker = new Faker();

    public static Account get(){
        DateTimeFormatter duration = DateTimeFormatter.ofPattern("ss");
        LocalDateTime now = LocalDateTime.now();
        return Account.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.pokemon().name()+ duration.format(now) +"@testmail.by")
                .password(faker.internet().password(7, 15, true, false, true))
                .build();
    }
}
