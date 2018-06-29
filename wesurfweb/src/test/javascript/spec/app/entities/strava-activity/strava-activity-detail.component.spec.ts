/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { WesurfwebTestModule } from '../../../test.module';
import { StravaActivityDetailComponent } from '../../../../../../main/webapp/app/entities/strava-activity/strava-activity-detail.component';
import { StravaActivityService } from '../../../../../../main/webapp/app/entities/strava-activity/strava-activity.service';
import { StravaActivity } from '../../../../../../main/webapp/app/entities/strava-activity/strava-activity.model';

describe('Component Tests', () => {

    describe('StravaActivity Management Detail Component', () => {
        let comp: StravaActivityDetailComponent;
        let fixture: ComponentFixture<StravaActivityDetailComponent>;
        let service: StravaActivityService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WesurfwebTestModule],
                declarations: [StravaActivityDetailComponent],
                providers: [
                    StravaActivityService
                ]
            })
            .overrideTemplate(StravaActivityDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(StravaActivityDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(StravaActivityService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new StravaActivity(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.stravaActivity).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
