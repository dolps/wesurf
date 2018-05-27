import { NgModule, LOCALE_ID } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { registerLocaleData } from '@angular/common';
import locale from '@angular/common/locales/en';

import {
    WesurfwebSharedLibsModule,
    JhiLanguageHelper,
    FindLanguageFromKeyPipe,
    WesAlertComponent,
    WesAlertErrorComponent
} from './';

@NgModule({
    imports: [
        WesurfwebSharedLibsModule
    ],
    declarations: [
        FindLanguageFromKeyPipe,
        WesAlertComponent,
        WesAlertErrorComponent
    ],
    providers: [
        JhiLanguageHelper,
        Title,
        {
            provide: LOCALE_ID,
            useValue: 'en'
        },
    ],
    exports: [
        WesurfwebSharedLibsModule,
        FindLanguageFromKeyPipe,
        WesAlertComponent,
        WesAlertErrorComponent
    ]
})
export class WesurfwebSharedCommonModule {
    constructor() {
        registerLocaleData(locale);
    }
}
