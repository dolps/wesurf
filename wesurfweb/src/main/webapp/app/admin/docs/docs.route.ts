import { Route } from '@angular/router';

import { WesDocsComponent } from './docs.component';

export const docsRoute: Route = {
    path: 'docs',
    component: WesDocsComponent,
    data: {
        pageTitle: 'global.menu.admin.apidocs'
    }
};
