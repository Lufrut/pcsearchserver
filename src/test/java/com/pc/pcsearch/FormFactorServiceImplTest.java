package com.pc.pcsearch;
import com.pc.pcsearch.models.buildpc.FormFactor;
import com.pc.pcsearch.services.FormFactorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FormFactorServiceImplTest {

    @Autowired
    private FormFactorService formFactorService;

    @Test
    public void testCreate() {
        FormFactor formFactor = new FormFactor();
        formFactor.setName("Name");
        FormFactor createdFormFactor = formFactorService.create(formFactor);

        assertNotNull(createdFormFactor);
        assertNotNull(createdFormFactor.getId());

        formFactorService.delete(createdFormFactor.getId());

    }

    @Test
    public void testGetOne() {
        FormFactor formFactor = new FormFactor(/* provide necessary constructor arguments */);
        formFactor.setName("Name");
        FormFactor createdFormFactor = formFactorService.create(formFactor);

        Optional<FormFactor> retrievedFormFactor = formFactorService.getOne(createdFormFactor.getId());

        assertNotNull(retrievedFormFactor);
        assertTrue(retrievedFormFactor.isPresent());
        formFactorService.delete(createdFormFactor.getId());

    }

    @Test
    public void testGetAll() {
        List<FormFactor> formFactors = formFactorService.getAll();
    }

    @Test
    public void testUpdate() {
        FormFactor formFactor = new FormFactor(/* provide necessary constructor arguments */);
        FormFactor createdFormFactor = formFactorService.create(formFactor);

        createdFormFactor.setName("Updated Name");
        FormFactor updatedFormFactor = formFactorService.update(createdFormFactor, createdFormFactor.getId());

        assertNotNull(updatedFormFactor);
        assertEquals("Updated Name", updatedFormFactor.getName());

        formFactorService.delete(createdFormFactor.getId());
    }

    @Test
    public void testDelete() {
        FormFactor formFactor = new FormFactor();
        FormFactor createdFormFactor = formFactorService.create(formFactor);

        formFactorService.delete(createdFormFactor.getId());

        Optional<FormFactor> retrievedFormFactor = formFactorService.getOne(createdFormFactor.getId());

        assertNotNull(retrievedFormFactor);
        assertFalse(retrievedFormFactor.isPresent());
    }
}

