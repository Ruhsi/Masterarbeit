import {Role} from "./Role";
import {Authority} from "./Authority";

export class User {
  id: number;
  email: string;
  password: string;
  name: string;
  lastName: string;
  active: number;
  roles: Array<Role>;
  enabled: boolean;
  username: string;
  authorities: Array<Authority>;
  credentialsNonExpired: boolean;
  accountNonExpired: boolean;
  accountNonLocked: boolean;
}
