import { Injectable } from '@angular/core';
import Keycloak from 'keycloak-js';
import { UserProfile } from './user-profile';

@Injectable({
  providedIn: 'root',
})
export class KeycloakService {
  private _keycloak: Keycloak | undefined;

  get keycloak() {
    if (!this._keycloak) {
      this._keycloak = new Keycloak({
        url: 'http://192.168.56.102:9095',
        realm: 'eCommerce',
        clientId: 'ghada',
      });
    }
    return this._keycloak;
  }

  private _profile: UserProfile | undefined;

  get profile(): UserProfile | undefined {
    return this._profile;
  }

  async init() {
    const authenticated = await this.keycloak.init({
      onLoad: 'login-required',
    });

    if (authenticated) {
      this._profile = (await this.keycloak.loadUserProfile()) as UserProfile;
      console.log('Usssser: ' + JSON.stringify(this._profile));

      const websiteClientRoleArray =
        this._profile.attributes?.websiteClientRole || [];
      const websiteClientRole =
        websiteClientRoleArray.length > 0 ? websiteClientRoleArray[0] : null;
      console.log('Website Client Role: ', websiteClientRole);
      localStorage.setItem(
        'websiteClientRole',
        JSON.stringify(websiteClientRole)
      );

      this._profile.token = this.keycloak.token || '';
      console.log('Tokeeeen ' + this._profile.token);
      localStorage.setItem('token', this._profile.token);
    }
  }

  login() {
    return this.keycloak.login();
  }

  logout() {
    return this.keycloak.logout({ redirectUri: 'http://localhost:4200' });
  }
}
