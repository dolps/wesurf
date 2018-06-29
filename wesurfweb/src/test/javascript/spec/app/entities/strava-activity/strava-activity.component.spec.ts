/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { WesurfwebTestModule } from '../../../test.module';
import { StravaActivityComponent } from '../../../../../../main/webapp/app/entities/strava-activity/strava-activity.component';
import { StravaActivityService } from '../../../../../../main/webapp/app/entities/strava-activity/strava-activity.service';
import { StravaActivity } from '../../../../../../main/webapp/app/entities/strava-activity/strava-activity.model';

describe('Component Tests', () => {

    describe('StravaActivity Management Component', () => {
        let comp: StravaActivityComponent;
        let fixture: ComponentFixture<StravaActivityComponent>;
        let service: StravaActivityService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WesurfwebTestModule],
                declarations: [StravaActivityComponent],
                providers: [
                    StravaActivityService
                ]
            })
            .overrideTemplate(StravaActivityComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(StravaActivityComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(StravaActivityService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new StravaActivity(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.stravaActivities[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
