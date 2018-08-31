package com.newbie.urlshortener.generator;

import org.assertj.core.api.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.newbie.urlshortener.UrlshortenerApplication;

@SpringBootTest(classes = UrlshortenerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UrlIdentifierGeneratorTest {
	
	@Autowired
	private UrlIdentifierGenerator urlIdentifierGenerator;
	
    @Test 
    public void should_generateShorterThan10AlphanumericCharactersUniqueIds() throws Exception {
    	
        //UrlIdentifierGenerator generator = context.getBean(UrlIdentifierGenerator.class);
        Set<String> urlIds = new HashSet<>();
        int numberOfIds = 10_000;

        // When
        for (int i = 0; i < numberOfIds; i++) {
            urlIds.add(urlIdentifierGenerator.generate());
        }

        // Then
        assertThat(urlIds).hasSize(numberOfIds);
        assertThat(urlIds).are(new Condition<String>(s -> s.length() <= 10, "shorter than 10 characters"));
        assertThat(urlIds).are(new Condition<String>((String s) -> {
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            return pattern.matcher(s).matches();
        }, "only composed of alphanumeric characters"));
    }

}