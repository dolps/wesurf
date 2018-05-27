import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {errorRoute, navbarRoute} from './layouts';
import {DEBUG_INFO_ENABLED} from './app.constants';
import {oAuthRedirectRoute} from './app.route';

const LAYOUT_ROUTES = [
    navbarRoute,
    oAuthRedirectRoute,
    ...errorRoute
];

@NgModule({
    imports: [
        RouterModule.forRoot(LAYOUT_ROUTES, {useHash: true, enableTracing: DEBUG_INFO_ENABLED})
    ],
    exports: [
        RouterModule
    ]
})
export class WesurfwebAppRoutingModule {
}
