package com.example.acuses;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.acuses.Acuse;
import com.example.acuses.AcuseFactory;
import com.example.acuses.AcuseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class AcuseRepositoryTest {

	@Autowired
	private AcuseFactory factory;
	
	@Autowired
	private AcuseRepository acuseRepository;
	
	@Test
	public void testSave() {
		Acuse acuse = factory.createAcuse();
		Acuse a = acuseRepository.save(acuse);
		assertNotNull(a);
		assertThat(a.getId(), notNullValue());
		Acuse a2 = acuseRepository.findById(a.getId()).get();
		assertThat(a2, notNullValue());
	}

}
