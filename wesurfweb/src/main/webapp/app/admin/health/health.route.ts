import { Route } from '@angular/router';

import { WesHealthCheckComponent } from './health.component';

export const healthRoute: Route = {
    path: 'wes-health',
    component: WesHealthCheckComponent,
    data: {
        pageTitle: 'health.title'
    }
};
