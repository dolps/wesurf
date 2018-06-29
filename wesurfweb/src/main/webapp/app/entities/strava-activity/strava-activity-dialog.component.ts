import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { StravaActivity } from './strava-activity.model';
import { StravaActivityPopupService } from './strava-activity-popup.service';
import { StravaActivityService } from './strava-activity.service';

@Component({
    selector: 'wes-strava-activity-dialog',
    templateUrl: './strava-activity-dialog.component.html'
})
export class StravaActivityDialogComponent implements OnInit {

    stravaActivity: StravaActivity;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private stravaActivityService: StravaActivityService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.stravaActivity.id !== undefined) {
            this.subscribeToSaveResponse(
                this.stravaActivityService.update(this.stravaActivity));
        } else {
            this.subscribeToSaveResponse(
                this.stravaActivityService.create(this.stravaActivity));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<StravaActivity>>) {
        result.subscribe((res: HttpResponse<StravaActivity>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: StravaActivity) {
        this.eventManager.broadcast({ name: 'stravaActivityListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'wes-strava-activity-popup',
    template: ''
})
export class StravaActivityPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private stravaActivityPopupService: StravaActivityPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.stravaActivityPopupService
                    .open(StravaActivityDialogComponent as Component, params['id']);
            } else {
                this.stravaActivityPopupService
                    .open(StravaActivityDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
