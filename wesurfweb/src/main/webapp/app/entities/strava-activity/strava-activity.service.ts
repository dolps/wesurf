import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { StravaActivity } from './strava-activity.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<StravaActivity>;

@Injectable()
export class StravaActivityService {

    private resourceUrl =  SERVER_API_URL + 'api/strava-activities';

    constructor(private http: HttpClient) { }

    create(stravaActivity: StravaActivity): Observable<EntityResponseType> {
        const copy = this.convert(stravaActivity);
        return this.http.post<StravaActivity>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(stravaActivity: StravaActivity): Observable<EntityResponseType> {
        const copy = this.convert(stravaActivity);
        return this.http.put<StravaActivity>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<StravaActivity>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<StravaActivity[]>> {
        const options = createRequestOption(req);
        return this.http.get<StravaActivity[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<StravaActivity[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: StravaActivity = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<StravaActivity[]>): HttpResponse<StravaActivity[]> {
        const jsonResponse: StravaActivity[] = res.body;
        const body: StravaActivity[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to StravaActivity.
     */
    private convertItemFromServer(stravaActivity: StravaActivity): StravaActivity {
        const copy: StravaActivity = Object.assign({}, stravaActivity);
        return copy;
    }

    /**
     * Convert a StravaActivity to a JSON which can be sent to the server.
     */
    private convert(stravaActivity: StravaActivity): StravaActivity {
        const copy: StravaActivity = Object.assign({}, stravaActivity);
        return copy;
    }
}
