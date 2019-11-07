import {PhoneNumber} from "./PhoneNumber";
import {MailAddress} from "./MailAddress";
import {Address} from "./Address";

export class Partner {
  id: number;
  titleBefore: string;
  titleAfter: string;
  firstname: string;
  lastname: string;
  mailadresses: Array<MailAddress>;
  phoneNumbers: Array<PhoneNumber>;
  address: Address;
  topic: string;
}
