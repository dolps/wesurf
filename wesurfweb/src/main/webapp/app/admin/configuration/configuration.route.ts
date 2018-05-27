import { Route } from '@angular/router';

import { WesConfigurationComponent } from './configuration.component';

export const configurationRoute: Route = {
    path: 'wes-configuration',
    component: WesConfigurationComponent,
    data: {
        pageTitle: 'configuration.title'
    }
};
