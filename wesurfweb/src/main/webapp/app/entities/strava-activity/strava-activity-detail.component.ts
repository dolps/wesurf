import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { StravaActivity } from './strava-activity.model';
import { StravaActivityService } from './strava-activity.service';

@Component({
    selector: 'wes-strava-activity-detail',
    templateUrl: './strava-activity-detail.component.html'
})
export class StravaActivityDetailComponent implements OnInit, OnDestroy {

    stravaActivity: StravaActivity;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private stravaActivityService: StravaActivityService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInStravaActivities();
    }

    load(id) {
        this.stravaActivityService.find(id)
            .subscribe((stravaActivityResponse: HttpResponse<StravaActivity>) => {
                this.stravaActivity = stravaActivityResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInStravaActivities() {
        this.eventSubscriber = this.eventManager.subscribe(
            'stravaActivityListModification',
            (response) => this.load(this.stravaActivity.id)
        );
    }
}
