export interface UserModel {
  id: number;
  username: string;
  password: string | undefined;
  login: string,
  email: string;
  name?: string;
  phone: string;
  roles?: Array<number>;
  timzeZone?: string;
  address: UserAddressModel;
  auth?: AuthModel;
  socialNetworks?: UserSocialNetworksModel
  communication?: UserCommunicationModel
}

export interface AuthModel {
  api_token: string;
  refreshToken?: string;
}

export interface UserAddressModel {
  addressLine: string;
  city: string;
  state: string;
  postCode: string;
}

export interface UserSocialNetworksModel {
  linkedIn: string;
  facebook: string;
  twitter: string;
  instagram: string;
}

export interface UserCommunicationModel {
    email: boolean
    sms: boolean
    phone: boolean
  }