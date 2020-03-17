package at.fh.se.master.docsis.rest.controller;

import at.fh.se.master.docsis.BackendApplicationTests;
import at.fh.se.master.docsis.rest.repository.CompanyRepository;
import at.fh.se.master.docsis.service.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = BackendApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PartnerControllerTest {

    @Autowired
    private PartnerControllerApi partnerController;

    @Autowired
    private CompanyRepository companyRepository;

    private Company hagenberg;

    private Partner affenzeller;

    @Before
    public void setUp() throws Exception {
        // given
        addTestCompany();
        addTestPartner();
    }

    @Test
    public void getAllPartners() {
        // when
        List<Partner> found = partnerController.getAllPartners().getBody();

        // then
        assertThat(found.size()).isEqualTo(1);
    }

    @Test
    public void addPartner() {
        // given
        Partner altrichter = new Partner();
        altrichter.setFirstname("Herbert");
        altrichter.setLastname("Altrichter");
        altrichter.setTitleBefore("o. Univ.-Prof. Dr.");
        altrichter.setAddress(new Address() {{
            setStreet("Keplergebäude");
            setStreetNumber(1);
            setPostalCode("4192");
            setCity("Linz");
            setCountry("Österreich");
        }});

        Set<MailAddress> mails = new HashSet<>();
        mails.add(
                new MailAddress() {{
                    setMailAddress("herbert.altrichter@jku.at");
                    setPrivate(false);
                }}
        );
        altrichter.setMailadresses(mails);

        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        phoneNumbers.add(
                new PhoneNumber() {{
                    setPhoneNumber("+43 732 2468 7241");
                    setPrivate(false);
                }}
        );
        altrichter.setPhoneNumbers(phoneNumbers);
        altrichter.setTopic("Schulentwicklung und Governance des Bildungswesens");
        hagenberg.getPartners().add(altrichter);
        partnerController.addPartner(hagenberg.getId(), altrichter);

        // when
        List<Partner> found = partnerController.getAllPartners().getBody();

        // then
        assertThat(found.size()).isEqualTo(2);
    }

    @Test
    public void deletePartner() {
        // given
        Partner partner = partnerController.getAllPartners().getBody().get(0);

        // when
        partnerController.deletePartner(partner.getId());

        // then
        assertThat(partnerController.getAllPartners().getBody().size()).isEqualTo(0);
    }

    private void addTestCompany() {
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
    }

    private void addTestPartner() {
        affenzeller = new Partner();
        affenzeller.setFirstname("Michael");
        affenzeller.setLastname("Affenzeller");
        affenzeller.setTitleBefore("FH-Prof. PD DI Dr.");
        affenzeller.setAddress(null);

        Set<MailAddress> mails = new HashSet<>();
        mails.add(
                new MailAddress() {{
                    setMailAddress("michael.affenzeller@fh-hagenberg.at");
                    setPrivate(false);
                }}
        );
        affenzeller.setMailadresses(mails);

        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        phoneNumbers.add(
                new PhoneNumber() {{
                    setPhoneNumber("+43 5 0804 22031");
                    setPrivate(false);
                }}
        );
        affenzeller.setPhoneNumbers(phoneNumbers);
        affenzeller.setTopic("Professor of Heuristic Optimisation/Machine Learning");

        hagenberg.setPartners(new ArrayList<>());
        hagenberg.getPartners().add(affenzeller);
        companyRepository.save(hagenberg);
    }
}