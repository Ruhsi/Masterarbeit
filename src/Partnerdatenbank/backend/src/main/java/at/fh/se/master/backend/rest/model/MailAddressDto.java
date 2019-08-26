package at.fh.se.master.backend.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailAddressDto {
    private String mailAddress;
    private boolean isPrivate;
}
