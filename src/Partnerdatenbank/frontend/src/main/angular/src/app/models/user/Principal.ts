import {User} from "./User";
import {Authority} from "./Authority";
import {Details} from "./Details";

export class Principal {
  authorities: Array<Authority>;
  details: Details;
  authenticated: boolean;
  principal: User;
  credentials: any;
  name: string;
}
