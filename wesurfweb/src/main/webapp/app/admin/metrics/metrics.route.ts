import { Route } from '@angular/router';

import { WesMetricsMonitoringComponent } from './metrics.component';

export const metricsRoute: Route = {
    path: 'wes-metrics',
    component: WesMetricsMonitoringComponent,
    data: {
        pageTitle: 'metrics.title'
    }
};
