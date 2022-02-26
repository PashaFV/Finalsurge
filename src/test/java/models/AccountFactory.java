package models;

import com.github.javafaker.Faker;

public class AccountFactory {

    static Faker faker = new Faker();

    public static Account get(){
        return Account.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.pokemon().name()+"@testmail.by")
                .password(faker.internet().password(7, 15, true, false, true))
                .build();
    }
}
