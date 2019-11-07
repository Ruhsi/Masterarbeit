import {Address} from '../partner/Address';
import {Partner} from '../partner/Partner';

export class Company {
  id: number;
  mandant: string;
  address: Address;
  partners: Array<Partner>;
  creditorNumber: string;
  creditorName: string;
  creditorStatus: string;
  kontoNrSAPOld: string;
  shortName: string;
  aendCounter: number;
}
