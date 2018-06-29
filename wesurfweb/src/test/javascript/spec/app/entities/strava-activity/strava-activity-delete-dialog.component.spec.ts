/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { WesurfwebTestModule } from '../../../test.module';
import { StravaActivityDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/strava-activity/strava-activity-delete-dialog.component';
import { StravaActivityService } from '../../../../../../main/webapp/app/entities/strava-activity/strava-activity.service';

describe('Component Tests', () => {

    describe('StravaActivity Management Delete Component', () => {
        let comp: StravaActivityDeleteDialogComponent;
        let fixture: ComponentFixture<StravaActivityDeleteDialogComponent>;
        let service: StravaActivityService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [WesurfwebTestModule],
                declarations: [StravaActivityDeleteDialogComponent],
                providers: [
                    StravaActivityService
                ]
            })
            .overrideTemplate(StravaActivityDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(StravaActivityDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(StravaActivityService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
