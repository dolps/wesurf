import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WesurfwebSharedModule } from '../shared';
/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */

import {
    adminState,
    AuditsComponent,
    LogsComponent,
    WesMetricsMonitoringModalComponent,
    WesMetricsMonitoringComponent,
    WesHealthModalComponent,
    WesHealthCheckComponent,
    WesConfigurationComponent,
    WesDocsComponent,
    AuditsService,
    WesConfigurationService,
    WesHealthService,
    WesMetricsService,
    LogsService,
} from './';

@NgModule({
    imports: [
        WesurfwebSharedModule,
        RouterModule.forChild(adminState),
        /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    ],
    declarations: [
        AuditsComponent,
        LogsComponent,
        WesConfigurationComponent,
        WesHealthCheckComponent,
        WesHealthModalComponent,
        WesDocsComponent,
        WesMetricsMonitoringComponent,
        WesMetricsMonitoringModalComponent
    ],
    entryComponents: [
        WesHealthModalComponent,
        WesMetricsMonitoringModalComponent,
    ],
    providers: [
        AuditsService,
        WesConfigurationService,
        WesHealthService,
        WesMetricsService,
        LogsService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WesurfwebAdminModule {}
