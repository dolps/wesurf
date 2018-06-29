import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { StravaActivity } from './strava-activity.model';
import { StravaActivityPopupService } from './strava-activity-popup.service';
import { StravaActivityService } from './strava-activity.service';

@Component({
    selector: 'wes-strava-activity-delete-dialog',
    templateUrl: './strava-activity-delete-dialog.component.html'
})
export class StravaActivityDeleteDialogComponent {

    stravaActivity: StravaActivity;

    constructor(
        private stravaActivityService: StravaActivityService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.stravaActivityService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'stravaActivityListModification',
                content: 'Deleted an stravaActivity'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'wes-strava-activity-delete-popup',
    template: ''
})
export class StravaActivityDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private stravaActivityPopupService: StravaActivityPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.stravaActivityPopupService
                .open(StravaActivityDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
