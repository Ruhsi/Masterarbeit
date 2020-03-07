package at.fh.se.master.partner.rest.controller;

import at.fh.se.master.partner.BackendApplicationTests;
import at.fh.se.master.partner.service.model.Address;
import at.fh.se.master.partner.service.model.Company;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = BackendApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CompanyControllerTest {

    @Autowired
    private CompanyControllerApi companyController;

    private Company hagenberg;

    @Before
    public void setUp() throws Exception {
        // given
        hagenberg = new Company();
        hagenberg.setCreditorNumber("C0000");
        hagenberg.setCreditorName("FH Oberösterreich Campus Hagenberg");
        hagenberg.setCreditorStatus('J');
        hagenberg.setShortName("JKU");
        hagenberg.setAendCounter(1);
        hagenberg.setMandant("JKU");
        hagenberg.setKontoNrSAPOld("AT 1000 2000 3000 4000 5000");

        Address hagenbergAddress = new Address();
        hagenbergAddress.setStreet("Softwarepark");
        hagenbergAddress.setStreetNumber(11);
        hagenbergAddress.setPostalCode("4232");
        hagenbergAddress.setCity("Hagenberg im Mühlkreis");
        hagenbergAddress.setCountry("Österreich");
        hagenberg.setAddress(hagenbergAddress);

        companyController.addCompany(hagenberg);
    }

    @Test
    public void getAllCompanies() {
        // when
        List<Company> found = companyController.getAllCompanies().getBody();

        // then
        assertThat(found.size()).isEqualTo(1);
        assertThat(found.get(0).getCreditorNumber()).isEqualTo(hagenberg.getCreditorNumber());
    }

    @Test
    public void addCompany() {
        // given
        Company jku = new Company();
        jku.setCreditorNumber("C1000");
        jku.setCreditorName("Johannes Kepler Universität Linz - JKU");
        jku.setCreditorStatus('J');
        jku.setShortName("JKU");
        jku.setAendCounter(1);
        jku.setMandant("JKU");
        jku.setKontoNrSAPOld("AT 1000 2000 3000 4000 5000");

        Address jkuAddress = new Address();
        jkuAddress.setStreet("Altenbergerstraße");
        jkuAddress.setStreetNumber(69);
        jkuAddress.setPostalCode("4040");
        jkuAddress.setCity("Linz");
        jkuAddress.setCountry("Österreich");
        jku.setAddress(jkuAddress);

        companyController.addCompany(jku);

        // when
        List<Company> found = companyController.getAllCompanies().getBody();

        // then
        assertThat(found.size()).isEqualTo(2);
    }

    @Test
    public void deleteCompany() {
        // when
        Company found = companyController.getAllCompanies().getBody().get(0);
        companyController.deleteCompany(found.getId());

        // then
        assertThat(companyController.getAllCompanies().getBody().size()).isEqualTo(0);
    }
}