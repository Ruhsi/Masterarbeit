package at.fh.se.master.backend.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PartnerDto {
    private String title;
    private String firstname;
    private String lastname;
    private List<MailAddressDto> mailadresses;
    private List<PhoneNumberDto> phoneNumbers;
    private AddressDto address;
}
