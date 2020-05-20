package com.algaworks.algafoodapi;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class).web(WebApplicationType.NONE)
                                                                                                          .run(args);

        applicationContext.getBeansOfType(JpaRepository.class)
                          .values()
                          .forEach(x -> printAll(x));
    }

    private static void printAll(JpaRepository jpaRepository) {
        jpaRepository.findAll()
                     .forEach(System.out::println);
    }

}
