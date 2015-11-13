package me.joshua.arsenal4j.spring.dal.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("me.joshua.arsenal4j.spring.dal.jpa.repo")
public class RepoConfig {

}
