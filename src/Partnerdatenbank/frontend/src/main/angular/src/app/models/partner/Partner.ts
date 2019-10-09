import {PhoneNumber} from "./PhoneNumber";
import {MailAddress} from "./MailAddress";
import {Address} from "./Address";

export class Partner {
  title: string;
  firstname: string;
  lastname: string;
  mailadresses: Array<MailAddress>;
  phoneNumbers: Array<PhoneNumber>;
  address: Address;
}
